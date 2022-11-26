package com.example.microservicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservicios.Student;
import com.example.microservicios.RegistrationService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RequestMapping("adminDept")
@AllArgsConstructor
@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @GetMapping
    public Flux<Student> getAll() {
        System.out.println("::GET_ALL Students::");
        return registrationService.getAll();
    }
    @GetMapping("{id}")
    public Mono<Student> getById(@PathVariable("id") final String id) {
        System.out.println("::Will Return a Student::");
        return registrationService.getById(id);
    }
    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Student student) {
        System.out.println("::Update the Student record::");
        return registrationService.update(id, student);
    }
    @PostMapping
    public Mono save(@RequestBody final Student student) {
        System.out.println("Will register the student :: "+ student.getId() + " :: " + student.getFirstName());
        return registrationService.save(student);
    }
    @DeleteMapping("{id}")
    public Mono delete(@PathVariable final String id) {
        System.out.println("::Will delete a Student::");
        return registrationService.delete(id);
    }
}