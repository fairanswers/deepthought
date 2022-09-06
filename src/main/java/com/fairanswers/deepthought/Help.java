package com.fairanswers.deepthought;

import java.util.Arrays;
import java.util.List;

public class Help extends Task {
    @Override
    public String getUsage() {
        return "help";
    }
    @Override
    public List<String> getNames() {
        return Arrays.asList("-h", "--help", "help");
    }

    public String doit(List<String> args) {
        System.out.println( "Inside Help with args "+ String.join(",", args) );
        args = filterFirst(args);
        getTasks().stream().forEach(task -> {
            System.out.println(task);
        });
        return "";
    }

}
