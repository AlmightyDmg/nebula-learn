package com.dmg.nebulalearn.controller;

import java.util.List;

import javax.annotation.Resource;

import com.dmg.nebulalearn.model.vertex.Country;
import com.dmg.nebulalearn.service.MyTestServiceImpl;
import com.vesoft.nebula.client.graph.data.ResultSet;
import io.github.anyzm.graph.ocean.domain.impl.QueryResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class MyTestController {

    @Resource
    private MyTestServiceImpl myTestService;

    @GetMapping("/insertVertexAndEdge")
    public void insertVertexAndEdge() {
        myTestService.insertVertexAndEdge();
    }

    @PostMapping("/insertCountryVertex")
    public boolean insertCountryVertex(@RequestBody Country country) {
        return myTestService.insertCountryVertex(country);
    }

    @GetMapping("/getAllCountry")
    public List<Country> getAllCountry(){
        List<Country> allCountry = myTestService.getAllCountry();
        return allCountry;
    }

    @GetMapping("/getSubGraph")
    public void getSubGraph(){
        myTestService.getSubGraph();
    }
}
