package com.fairanswers.deepthought;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import static org.reflections.scanners.Scanners.SubTypes;

public abstract class Task {
    // These fields should be overriden;
    private String USAGE = "Override Me";
    private List<String> NAMES = Arrays.asList("parentName");

    public abstract String getUsage();

    public abstract List<String>getNames();

    public abstract String doit(List<String> args);

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass());
        sb.append("\n");
        sb.append("Names: ");
        sb.append(getNames());
        sb.append("\n");
        sb.append("Usage: ");
        sb.append(getUsage());
        sb.append("\n");
        return sb.toString();
    }
    public static Optional<Task> findByName(String input, List<Task> tasks) { //TODO make this pretty
        for(int i=0; i< tasks.size(); i++){
            if(tasks.get(i).getNames().contains(input)){
                return Optional.of(tasks.get(i));
            }
        }
        return Optional.empty();
    }

    public static List<Task> getTasks() {
        Reflections reflections = new Reflections("com");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Task.class).asClass());
        List<Task> inst = subTypes.stream().map(cls -> {
            try {
                Constructor<?>[] consts = cls.getConstructors();
                Task i = (Task) consts[0].newInstance(null);
                return i;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return inst;
    }

    public static String executeProcess(List<String> args){
        StringBuffer result = new StringBuffer();
        ProcessBuilder builder = new ProcessBuilder(args);
        try {
            Process process = builder.start();
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while(output.ready()){
                result.append(output.readLine());
                result.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    public static List<String> filterFirst(List<String> args) {
        args = args.subList(1, args.size());
        return args;
    }

}
