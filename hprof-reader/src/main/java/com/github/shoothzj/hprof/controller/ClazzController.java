package com.github.shoothzj.hprof.controller;

import com.github.shoothzj.hprof.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping(path = "/v1/hprof/classes")
    public List<String> getClazz() {
        return clazzService.getClassRespList();
    }

}
