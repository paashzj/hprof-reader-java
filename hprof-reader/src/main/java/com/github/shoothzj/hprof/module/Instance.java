package com.github.shoothzj.hprof.module;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hezhangjian
 */
@Slf4j
@Data
public class Instance {

    private String clazzName;

    public Instance() {
    }
}
