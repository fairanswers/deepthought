package com.fairanswers.deepthought;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ls extends Task {
    private static String USAGE = "ls <whatever>";
    private static List<String> NAMES = Arrays.asList("ls", "list");

    @Override
    public String getUsage() {return "ls <path>";}
    @Override
    public List<String> getNames(){ return Arrays.asList("ls");}



    public String doit(List<String> args) {
        System.out.println( "Inside Ls with args "+ String.join(",", args) );
        args = filterFirst(args);
        ArrayList<String> newArgs = new ArrayList<>();
        newArgs.add("/usr/bin/ls");
        newArgs.addAll(args);
        String result = executeProcess(newArgs);
        return result;
    }
}
