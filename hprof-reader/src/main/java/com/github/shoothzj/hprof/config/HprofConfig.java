package com.github.shoothzj.hprof.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author hezhangjian
 */
@Configuration
@Service
public class HprofConfig {

    @Value("${PROF_PATH}")
    public String profPath;

}
