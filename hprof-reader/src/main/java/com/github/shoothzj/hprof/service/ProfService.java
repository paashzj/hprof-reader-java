package com.github.shoothzj.hprof.service;

import edu.tufts.eaftan.hprofparser.handler.RecordHandler;
import edu.tufts.eaftan.hprofparser.parser.datastructures.AllocSite;
import edu.tufts.eaftan.hprofparser.parser.datastructures.CPUSample;
import edu.tufts.eaftan.hprofparser.parser.datastructures.Constant;
import edu.tufts.eaftan.hprofparser.parser.datastructures.InstanceField;
import edu.tufts.eaftan.hprofparser.parser.datastructures.Static;
import edu.tufts.eaftan.hprofparser.parser.datastructures.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class ProfService implements RecordHandler {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private StringService stringService;


    @Override
    public void header(String format, int idSize, long time) {

    }

    @Override
    public void stringInUTF8(long id, String data) {
        log.debug("str id is {} data is {}", id, data);
        stringService.put(id, data);
    }

    @Override
    public void loadClass(int classSerialNum, long classObjId, int stackTraceSerialNum, long classNameStringId) {
        String className = stringService.get(classNameStringId);
        log.debug("load class {}", className);
        clazzService.put(classSerialNum, classObjId, className);
    }

    @Override
    public void unloadClass(int classSerialNum) {
        clazzService.remove(classSerialNum);
    }

    @Override
    public void stackFrame(long stackFrameId, long methodNameStringId, long methodSigStringId, long sourceFileNameStringId, int classSerialNum, int location) {

    }

    @Override
    public void stackTrace(int stackTraceSerialNum, int threadSerialNum, int numFrames, long[] stackFrameIds) {

    }

    @Override
    public void allocSites(short bitMaskFlags, float cutoffRatio, int totalLiveBytes, int totalLiveInstances, long totalBytesAllocated, long totalInstancesAllocated, AllocSite[] sites) {

    }

    @Override
    public void heapSummary(int totalLiveBytes, int totalLiveInstances, long totalBytesAllocated, long totalInstancesAllocated) {

    }

    @Override
    public void startThread(int threadSerialNum, long threadObjectId, int stackTraceSerialNum, long threadNameStringId, long threadGroupNameId, long threadParentGroupNameId) {

    }

    @Override
    public void endThread(int threadSerialNum) {

    }

    @Override
    public void heapDump() {

    }

    @Override
    public void heapDumpEnd() {

    }

    @Override
    public void heapDumpSegment() {

    }

    @Override
    public void cpuSamples(int totalNumOfSamples, CPUSample[] samples) {

    }

    @Override
    public void controlSettings(int bitMaskFlags, short stackTraceDepth) {

    }

    @Override
    public void rootUnknown(long objId) {

    }

    @Override
    public void rootJNIGlobal(long objId, long JNIGlobalRefId) {

    }

    @Override
    public void rootJNILocal(long objId, int threadSerialNum, int frameNum) {

    }

    @Override
    public void rootJavaFrame(long objId, int threadSerialNum, int frameNum) {

    }

    @Override
    public void rootNativeStack(long objId, int threadSerialNum) {

    }

    @Override
    public void rootStickyClass(long objId) {

    }

    @Override
    public void rootThreadBlock(long objId, int threadSerialNum) {

    }

    @Override
    public void rootMonitorUsed(long objId) {

    }

    @Override
    public void rootThreadObj(long objId, int threadSerialNum, int stackTraceSerialNum) {

    }

    @Override
    public void classDump(long classObjId, int stackTraceSerialNum, long superClassObjId, long classLoaderObjId, long signersObjId, long protectionDomainObjId, long reserved1, long reserved2, int instanceSize, Constant[] constants, Static[] statics, InstanceField[] instanceFields) {
        log.debug("class dump {}", classObjId);
    }

    @Override
    public void instanceDump(long objId, int stackTraceSerialNum, long classObjId, Value<?>[] instanceFieldValues) {
        log.debug("objId is {}", objId);
        instanceService.put(objId, classObjId, clazzService, instanceFieldValues);
    }

    @Override
    public void objArrayDump(long objId, int stackTraceSerialNum, long elemClassObjId, long[] elems) {

    }

    @Override
    public void primArrayDump(long objId, int stackTraceSerialNum, byte elemType, Value<?>[] elems) {

    }

    @Override
    public void finished() {

    }

}
