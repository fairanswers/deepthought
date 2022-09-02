package com.fairanswers;

import java.util.Arrays;
import java.util.List;

public class Echo extends Jeltz{
    @Override
    public String getUsage() {return "echo <whatever>";}
    @Override
    public List<String> getNames(){ return Arrays.asList("echo");}

    public String execute(List<String> args) {
        //super.execute(args);
        //args.remove(0);
        return "Inside Echo with args "+ String.join(",", args);
    }
}
