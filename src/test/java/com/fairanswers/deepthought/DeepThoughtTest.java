package com.fairanswers.deepthought;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple DeepThought.
 */
public class DeepThoughtTest
{
    @Test
    public void testLs(){
        Ls ls = new Ls();
        System.out.println(ls.doit(Arrays.asList("ls", "-a", "/tmp")) );
    }

    @Test
    public void testHttp(){
        Get get = new Get();
        System.out.println(get.doit(Arrays.asList("get", "https://httpbin.org/get")) );
    }

    @Test
    public void testRun(){
        Run run = new Run();
        System.out.println(run.doit(Arrays.asList("run", "ls", "-a")) );
    }
}
