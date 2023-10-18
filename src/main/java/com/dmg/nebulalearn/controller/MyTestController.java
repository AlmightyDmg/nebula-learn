package com.dmg.nebulalearn.controller;

import javax.annotation.Resource;

import com.dmg.nebulalearn.service.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class MyTestController {

    @Resource
    private PersonServiceImpl personService;

    @GetMapping("/insertVertexAndEdge")
    public void insertVertexAndEdge() {
        personService.insertVertexAndEdge();
    }
}
