package com.fairanswers;

import java.util.Arrays;
import java.util.List;

public class Ls extends Jeltz{
    private static String USAGE = "ls <whatever>";
    private static List<String> NAMES = Arrays.asList("ls", "list");

    @Override
    public String getUsage() {return "ls <whatever>";}
    @Override
    public List<String> getNames(){ return Arrays.asList("ls");}



    public String execute(List<String> args) {
//        super.execute(args);
        //args.remove(0);
        return "Inside LS with args "+ String.join(",", args);
    }
}
