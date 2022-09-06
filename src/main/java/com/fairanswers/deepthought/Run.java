package com.fairanswers.deepthought;

import java.util.Arrays;
import java.util.List;

public class Run extends Task {
    @Override
    public String getUsage() {
        return "run <whatever>";
    }
    @Override
    public List<String> getNames() {
        return Arrays.asList("run", "runner");
    }

    public String doit(List<String> args) {
        System.out.println( "Inside Run with args "+ String.join(",", args) );
        // First arg is 'run'
        args = filterFirst(args);
        String result = executeProcess(args);
        return result;
    }

}
