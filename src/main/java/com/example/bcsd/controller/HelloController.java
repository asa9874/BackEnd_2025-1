package com.example.bcsd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!!!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "introduce";
    }

    @GetMapping("/introduce2")
    @ResponseBody
    public String introduce2(@RequestParam("name") String name) {
        return "hello " + name + "!";
    }

    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        Person person = new Person("허준기", 25);
        return person;
    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

}
