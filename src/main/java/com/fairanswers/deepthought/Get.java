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
        if(args.size() < 2){
            System.out.println(getUsage());
        }
        HttpSupportClass hc = new HttpSupportClass();
        try {
            String url = args.get(1);
            System.out.println("getting "+url);
            resp = hc.get(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resp;
    }
}
