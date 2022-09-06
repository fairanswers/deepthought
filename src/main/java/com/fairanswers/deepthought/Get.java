package com.fairanswers.deepthought;

import java.util.Arrays;
import java.util.List;

public class Get extends Task{

    @Override
    public String getUsage() {
        return "get <url>";
    }

    @Override
    public List<String> getNames() {
        return Arrays.asList("get");
    }

    @Override
    public String doit(List<String> args) {
        String resp;
        HttpSupportClass hc = new HttpSupportClass();
        try {
            resp = hc.get(args.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resp;
    }
}
