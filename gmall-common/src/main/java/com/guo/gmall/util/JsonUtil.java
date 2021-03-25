package com.guo.gmall.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jws.Oneway;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/3/25 20:42
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class JsonUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 允许pojo中有在json串中不存在的字段
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);// 允许有注释
    }

    private JsonUtil() {}

    /**
     * 字符串转对象
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseOjbect(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * object 转字符串
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析json数组
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parseList(String jsonStr, Class<T> clazz) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);

        List<T> list  = null;
        try {
            list = objectMapper.readValue(jsonStr, javaType);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转map
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> parseMap(String jsonStr) {
        try {
            return JsonUtil.json2MapRecursion(jsonStr, objectMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把json解析成map，如果map内部的value存在jsonString，继续解析
     *
     * @param json
     * @param mapper
     * @return
     * @throws Exception
     */
    private static Map<String, Object> json2MapRecursion(String json, ObjectMapper mapper) throws Exception {
        if (json == null) {
            return null;
        }

        Map<String, Object> map = mapper.readValue(json, Map.class);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object obj = entry.getValue();
            if (obj != null && obj instanceof String) {
                String str = ((String) obj);

                if (str.startsWith("[")) {
                    List<?> list = json2ListRecursion(str, mapper);
                    map.put(entry.getKey(), list);
                } else if (str.startsWith("{")) {
                    Map<String, Object> mapRecursion = json2MapRecursion(str, mapper);
                    map.put(entry.getKey(), mapRecursion);
                }
            }
        }

        return map;
    }

    /**
     * 把json解析成list，如果list内部的元素存在jsonString，继续解析
     *
     * @param json
     * @param mapper 解析工具
     * @return
     * @throws Exception
     */
    private static List<Object> json2ListRecursion(String json, ObjectMapper mapper) throws Exception {
        if (json == null) {
            return null;
        }

        List<Object> list = mapper.readValue(json, List.class);

        for (Object obj : list) {
            if (obj != null && obj instanceof String) {
                String str = (String) obj;
                if (str.startsWith("[")) {
                    obj = json2ListRecursion(str, mapper);
                } else if (obj.toString().startsWith("{")) {
                    obj = json2MapRecursion(str, mapper);
                }
            }
        }

        return list;
    }

    /**
     * map转json字串
     * @param map
     * @return
     */
    public static String mapToJsonStr(Map<String, Object> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * map转object
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T mapToObject(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xiaoqiang");
        map.put("age", 18);

        System.out.println(JsonUtil.mapToJsonStr(map));

        String json = "{\"name\": \"xiaoqiang\"}";
        Map<String, Object> stringObjectMap = JsonUtil.parseMap(json);
        System.out.println(stringObjectMap);

        Person person = new Person();
        person.name = "小强";
        System.out.println(JsonUtil.toJsonString(person));

        System.out.println(JsonUtil.parseOjbect(json, Person.class).name);
    }

    static class Person {
        public String name;
    }
}
