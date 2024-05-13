package com.microservice.student.controller;

import com.microservice.student.controller.dto.StudentDTO;
import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody StudentDTO studentDTO){
        Optional<Student> studentOptional = Optional.ofNullable(studentService.findById(id));
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(studentDTO.getName());
            student.setLastName(studentDTO.getLastName());
            student.setEmail(studentDTO.getEmail());
            student.setCourseId(studentDTO.getCourseId());
            studentService.save(student);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
       if (id != null){
           studentService.deleteById(id);
           return ResponseEntity.ok("Registro eliminado");
       }
       return ResponseEntity.badRequest().build();
    }
    @GetMapping("/findByIdCourse/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }
}
