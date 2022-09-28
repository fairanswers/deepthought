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
        System.out.println(args.toString());
        try {
            String url = args.get(0);
            System.out.println("getting "+url);
            resp = hc.get(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resp;
    }
}
