/*
 * The MIT License
 *
 * Copyright (c) <2010> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.eti.kinoshita.tap4j.model;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.eti.kinoshita.tap4j.model.TapPlan;
import br.eti.kinoshita.tap4j.model.SkipPlan;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TestTAPPlan 
extends Assert
{

	protected TapPlan simplePlan;
	protected TapPlan skipAllPlan;
	
	protected final static Integer initialTestNumber = 1;
	protected final static Integer lastTestNumber = 3;
	
	protected final static String reason = "Function not yet implemented.";
	
	@BeforeTest
	public void setUp()
	{
		simplePlan = new TapPlan(initialTestNumber, lastTestNumber);
		skipAllPlan = new TapPlan(initialTestNumber, lastTestNumber, new SkipPlan( reason ));
	}
	
	@Test
	public void testSimplePlan()
	{
		assertTrue( simplePlan != null );
		
		assertEquals( simplePlan.getInitialTestNumber() , initialTestNumber );
		
		assertEquals( simplePlan.getLastTestNumber(), lastTestNumber );
		
		assertNull ( simplePlan.getSkip() );
		
		assertFalse( simplePlan.isSkip() );
		
		String toStringResult = simplePlan.toString();
		
		final String expectedOutput = "1..3";
		
		assertEquals( toStringResult ,expectedOutput );
	}
	
	@Test
	public void testSkipAllPlan()
	{
		assertTrue( skipAllPlan != null );
		
		assertEquals( skipAllPlan.getInitialTestNumber(), initialTestNumber );
		
		assertEquals( skipAllPlan.getLastTestNumber(), lastTestNumber );
		
		assertTrue( skipAllPlan.isSkip() );
		
		assertNotNull( skipAllPlan.getSkip() );
		
		assertEquals( skipAllPlan.getSkip().getReason(), TestTAPPlan.reason);
		
		String toStringResult = skipAllPlan.toString();
		
		final String expectedOutput = "1..3 skip " + TestTAPPlan.reason;
		
		assertEquals( toStringResult ,expectedOutput );
	}
	
}