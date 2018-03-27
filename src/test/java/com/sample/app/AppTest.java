package com.sample.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	// Load the knowledge base:
    	KieServices ks = KieServices.Factory.get();
    	KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession();
    	// Set up our Person fact model:
    	Person p = new Person();
    	p.setWage(12);
    	p.setFirstName("Tom");
    	p.setLastName("Summers");
    	p.setHourlyRate(10033);
    	// Insert him into the session:
    	kSession.insert(p);
    	// And fire all rules on him:
    	kSession.fireAllRules();
    }
}
