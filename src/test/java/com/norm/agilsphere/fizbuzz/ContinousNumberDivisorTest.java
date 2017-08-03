package com.norm.agilsphere.fizbuzz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContinousNumberDivisorTest {

	private NumberDivisor divisor;
	
	@Before	
	public void setup(){
		divisor = new ContinousNumberDivisor();
	}
	
	@Test
	public void negativeEnd() {
		List<String> result =divisor.processRange(-1);
		assertEquals(0, result.size());
	}
	
	@Test
	public void endOne() {
		List<String> result =divisor.processRange(1);
		assertEquals(1, result.size());
	}
	
	@Test
	public void endTwo() {
		List<String> result =divisor.processRange(2);
		assertEquals(2, result.size());
	}

	@Test
	public void divisibleByThree() {
		List<String> result =divisor.processRange(10);
		assertEquals(10, result.size());
		assertEquals(result.get(2), "fizz");
		assertEquals(result.get(5), "fizz");
		assertEquals(result.get(8), "fizz");
		
	}
	
	@Test
	public void divisibleByFive() {
		List<String> result =divisor.processRange(10);
		assertEquals(10, result.size());
		assertEquals(result.get(4), "buzz");
		assertEquals(result.get(9), "buzz");
	}
	
	@Test
	public void divisibleByThreeFive() {
		List<String> result =divisor.processRange(30);
		assertEquals(30, result.size());
		assertEquals(result.get(14), "fizzbuzz");
		assertEquals(result.get(29), "fizzbuzz");
	}
}
