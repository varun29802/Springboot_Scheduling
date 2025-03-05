package com.project.scheduling.controller;

import com.project.scheduling.service.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public Scheduler scheduler;

    public MainController(Scheduler scheduler){
        this.scheduler=scheduler;
    }

    @GetMapping("/")
    public String applicationStart(){
        return "Scheduled task has started!!";
    }

}

