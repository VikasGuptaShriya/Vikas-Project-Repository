package com.vikas.demo.FileUpdateProject;


import java.io.FileNotFoundException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TextFileModificationProgram1Test extends TestCase{
	
	
	
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TextFileModificationProgram1Test( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TextFileModificationProgram1Test.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testTextFileModificationProgram1()
    {
    	assertTrue( true );

    }
    
    
    public void testModifyFile()
    {
    	assertEquals(true, TextFileModificationProgram1.modifyFile("E:\\Vikas123\\Files\\InputFiles\\textfile.txt"));
    	    }
    
    public void testCountWords()
    {
    	try {
			assertEquals(true, TextFileModificationProgram1.countWords("E:\\Vikas123\\Files\\InputFiles\\textfile.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

    }

}
