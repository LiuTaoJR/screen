package com.heidelberg.screen.common;

import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class MapBeanUtil {
    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 实体类转Map共通方法
     *
     * @param bean 实体类
     * @return Map
     * @throws Exception
     */
    public static Map<String, Object> convertBean(Object bean) throws Exception {
        Class type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (!"class".equals(propertyName)) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean);
                if (result != null && result != "") {
                    if (result instanceof String) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.putAll(objectToMap(result));
                    }
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }

    /**
     * Map转成实体对象
     *
     * @param map   实体对象包含属性
     * @param clazz 实体对象类型
     * @return
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
        if (map == null) {
            return null;
        }
        T obj = null;
        try {
            obj = clazz.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    /**
     * 将map 拆分成多个map
     *
     * @param chunkMap 被拆的 map
     * @param chunkNum 每段的大小
     * @param <k>      map 的 key类 型
     * @param <v>      map 的value 类型
     * @return List
     */
    public static <k, v> List<LinkedHashMap<k, v>> mapChunk(LinkedHashMap<k, v> chunkMap, int chunkNum) {
        if (chunkMap == null || chunkNum <= 0) {
            List<LinkedHashMap<k, v>> list = new ArrayList<>();
            list.add(chunkMap);
            return list;
        }
        Set<k> keySet = chunkMap.keySet();
        Iterator<k> iterator = keySet.iterator();
        int i = 1;
        List<LinkedHashMap<k, v>> total = new ArrayList<>();
        LinkedHashMap<k, v> tem = new LinkedHashMap<>();
        while (iterator.hasNext()) {
            k next = iterator.next();
            tem.put(next, chunkMap.get(next));
            if (i == chunkNum) {
                total.add(tem);
                tem = new LinkedHashMap<>();
                i = 0;
            }
            i++;
        }
        if (!CollectionUtils.isEmpty(tem)) {
            total.add(tem);
        }
        return total;
    }
}
