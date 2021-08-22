package com.github.shoothzj.hprof.service;

import com.github.shoothzj.hprof.module.http.GetClassResp;
import com.github.shoothzj.hprof.module.http.GetClassRespList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class ClazzService {

    private final Map<Integer, String> serialMap = new HashMap<>();

    private final Map<Long, String> objMap = new HashMap<>();

    public void put(int serial, long objId, String className) {
        serialMap.put(serial, className);
        objMap.put(objId, className);
    }

    public void remove(int serial) {

    }

    public String get(long objId) {
        return objMap.get(objId);
    }

    public List<String> getClassRespList() {
        return objMap.values().stream().collect(Collectors.toList());
    }

}
