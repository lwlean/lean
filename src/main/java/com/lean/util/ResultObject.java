package com.lean.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by llw on 2017/10/1.
 */
public class ResultObject extends Result {

    private Object data;

    public ResultObject() {
        super();
    }

    public ResultObject(Integer code, String message, Object data) {
        super(code, message);
        this.data = data;
    }

    public ResultObject(Integer code, String message) {
        super(code, message);
    }

    public ResultObject(Object data) {
        this();
        this.data = data;
    }

    public ResultObject(Enum<?>[] ens) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Enum<?> en : ens) {
            Map<String, Object> map = enumToMap(en);
            list.add(map);
        }
        data = list;
    }

    private Map<String, Object> enumToMap(Enum<?> en) {
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo info = Introspector.getBeanInfo(en.getClass());
            PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                if (property.getPropertyType().getName().equals("java.lang.Class"))
                    continue;
                Object value = property.getReadMethod().invoke(en, new Object[]{});
                map.put(property.getName(), value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
