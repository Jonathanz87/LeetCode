package com.jonathanz.hive.mellifera.somefile;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

public class ObjectPrinter {

    private static final Class[] PRIMITIVE_TYPES =
            {boolean.class, char.class, byte.class, short.class, int.class, long.class, float.class, double.class};

    private static final Class[] TERMINAL_CLASSES = {
            boolean.class, char.class, byte.class, short.class, int.class, long.class, float.class, double.class,
            Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class,
            Double.class,
            BigDecimal.class, BigInteger.class, String.class, TimeZone.class, Calendar.class};

    private static final String SPACE = "   ";

    public static void print(Class clazz) throws ClassNotFoundException {
        if (clazz != null) {
            System.out.println(clazz.getSimpleName());
            print(clazz, "   ", "");
        }
    }

    public static void print(Class clazz, String prefix, String postfix) throws ClassNotFoundException {
        if (clazz == null) {
            return;
        }

        List<Field> fieldList = getField(clazz);

        for (Field field : fieldList) {
            Class fieldClass = field.getType();
            if (Stream.of(TERMINAL_CLASSES).anyMatch(c -> fieldClass.isAssignableFrom(c)) || fieldClass.isEnum()) {
                System.out.println(prefix + fieldClass.getSimpleName() + " " + field.getName());
            } else if (fieldClass.isAssignableFrom(List.class)) {
                printList(field, prefix, "");
            } else {
                System.out.println(prefix + fieldClass.getSimpleName() + " " + field.getName() + postfix);
                print(fieldClass, prefix + SPACE, "");
            }
        }
    }

    private static void printList(Field field, String prefix, String postfix) throws ClassNotFoundException {
        String typeName = field.getGenericType().getTypeName();
        typeName = typeName.substring(typeName.indexOf("<") + 1, typeName.lastIndexOf(">"));
        Class subClass = Class.forName(typeName);
        System.out.println(prefix + subClass.getSimpleName() + "[] " + field.getName());
        if (!(Stream.of(TERMINAL_CLASSES).anyMatch(c -> subClass.isAssignableFrom(c)) || subClass.isEnum())) {
            print(subClass, prefix + SPACE, "");
        }
    }

    private static List<Field> getField(Class clazz) {
        List<Field> fieldList = new LinkedList<>();

        if (clazz == null) {
            return fieldList;
        }

        do {
            Stream.of(clazz.getDeclaredFields()).forEach(f -> fieldList.add(f));
        } while ((clazz = clazz.getSuperclass()) != null);

        return fieldList;
    }
}
