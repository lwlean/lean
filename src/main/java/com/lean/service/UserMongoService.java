package com.lean.service;


import com.lean.domain.Batch;
import com.lean.domain.Sample;
import com.mongodb.DBObject;

import java.util.List;

public interface UserMongoService {


    void addBatchNum(Batch batch);

    void addVirtualNum(Sample sample);

    DBObject getBatchNumByBatch(String batch);

    List<DBObject> getBatchNum();

    List<DBObject> getVirtualNum(String virtualNum);

    int updateBatchNum(String batch, String num);

    DBObject getUserByName(String name);

}
