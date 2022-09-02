package com.fairanswers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reflections.Reflections;

import static org.reflections.scanners.Scanners.SubTypes;

public abstract class Jeltz {
    private String USAGE = "Override Me";
    private List<String> NAMES = Arrays.asList("jeltz");

    public abstract String getUsage();

    public abstract List<String>getNames();

    public String execute(List<String> args){
        return "Inside Jeltz";
    }

    public static Optional<Jeltz> findByName(String input, List<Jeltz> jeltzes) { //TODO make this pretty
        for(int i=0; i< jeltzes.size(); i++){
            if(jeltzes.get(i).getNames().contains(input)){
                return Optional.of(jeltzes.get(i));
            }
        }
        return Optional.empty();
    }

    public static List<Jeltz> getJeltz() {
        Reflections reflections = new Reflections("com");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Jeltz.class).asClass());
        List<Jeltz> inst = subTypes.stream().map(cls -> {
            try {
                Constructor<?>[] consts = cls.getConstructors();
                Jeltz i = (Jeltz) consts[0].newInstance(null);
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
}
