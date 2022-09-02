package com.fairanswers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testIn(){
        Ls ls = new Ls();
        System.out.println("LS="+ls.getNames());
        System.out.println("JJ="+( (Jeltz)ls).getNames());


    }
}
