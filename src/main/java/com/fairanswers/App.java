package com.fairanswers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    private static List<Jeltz> jeltzs;

    public static void main(String[] args)
            throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        jeltzs = Jeltz.getJeltz(); // TODO Parameterize?
        String input = null;
        while (!"exit".equals(input)) {
            // Reading data using readLine
             input = reader.readLine();
            List<String> inputs = Arrays.asList(input.split(" "));
             Optional<Jeltz> match = Jeltz.findByName(inputs.get(0), jeltzs);
            if(match.isPresent()){
                System.out.println(match.get().execute(inputs) );
            }else{
                System.out.println("Could not find a match for "+input);
            }
        }
    }
}
