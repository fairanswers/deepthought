package com.fairanswers.deepthought;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeepThoughtShell {
    private static List<Task> tasks;

    public static void main(String[] args)
            throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        tasks = Task.getTasks(); // TODO Parameterize if too slow?
        String input = null;
        while (!"exit".equals(input)) {
            // Reading data using readLine
             input = reader.readLine();
            List<String> inputs = Arrays.asList(input.split(" "));
             Optional<Task> match = Task.findByName(inputs.get(0), tasks);
            if(match.isPresent()){
                System.out.println(match.get().doit(inputs) );
            }else{
                System.out.println("Could not find a match for "+input);
            }
        }
    }
}
