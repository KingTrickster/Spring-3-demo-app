package com.trxjster.spring3demo.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GreetController {

    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse("Hello", List.of("Java", "Python", "C#"), new Person("Alex"));
    }

    record Person(String name){}
    record GreetResponse(String greeting, List<String> favProgrammingLanguages, Person person){}
}
