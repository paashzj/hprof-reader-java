package com.github.shoothzj.hprof.module.http;

import lombok.Data;

import java.util.List;

/**
 * @author hezhangjian
 */
@Data
public class GetClassRespList {

    private List<GetClassResp> getClassRespList;

    public GetClassRespList() {
    }
}
