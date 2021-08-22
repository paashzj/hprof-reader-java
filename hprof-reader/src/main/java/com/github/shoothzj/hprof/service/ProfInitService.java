package com.github.shoothzj.hprof.service;

import com.github.shoothzj.hprof.config.HprofConfig;
import edu.tufts.eaftan.hprofparser.parser.HprofParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class ProfInitService {

    @Autowired
    private ProfService profService;

    @Autowired
    private HprofConfig hprofConfig;

    @PostConstruct
    public void readProfFromFile() throws Exception {
        HprofParser parser = new HprofParser(profService);
        parser.parse(new File(hprofConfig.profPath));
    }

}
