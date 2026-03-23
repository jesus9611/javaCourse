package com.in28minutes.spring.learn_spring_framework.enterprise.example;

import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    public long returnValueFromBusinessService(){

        return 200;
    }
}
