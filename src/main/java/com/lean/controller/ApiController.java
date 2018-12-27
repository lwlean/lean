package com.lean.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by llw on 2017/10/10.
 */
@RestController
@RequestMapping(value = "lean")
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping(value = "test2")
    public Object test(@RequestParam(value = "ip") String ip,@RequestParam(value = "param") String param, @RequestParam(value = "type") String type,@RequestParam(value="bing") int bing) {
        List<String> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < bing; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    RestTemplate restTemplate = new RestTemplate();
                    final String url = "http://"+ip+":8011/queryRepayOrExpress?param="+param+"&type="+type;
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,null, String.class);
                    String res = result.getBody();
                    list.add(res);
                    logger.info("res:{}",res.toString());
                }
            });
        }
        return list;
    }

    @RequestMapping(value = "test1")
    public Object test1(@RequestParam(value = "ip") String ip,@RequestParam(value = "phone") String phone, @RequestParam(value = "sfht") String sfht,@RequestParam(value="bing") int bing) {
        List<String> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < bing; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    RestTemplate restTemplate = new RestTemplate();
                    final String url = "http://"+ip+":8011/contractInfo?phone="+phone+"&sfht="+sfht;
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,null, String.class);
                    String res = result.getBody();
                    list.add(res);
                    logger.info("res:{}",res.toString());
                }
            });
            logger.info("i:{}",i);
        }
        return list;
    }

}
