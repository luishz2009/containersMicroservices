package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "microservice-student", url = "localhost:8090/api/student") //Para que funcione con eureka
@FeignClient(name = "microservice-student",  url = "localhost:8080/api/student") //Para que funcione con el gateway
public interface StudentClient {

    @GetMapping("/findByIdCourse/{idCourse}")
    List<StudentDTO> findAllStudentByIdCourse(@PathVariable Long idCourse);

}
