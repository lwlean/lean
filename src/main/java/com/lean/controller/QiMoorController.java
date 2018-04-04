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
            batch1.setBatch("00260030001");
            batch1.setExtracted("0");
            batch1.setType("1");

            Batch batch2 = new Batch();
            batch2.setTime("20180402");
            batch2.setCount("3");
            batch2.setUserCode("zijian_cs");
            batch2.setBatch("00260030002");
            batch2.setExtracted("0");
            batch2.setType("1");

            Batch batch3 = new Batch();
            batch3.setTime("20180402");
            batch3.setCount("4");
            batch3.setUserCode("zijian_cs");
            batch3.setBatch("00260030003");
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
            String batch = "00260030001";
            String virtualnum = "00260030001000";
//
//            if (!StringUtils.isNotBlank(batchNum)) {
//
//            } else if (StringUtils.equals("00260030001", batchNum)) {
//                createNum = 3;
//                batch = batchNum;
//                virtualnum = "00260020001000";
//            } else if (StringUtils.equals("00260010001", batchNum)) {
//                createNum = 3;
//                batch = "00260010001";
//                virtualnum = "00260010001000";
//            } else if (StringUtils.equals("00260020002", batchNum)) {
//                createNum = 7;
//                batch = "00260020002";
//                virtualnum = "00260020002000";
//            }
//
//            for (int i = 0; i < createNum; i++) {
//                final Sample sample = new Sample();
//                sample.setExplanation("紧密联系人");
//                sample.setLostusername("张三"+i);
//                sample.setUsermode(2);
//                sample.setLostusernum("100000031345xxx");
//                sample.setTime("2018-04-02 10:19:32.377734");
//                sample.setLosttime("");
//                sample.setBatch(batch);
//                sample.setLostuseridcard("440111111XXX");
//                sample.setVirtualid(5);
//                sample.setVirtualnum(virtualnum + i);
//                list.add(sample);
//            }
//        }
            if (!StringUtils.isNotBlank(batchNum)) {

            } else if (StringUtils.equals("00260030001", batchNum)) {
                createNum = 3;
                batch = batchNum;
//                virtualnum = "00260030001000";
                final Sample sample1 = new Sample();
                sample1.setExplanation("紧密联系人");
                sample1.setLostusername("张三");
                sample1.setUsermode(2);
                sample1.setLostusernum("10003001001xxx");
                sample1.setTime("2018-04-02 10:19:32.377734");
                sample1.setLosttime("");
                sample1.setBatch(batch);
                sample1.setLostuseridcard("440111111XXX");
                sample1.setVirtualnum("002600300010101");
                list.add(sample1);

                final Sample sample2 = new Sample();
                sample2.setExplanation("紧密联系人");
                sample2.setLostusername("张三");
                sample2.setUsermode(2);
                sample2.setLostusernum("100030001002xxx");
                sample2.setTime("2018-04-02 10:19:32.377734");
                sample2.setLosttime("");
                sample2.setBatch(batch);
                sample2.setLostuseridcard("440111111XXX");
                sample2.setVirtualid(5);
                sample2.setVirtualnum("002600300010201");
                list.add(sample2);

                final Sample sample3 = new Sample();
                sample3.setExplanation("紧密联系人");
                sample3.setLostusername("张三");
                sample3.setUsermode(2);
                sample3.setLostusernum("100030001002xxx");
                sample3.setTime("2018-04-02 10:19:32.377734");
                sample3.setLosttime("");
                sample3.setBatch(batch);
                sample3.setLostuseridcard("440111111XXX");
                sample3.setVirtualid(5);
                sample3.setVirtualnum("002600300010202");
                list.add(sample2);

            } else if (StringUtils.equals("00260030002", batchNum)) {
                createNum = 3;
                batch = batchNum;
                final Sample sample1 = new Sample();
                sample1.setExplanation("紧密联系人");
                sample1.setLostusername("张三");
                sample1.setUsermode(2);
                sample1.setLostusernum("10003002001xxx");
                sample1.setTime("2018-04-02 10:19:32.377734");
                sample1.setLosttime("");
                sample1.setBatch(batch);
                sample1.setLostuseridcard("440111111XXX");
                sample1.setVirtualnum("002600300020101");
                list.add(sample1);

                final Sample sample2 = new Sample();
                sample2.setExplanation("紧密联系人");
                sample2.setLostusername("张三");
                sample2.setUsermode(2);
                sample2.setLostusernum("100030002002xxx");
                sample2.setTime("2018-04-02 10:19:32.377734");
                sample2.setLosttime("");
                sample2.setBatch(batch);
                sample2.setLostuseridcard("440111111XXX");
                sample2.setVirtualid(5);
                sample2.setVirtualnum("002600300020201");
                list.add(sample2);

                final Sample sample3 = new Sample();
                sample3.setExplanation("紧密联系人");
                sample3.setLostusername("张三");
                sample3.setUsermode(2);
                sample3.setLostusernum("100030002003xxx");
                sample3.setTime("2018-04-02 10:19:32.377734");
                sample3.setLosttime("");
                sample3.setBatch(batch);
                sample3.setLostuseridcard("440111111XXX");
                sample3.setVirtualid(5);
                sample3.setVirtualnum("002600300020203");
                list.add(sample3);
            } else if (StringUtils.equals("00260030003", batchNum)) {
                createNum = 4;
                batch = batchNum;
                final Sample sample1 = new Sample();
                sample1.setExplanation("紧密联系人");
                sample1.setLostusername("张三");
                sample1.setUsermode(2);
                sample1.setLostusernum("10003003001xxx");
                sample1.setTime("2018-04-02 10:19:32.377734");
                sample1.setLosttime("");
                sample1.setBatch(batch);
                sample1.setLostuseridcard("440111111XXX");
                sample1.setVirtualnum("002600300030101");
                list.add(sample1);

                final Sample sample2 = new Sample();
                sample2.setExplanation("紧密联系人");
                sample2.setLostusername("张三");
                sample2.setUsermode(2);
                sample2.setLostusernum("10003003001xxx");
                sample2.setTime("2018-04-02 10:19:32.377734");
                sample2.setLosttime("");
                sample2.setBatch(batch);
                sample2.setLostuseridcard("440111111XXX");
                sample2.setVirtualid(5);
                sample2.setVirtualnum("002600300030101");
                list.add(sample2);

                final Sample sample3 = new Sample();
                sample3.setExplanation("紧密联系人");
                sample3.setLostusername("张三");
                sample3.setUsermode(2);
                sample3.setLostusernum("10003003002xxx");
                sample3.setTime("2018-04-02 10:19:32.377734");
                sample3.setLosttime("");
                sample3.setBatch(batch);
                sample3.setLostuseridcard("440111111XXX");
                sample3.setVirtualid(5);
                sample3.setVirtualnum("002600300030201");
                list.add(sample3);

                final Sample sample4 = new Sample();
                sample4.setExplanation("紧密联系人");
                sample4.setLostusername("张三");
                sample4.setUsermode(2);
                sample4.setLostusernum("100030002003xxx");
                sample4.setTime("2018-04-02 10:19:32.377734");
                sample4.setLosttime("");
                sample4.setBatch(batch);
                sample4.setLostuseridcard("440111111XXX");
                sample4.setVirtualid(5);
                sample4.setVirtualnum("002600300030201");
                list.add(sample4);

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
