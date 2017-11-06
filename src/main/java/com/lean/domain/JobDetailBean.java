package com.lean.domain;

import java.util.Map;

public class JobDetailBean {

    private String jobClass;

    private Map<String, Object> jobDetailMap;

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public Map<String, Object> getJobDetailMap() {
        return jobDetailMap;
    }

    public void setJobDetailMap(Map<String, Object> jobDetailMap) {
        this.jobDetailMap = jobDetailMap;
    }
}
