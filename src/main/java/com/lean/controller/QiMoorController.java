package com.lean.controller;



import com.lean.domain.Batch;
import com.lean.domain.Sample;
import com.lean.domain.User;
import com.lean.service.UserMongoService;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMongoService userMongoService;

    @RequestMapping(value = "/command", method = RequestMethod.GET)
    public Object getBatchNumber(@RequestParam(name = "Command") String command, @RequestParam(name = "Action") String action, @RequestParam(name = "batchNum") String batchNum, @RequestParam(name = "type", required = false) String type) {
        log.info("command:{},Action:{}",command,action);

        Map<String, Object> resultMap = new HashMap();
        resultMap.put("code", 200);

        // 获取批次号
        if (StringUtils.equals("getBatchNumber", action)) {
            final List<DBObject> batchs = userMongoService.getBatchNum();
            Map<String, Object> map = new HashMap<>();
            map.put("result", batchs);
            map.put("count", batchs.size());
            map.put("description", "SUCCESS");
            map.put("code", 0);
            resultMap.put("data", map);
            return resultMap;
        }

        // 根据批次号获取虚拟号
        if (StringUtils.equals("getVirtualNum", action)) {
            Map<String, Object> data = new HashMap<>();
            List<DBObject> list = new ArrayList<>();

            if (StringUtils.isBlank(batchNum)) {
                return resultMap;
            }

            final DBObject batchNumByBatch = userMongoService.getBatchNumByBatch(batchNum);
            final Object extracted = batchNumByBatch.get("extracted");
            list = userMongoService.getVirtualNum(batchNum);
            if(StringUtils.equals("1", type)) {
                if("0".equals(extracted)) {
                    userMongoService.updateBatchNum(batchNum, String.valueOf(list.size()));
                }
            }

            data.put("result", list);
            data.put("count", list.size());
            data.put("description", "SUCCESS");
            data.put("code", 0);
            resultMap.put("data", data);
        }

        return resultMap;
    }



    // 测试用
    @RequestMapping(value = "/testMongo", method = RequestMethod.GET)
    public Object testMonogo() {
        log.info("into mongo");
        final DBObject llw = userMongoService.getUserByName("llw");
        final String name = llw.get("name").toString();
        return llw;
    }

    @RequestMapping(value = "/addBatch", method = RequestMethod.GET)
    public Object addBatch() {
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

        Batch batch4 = new Batch();
        batch4.setTime("20180402");
        batch4.setCount("2");
        batch4.setUserCode("zijian_cs");
        batch4.setBatch("00260030004");
        batch4.setExtracted("0");
        batch4.setType("1");

        Batch batch5 = new Batch();
        batch5.setTime("20180402");
        batch5.setCount("3");
        batch5.setUserCode("zijian_cs");
        batch5.setBatch("00030010001");
        batch5.setExtracted("0");
        batch5.setType("0");

        userMongoService.addBatchNum(batch1);
        userMongoService.addBatchNum(batch2);
        userMongoService.addBatchNum(batch3);
        userMongoService.addBatchNum(batch4);
        userMongoService.addBatchNum(batch5);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "SUCCESS");
        return result;
    }



    @RequestMapping(value = "/addSample", method = RequestMethod.GET)
    public Object addSample() {

        List<Sample> list = new ArrayList<>();

        final Sample sample1 = new Sample();
        sample1.setExplanation("紧密联系人");
        sample1.setLostusername("张三");
        sample1.setUsermode(2);
        sample1.setLostusernum("10003001001xxx");
        sample1.setTime("2018-04-02 10:19:32.377734");
        sample1.setLosttime("");
        sample1.setBatch("00260030001");
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
        sample2.setBatch("00260030001");
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
        sample3.setBatch("00260030001");
        sample3.setLostuseridcard("440111111XXX");
        sample3.setVirtualid(5);
        sample3.setVirtualnum("002600300010202");
        list.add(sample3);

        final Sample sample4 = new Sample();
        sample4.setExplanation("紧密联系人");
        sample4.setLostusername("张三");
        sample4.setUsermode(2);
        sample4.setLostusernum("10003002001xxx");
        sample4.setTime("2018-04-02 10:19:32.377734");
        sample4.setLosttime("");
        sample4.setBatch("00260030002");
        sample4.setLostuseridcard("440111111XXX");
        sample4.setVirtualnum("002600300020101");
        list.add(sample4);

        final Sample sample5 = new Sample();
        sample5.setExplanation("紧密联系人");
        sample5.setLostusername("张三");
        sample5.setUsermode(2);
        sample5.setLostusernum("100030002002xxx");
        sample5.setTime("2018-04-02 10:19:32.377734");
        sample5.setLosttime("");
        sample5.setBatch("00260030002");
        sample5.setLostuseridcard("440111111XXX");
        sample5.setVirtualid(5);
        sample5.setVirtualnum("002600300020201");
        list.add(sample5);

        final Sample sample6 = new Sample();
        sample6.setExplanation("紧密联系人");
        sample6.setLostusername("张三");
        sample6.setUsermode(2);
        sample6.setLostusernum("100030002003xxx");
        sample6.setTime("2018-04-02 10:19:32.377734");
        sample6.setLosttime("");
        sample6.setBatch("00260030002");
        sample6.setLostuseridcard("440111111XXX");
        sample6.setVirtualid(5);
        sample6.setVirtualnum("002600300020203");
        list.add(sample6);

        final Sample sample7 = new Sample();
        sample7.setExplanation("紧密联系人");
        sample7.setLostusername("张三");
        sample7.setUsermode(2);
        sample7.setLostusernum("10003003001xxx");
        sample7.setTime("2018-04-02 10:19:32.377734");
        sample7.setLosttime("");
        sample7.setBatch("00260030003");
        sample7.setLostuseridcard("440111111XXX");
        sample7.setVirtualnum("002600300030101");
        list.add(sample7);

        final Sample sample8 = new Sample();
        sample8.setExplanation("紧密联系人");
        sample8.setLostusername("张三");
        sample8.setUsermode(2);
        sample8.setLostusernum("10003003001xxx");
        sample8.setTime("2018-04-02 10:19:32.377734");
        sample8.setLosttime("");
        sample8.setBatch("00260030003");
        sample8.setLostuseridcard("440111111XXX");
        sample8.setVirtualid(5);
        sample8.setVirtualnum("002600300030101");
        list.add(sample8);

        final Sample sample9 = new Sample();
        sample9.setExplanation("紧密联系人");
        sample9.setLostusername("张三");
        sample9.setUsermode(2);
        sample9.setLostusernum("10003003002xxx");
        sample9.setTime("2018-04-02 10:19:32.377734");
        sample9.setLosttime("");
        sample9.setBatch("00260030003");
        sample9.setLostuseridcard("440111111XXX");
        sample9.setVirtualid(5);
        sample9.setVirtualnum("002600300030201");
        list.add(sample9);

        final Sample sample10 = new Sample();
        sample10.setExplanation("紧密联系人");
        sample10.setLostusername("张三");
        sample10.setUsermode(2);
        sample10.setLostusernum("100030002003xxx");
        sample10.setTime("2018-04-02 10:19:32.377734");
        sample10.setLosttime("");
        sample10.setBatch("00260030003");
        sample10.setLostuseridcard("440111111XXX");
        sample10.setVirtualid(5);
        sample10.setVirtualnum("002600300030201");
        list.add(sample10);


        final Sample sample11 = new Sample();
        sample11.setExplanation("紧密联系人");
        sample11.setLostusername("张三");
        sample11.setUsermode(2);
        sample11.setLostusernum("10003004001xxx");
        sample11.setTime("2018-04-02 10:19:32.377734");
        sample11.setLosttime("");
        sample11.setBatch("00260030003");
        sample11.setLostuseridcard("440111111XXX");
        sample11.setVirtualid(5);
        sample11.setVirtualnum("002600300040101");
        list.add(sample11);

        final Sample sample12 = new Sample();
        sample12.setExplanation("紧密联系人");
        sample12.setLostusername("张三");
        sample12.setUsermode(2);
        sample12.setLostusernum("10003004002xxx");
        sample12.setTime("2018-04-02 10:19:32.377734");
        sample10.setLosttime("");
        sample12.setBatch("00260030003");
        sample12.setLostuseridcard("440111111XXX");
        sample12.setVirtualid(5);
        sample12.setVirtualnum("002600300040101");
        list.add(sample12);

        final Sample sample20 = new Sample();
        sample20.setVirtualnum("00030010001000");
        sample20.setBrands("宝马");
        sample20.setCity("020");
        sample20.setBatch("00030010001");
        sample20.setTime("2016-04-23");
        sample20.setName("赵大");
        list.add(sample20);

        final Sample sample21 = new Sample();
        sample21.setVirtualnum("00030010001001");
        sample21.setBrands("宝马");
        sample21.setCity("020");
        sample21.setBatch("00030010001");
        sample21.setTime("2016-04-23");
        sample21.setName("赵二");
        list.add(sample21);

        final Sample sample22 = new Sample();
        sample22.setVirtualnum("00030010001001");
        sample22.setBrands("宝马");
        sample22.setCity("020");
        sample22.setBatch("00030010001");
        sample22.setTime("2016-04-23");
        sample22.setName("赵三");
        list.add(sample22);

        list.forEach(sample -> {
            userMongoService.addVirtualNum(sample);
        });


        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "SUCCESS");
        return result;
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
