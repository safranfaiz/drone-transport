package com.safran.dronetransport.controller;

import com.safran.dronetransport.entity.DispatchLoad;
import com.safran.dronetransport.service.DispatchLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    DispatchLoadService dispatchLoadService;

    @GetMapping("/tet")
    public List<DispatchLoad> test(){
        return dispatchLoadService.findAll();
    }

//    @GetMapping("/save")
//    public DispatchLoad ddd(){
//        return dispatchLoadService.createDispatch();
//    }
}
