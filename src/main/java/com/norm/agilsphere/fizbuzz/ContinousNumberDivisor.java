package com.norm.agilsphere.fizbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContinousNumberDivisor implements NumberDivisor {

	
	private static List<Divisor> divisors;

	@Override
	public List<String> processRange(Integer end) {
		return IntStream.rangeClosed(1, end).boxed().map(i -> new DivisorChain(divisors,i).toString())
				.collect(Collectors.toList());

	}
	
	static{
		divisors = new ArrayList<>();
		divisors.add(new Divisor(Arrays.asList(3,5), "fizzbuzz"));
		divisors.add(new Divisor(Arrays.asList(3), "fizz"));
		divisors.add(new Divisor(Arrays.asList(5), "buzz"));
	}
	
	private static class Divisor{
		private List<Integer> divisors;
		private String result;
		
		public Divisor(List<Integer> divisors, String result){
		   this.divisors = divisors;
		   this.result = result;
		}
		
		public String getResult(Integer number){
			for(Integer divisor : divisors){
				if(number % divisor != 0){
					return null;
				}
			}
			return result;
		}
		
	}

	private class DivisorChain {
		private String chainResult;

		public DivisorChain(List<Divisor> divisors, Integer i) {
			String result;
			chainResult = i.toString();
			for(Divisor divisor : divisors){
			   result = divisor.getResult(i);
			   if(result != null){
				   chainResult= result;
				   break;
			   }
			}
		}

		@Override
		public String toString() {
			return chainResult;
		}
	}

}
