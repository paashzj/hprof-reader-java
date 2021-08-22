package com.github.shoothzj.hprof.service;

import com.github.shoothzj.hprof.module.Instance;
import edu.tufts.eaftan.hprofparser.parser.datastructures.Type;
import edu.tufts.eaftan.hprofparser.parser.datastructures.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class InstanceService {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private StringService stringService;

    private Map<Long, Instance> map = new HashMap<>();

    private Map<Long, Value<?>[]> valueMap = new HashMap<>();

    public void put(long objId, long classObjId, ClazzService clazzService, Value<?>[] instanceFieldValues) {
        final String className = clazzService.get(classObjId);
        log.debug("objId {} className {}", objId, className);
        final Instance instance = new Instance();
        instance.setClazzName(className);
        valueMap.put(objId, instanceFieldValues);
        map.put(objId, instance);
        recursiveGetVal(objId, 3);
    }

    public void recursiveGetVal(long objId, int maxDepth) {
        final Value<?>[] values = valueMap.get(objId);
        if (values == null) {
            return;
        }
        for (Value<?> value : values) {
            final Type valueType = value.type;
            final Object val = value.value;
            if (Type.BOOL.equals(valueType)) {
                boolean var = (boolean) val;
                log.debug("value {}", var);
            }
            if (Type.CHAR.equals(valueType)) {
                char var = (char) val;
                log.debug("value {}", var);
            }
            if (Type.FLOAT.equals(valueType)) {
                float var = (float) val;
                log.debug("value {}", var);
            }
            if (Type.DOUBLE.equals(valueType)) {
                double var = (double) val;
                log.debug("value {}", val);
            }
            if (Type.BYTE.equals(valueType)) {
                byte var = (byte) val;
                log.debug("value {}", var);
            }
            if (Type.SHORT.equals(valueType)) {
                short var = (short) val;
                log.debug("value {}", var);
            }
            if (Type.INT.equals(valueType)) {
                int var = (int) val;
                log.debug("value {}", var);
            }
            if (Type.LONG.equals(valueType)) {
                long var = (long) val;
                log.debug("value {}", var);
            }
            if (Type.OBJ.equals(valueType)) {
                long childObjId = (long) val;
                if (maxDepth > 0) {
                    recursiveGetVal(childObjId, maxDepth -1);
                }
            }
        }
    }

}
