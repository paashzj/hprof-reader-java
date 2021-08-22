package com.github.shoothzj.hprof.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class StringService {

    private final Map<Long, String> map = new HashMap<>();

    public void put(Long id, String data) {
        map.put(id, data);
    }

    public String get(Long id) {
        return map.get(id);
    }

}
