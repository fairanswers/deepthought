package com.fairanswers.deepthought;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeepThought {
    private static List<Task> tasks;

    public static void main(String[] args)
            throws IOException {
        tasks = Task.getTasks(); // TODO Parameterize if too slow?
        if(args.length==0){
            System.out.println(Task.getAllUseages());
            return;
        }
        Optional<Task> match = null;
        if(tasks != null || !tasks.isEmpty() ){
            match = Task.findByName(args[0], tasks);
        }
        if (match != null && match.isPresent()) {
            System.out.println(match.get().doit(Arrays.asList(args)));
        } else {
            System.out.println("Could not find a match for " + String.join(" ", args));
            System.out.println(Task.getAllUseages());
        }
    }
}

