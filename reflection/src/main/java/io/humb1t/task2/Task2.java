package io.humb1t.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<Object> list = getFilledList();
        List<Class<?>> parentsList = getParentClassList(list);
        System.out.println("Parents: ");
        parentsList.forEach(x -> System.out.println(x.getName()));
        List<Object> childList = getAllChildList(parentsList, list);
        System.out.println("Child classes: ");
        childList.forEach(x -> System.out.println(x.getClass().getName()));

        List<Class<?>> interfaceList = getInterfaceList(list);
        System.out.println("Interfaces of deprecated classes: ");
        interfaceList.forEach(x -> System.out.println(x.toString()));
        System.out.println("All child classes with the interfaces: ");
        List<Class<?>> interfacesChildList = getInterfacesChildList(interfaceList, list);
        interfacesChildList.forEach(x -> System.out.println(x.toString()));
    }

    public static List<Class<?>> getInterfacesChildList(List<Class<?>> interfaces, List<Object> list) {
        Set<Class<?>> set = new HashSet<>();
        for (Class<?> i : interfaces) {
            for (Object o : list) {
                if (Arrays.asList(o.getClass().getInterfaces()).contains(i)
                        && !o.getClass().isAnnotationPresent(Deprecated.class)) {
                    set.add(o.getClass());
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<Class<?>> getInterfaceList(List<Object> list) {
        Set<Class<?>> set = new HashSet<>();
        for (Object o : list) {
            List<Class<?>> interfaces = Arrays.stream(o.getClass().getInterfaces()).distinct().collect(Collectors.toList());
            for (Object i : interfaces) {
                set.add((Class<?>) i);
            }
        }

        return new ArrayList<>(set);
    }

    public static List<Object> getAllChildList(List<Class<?>> parentList, List<Object> list) {
        Set<Object> set = new HashSet<>();
        for (Class<?> parent : parentList) {
            for (Object o : list) {
                if (parent.isAssignableFrom(o.getClass()) && !parent.equals(o.getClass())
                        && !o.getClass().isAnnotationPresent(Deprecated.class)) {
                    set.add(o);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static List<Class<?>> getParentClassList(List<Object> list) {
        Set<Class<?>> set = new HashSet<>();
        for (Object o : list) {
            if (o.getClass().isAnnotationPresent(Deprecated.class)) {
                if (!o.getClass().getSuperclass().equals(Object.class)) {
                    set.add(o.getClass().getSuperclass());
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<Object> getFilledList() {
        List<Object> arr = new ArrayList<>();
        arr.add(new classParent1());
        arr.add(new classParent2());
        arr.add(new classChild1());
        arr.add(new classChild2());
        arr.add(new classChild3());
        arr.add(new classChild4());
        arr.add(new classChild5());
        arr.add(new classChild6());
        arr.add(new classChild7());
        arr.add(new classChild8());
        arr.add(new classChild9());
        arr.add(new classChild10());
        return arr;
    }

}
