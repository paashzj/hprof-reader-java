package com.github.shoothzj.hprof.module.http;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
@AllArgsConstructor
public class GetClassResp {

    private String className;

    public GetClassResp() {
    }
}
