package com.jonathanz.hive.mellifera.somefile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

public class ObjectMerger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectMerger.class);

    private static final Class[] PRIMITIVE_TYPES =
            {boolean.class, char.class, byte.class, short.class, int.class, long.class, float.class, double.class};

    private static final Class[] TERMINAL_CLASSES = {
            Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class,
            Double.class,
            BigDecimal.class, BigInteger.class, String.class, TimeZone.class, Calendar.class};

    private boolean isMatch = true;

    public <T> T merge(T obj1, T obj2) throws InstantiationException, IllegalAccessException {
        T obj3 = merge(obj1, obj2, (Class<T>) obj1.getClass(), obj1.getClass().getSimpleName() + ".");

        //    if(!isMatch){
        //      //TODO define a merge exception
        //      throw new RuntimeException("value mismatch");
        //    }

        return obj3;
    }

    private <T> T merge(T obj1, T obj2, Class<T> clazz, String objectPath)
            throws IllegalAccessException, InstantiationException {
        if (obj1 == null) {
            LOGGER.debug("{} does not exist in object1 use Object2", objectPath);
            return obj2;
        }
        T output = clazz.newInstance();

        List<Field> fieldList = getFields(clazz);

        for (Field field : fieldList) {
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                continue;
            }

            Class fieldClass = field.getType();
            field.setAccessible(true);
            String path = objectPath + field.getName() + '.';

            //TODO what to do in a mismatch case for primitive
            if (fieldClass == boolean.class) {
                boolean v1 = field.getBoolean(obj1);
                boolean v2 = field.getBoolean(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setBoolean(output, v1);
            } else if (fieldClass == char.class) {
                char v1 = field.getChar(obj1);
                char v2 = field.getChar(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setChar(output, v1);
            } else if (fieldClass == byte.class) {
                byte v1 = field.getByte(obj1);
                byte v2 = field.getByte(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setByte(output, v1);
            } else if (fieldClass == short.class) {
                short v1 = field.getShort(obj1);
                short v2 = field.getShort(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setShort(output, v1);
            } else if (fieldClass == int.class) {
                int v1 = field.getInt(obj1);
                int v2 = field.getInt(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setInt(output, v1);
            } else if (fieldClass == long.class) {
                long v1 = field.getLong(obj1);
                long v2 = field.getLong(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setLong(output, v1);
            } else if (fieldClass == float.class) {
                float v1 = field.getFloat(obj1);
                float v2 = field.getFloat(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setFloat(output, v1);
            } else if (fieldClass == double.class) {
                double v1 = field.getDouble(obj1);
                double v2 = field.getDouble(obj2);
                if (v1 != v2) {
                    LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                    isMatch = false;
                }
                field.setDouble(output, v1);
            } else if (Stream.of(TERMINAL_CLASSES).anyMatch(t -> fieldClass.isAssignableFrom(t)) || fieldClass.isEnum()) {
                Object v1 = field.get(obj1);
                Object v2 = field.get(obj2);

                if (v1 != null) {
                    if (!v1.equals(v2)) {
                        //TODO need to determine what to do in this case
                        //TODO replace for now
                        LOGGER.error("Value mismatch for objectPath={} value1={} value2={}", path, v1, v2);
                        isMatch = false;
                    }
                    field.set(output, v1);
                } else {
                    LOGGER.debug("{} does not exist in object1, use value from Object2", path);
                    field.set(output, v2);
                }
            } else if (fieldClass.isAssignableFrom(List.class)) {
                field.set(output, mergeList((List) field.get(obj1), (List) field.get(obj2), path));
            } else {
                field.set(output, merge(fieldClass.cast(field.get(obj1)), fieldClass.cast(field.get(obj2)),
                        fieldClass, path));
            }
        }

        return output;
    }

    private <T> List<T> mergeList(List<T> list1, List<T> list2, String objectPath)
            throws InstantiationException, IllegalAccessException {
        if (list1 == null) {
            LOGGER.debug("{} does not exist in object1, use value from Object2", objectPath);
            return list2;
        } else if (list2 != null) {
            if (list1.size() != list2.size()) {
                LOGGER.error("List size mismatch for objectPath={} list1.size={} list2.size={}",
                        objectPath, list1.size(), list2.size());
                isMatch = false;
                return list1;
            } else if (list1.size() == 0) {
                return list1;
            } else {
                int size = list1.size();
                List<T> output = new ArrayList<>(size);
                Class<T> listType = (Class<T>) list1.get(0).getClass();

                for (int i = 0; i < size; i++) {
                    output.add(merge(list1.get(i), list2.get(i), listType, objectPath + '[' + i + ']'));
                }
                return output;
            }
        }
        return null;

    }

    private <T> T comparePrimitive(T v1, T v2, String objectPath) {
        if (v1 != v2) {
            LOGGER.warn("Value mismatch for objectPath={} value1={} value2={}", objectPath, v1, v2);
            isMatch = false;
        }
        return v2;
    }

    private <T> List<Field> getFields(Class<T> clazz) {
        List<Field> fieldList = new LinkedList<>();

        Class<? super T> superClass = clazz;

        while ((superClass = superClass.getSuperclass()) != Object.class) {
            for (Field field : superClass.getDeclaredFields()) {
                fieldList.add(field);
            }
        }

        for (Field field : clazz.getDeclaredFields()) {
            fieldList.add(field);
        }

        return fieldList;
    }
}
