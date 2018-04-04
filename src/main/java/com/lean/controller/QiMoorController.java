package com.lean.controller;



import com.lean.domain.Batch;
import com.lean.domain.Sample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QiMoorController {

    final private static Logger log = LoggerFactory.getLogger(QiMoorController.class);

    @RequestMapping(value = "/command", method = RequestMethod.GET)
    public Object getBatchNumber(@RequestParam(name = "Command") String command, @RequestParam(name = "Action") String action, @RequestParam(name = "batchNum") String batchNum) {
        log.info("command:{},Action:{}",command,action);

        Map<String, Object> resultMap = new HashMap();
        resultMap.put("code", 200);

        if (StringUtils.equals("getBatchNumber", action)) {
            Batch batch1 = new Batch();
            batch1.setTime("20180322");
            batch1.setCount("3");
            batch1.setUserCode("zijian_cs");
            batch1.setBatch("00260010001");
            batch1.setExtracted("0");
            batch1.setType("1");

            Batch batch2 = new Batch();
            batch2.setTime("20180402");
            batch2.setCount("7");
            batch2.setUserCode("zijian_cs");
            batch2.setBatch("00260020002");
            batch2.setExtracted("0");
            batch2.setType("1");

            Batch batch3 = new Batch();
            batch3.setTime("20180402");
            batch3.setCount("4");
            batch3.setUserCode("zijian_cs");
            batch3.setBatch("00260020001");
            batch3.setExtracted("0");
            batch3.setType("1");

            List<Batch> resultList = new ArrayList<>();
            resultList.add(batch1);
            resultList.add(batch2);
            resultList.add(batch3);

            Map<String, Object> map = new HashMap<>();
            map.put("result", resultList);
            map.put("count", 3);
            map.put("description", "SUCCESS");
            map.put("code", 0);

            resultMap.put("data", map);

            return resultMap;
        }

        if (StringUtils.equals("getVirtualNum", action)) {

            Map<String, Object> data = new HashMap<>();
            List<Sample> list = new ArrayList<>();

            int createNum = 0;
            String batch = "00260020001";
            String virtualnum = "00260020002000";

            if (!StringUtils.isNotBlank(batchNum)) {

            } else if (StringUtils.equals("00260020001", batchNum)) {
                createNum = 4;
                batch = "00260020001";
                virtualnum = "00260020001000";
            } else if (StringUtils.equals("00260010001", batchNum)) {
                createNum = 3;
                batch = "00260010001";
                virtualnum = "00260010001000";
            } else if (StringUtils.equals("00260020002", batchNum)) {
                createNum = 7;
                batch = "00260020002";
                virtualnum = "00260020002000";
            }

            for (int i = 0; i < createNum; i++) {
                final Sample sample = new Sample();
                sample.setExplanation("紧密联系人");
                sample.setLostusername("张三"+i);
                sample.setUsermode(2);
                sample.setLostusernum("100000031345xxx");
                sample.setTime("2018-04-02 10:19:32.377734");
                sample.setLosttime("");
                sample.setBatch(batch);
                sample.setLostuseridcard("440111111XXX");
                sample.setVirtualid(5);
                sample.setVirtualnum(virtualnum + i);
                list.add(sample);
            }

            data.put("result", list);
            data.put("count", createNum);
            data.put("description", "SUCCESS");
            data.put("code", 0);
            resultMap.put("data", data);
        }

        return resultMap;
    }






    /**
     * {
     "data": {
     "result": [
     {
     "explanation": "紧密联系人",
     "lostusername": "张三",
     "usermode": 2,
     "lostusernum": "100000031345xxx",
     "city": "020",
     "lostusercity": "020",
     "time": "2018-04-02 10:19:32.377734",
     "losttime": "",
     "batch": "00260020001",
     "lostuseridcard": "440111111XXX",
     "virtualid": 5,
     "virtualnum": "002600200010000"
     },
     {
     "explanation": "紧密联系人",
     "lostusername": "张三",
     "usermode": 2,
     "lostusernum": "100000031345xxx",
     "city": "020",
     "lostusercity": "020",
     "time": "2018-04-02 10:19:47.581613",
     "losttime": "",
     "batch": "00260020001",
     "lostuseridcard": "440111111XXX",
     "virtualid": 1,
     "virtualnum": "002600200010001"
     },
     {
     "explanation": "紧密联系人",
     "lostusername": "张三",
     "usermode": 2,
     "lostusernum": "100000031345xxx",
     "city": "020",
     "lostusercity": "020",
     "time": "2018-04-02 10:19:56.517638",
     "losttime": "",
     "batch": "00260020001",
     "lostuseridcard": "440111111XXX",
     "virtualid": 2,
     "virtualnum": "002600200010002"
     },
     {
     "explanation": "紧密联系人",
     "lostusername": "张三",
     "usermode": 4,
     "lostusernum": "100000031345xxx",
     "city": "020",
     "lostusercity": "020",
     "time": "2018-04-02 10:20:07.112097",
     "losttime": "",
     "batch": "00260020001",
     "lostuseridcard": "440111111XXX",
     "virtualid": 1,
     "virtualnum": "002600200010003"
     }
     ],
     "count": 4,
     "description": "SUCCESS",
     "code": 0
     },
     "code": 200
     }
     */



}
