package com.lean.service.impl;

import com.lean.domain.Batch;
import com.lean.domain.Sample;
import com.lean.service.UserMongoService;
import com.lean.util.Utils;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMongoServiceImpl implements UserMongoService{


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void addBatchNum(Batch batch) {
        DBObject batchObject = new BasicDBObject();
        batchObject.put("_id", Utils.getUniqueid());
        batchObject.put("time", batch.getTime());
        batchObject.put("count", batch.getCount());
        batchObject.put("userCode", batch.getUserCode());
        batchObject.put("batch", batch.getBatch());
        batchObject.put("extracted", batch.getExtracted());
        batchObject.put("type", batch.getType());

        final WriteResult batch1 = mongoTemplate.getCollection("batch").insert(batchObject);
    }

    @Override
    public void addVirtualNum(Sample sample) {
        DBObject virtualNumObject = new BasicDBObject();
        virtualNumObject.put("_id", Utils.getUniqueid());
        virtualNumObject.put("explanation", sample.getExplanation());
        virtualNumObject.put("lostusername", sample.getLostusername());
        virtualNumObject.put("usermode", sample.getUsermode());
        virtualNumObject.put("lostusernum", sample.getLostusernum());
        virtualNumObject.put("city", sample.getCity());
        virtualNumObject.put("lostusercity", sample.getLostusercity());
        virtualNumObject.put("time", sample.getTime());
        virtualNumObject.put("losttime", sample.getLosttime());
        virtualNumObject.put("batch", sample.getBatch());
        virtualNumObject.put("lostuseridcard",sample.getLostuseridcard());
        virtualNumObject.put("virtualid", sample.getVirtualid());
        virtualNumObject.put("virtualnum", sample.getVirtualnum());
        virtualNumObject.put("name", sample.getName());
        virtualNumObject.put("brands", sample.getBrands());

        final WriteResult smapleResult = mongoTemplate.getCollection("sample").insert(virtualNumObject);
    }

    @Override
    public DBObject getBatchNumByBatch(String batch) {
        DBObject query = new BasicDBObject();
        query.put("batch", batch);
        final DBObject batchNum = mongoTemplate.getCollection("batch").findOne(query);
        return batchNum;
    }

    @Override
    public List<DBObject> getBatchNum() {
        final DBCursor batch = mongoTemplate.getCollection("batch").find();
        List<DBObject> list = new ArrayList<>();
        batch.forEach(dbObject -> {
            list.add(dbObject);
        });
        return list;
    }

    @Override
    public List<DBObject> getVirtualNum(String virtualNum) {
        DBObject query = new BasicDBObject();
        query.put("batch", virtualNum);
        final DBCursor samples = mongoTemplate.getCollection("sample").find(query);
        List<DBObject> list = new ArrayList<>();
        samples.forEach(dbObject -> {
            list.add(dbObject);
        });
        return list;
    }

    @Override
    public int updateBatchNum(String batch, String num) {
        DBObject query = new BasicDBObject();
        query.put("batch", batch);
        DBObject update = new BasicDBObject();
        update.put("$set", new BasicDBObject("extracted", num));
        final WriteResult batch1 = mongoTemplate.getCollection("batch").update(query, update);
        return batch1.getN();
    }

    @Override
    public DBObject getUserByName(String name) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("name", name);
        final DBCollection userCollection = mongoTemplate.getCollection("user");
        final DBObject user = mongoTemplate.getCollection("user").findOne(dbObject);
        return user;
    }

    @Override
    public int updateBatchToZero() {
        DBObject query = new BasicDBObject();
        query.put("userCode", "zijian_cs");
        DBObject update = new BasicDBObject();
        update.put("$set", new BasicDBObject("extracted", "0"));
        final WriteResult batch = mongoTemplate.getCollection("batch").updateMulti(query, update);
        int n = batch.getN();
        return n;
    }
}
