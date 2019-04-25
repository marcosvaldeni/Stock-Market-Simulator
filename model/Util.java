package model;

import java.math.BigDecimal;
import java.util.Random;

public class Util {
	
	private static Random rand = new Random();

	public static int numberGen(int min, int max) {

		int result = rand.nextInt(max - min) + min;
		
		return result;

	}
	
	public static float amountGen(int min, int max) {

		double result = min + (max - min) * rand.nextDouble();
	
		return (float) result;

	}
	
	public static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}
}
