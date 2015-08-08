package com.chella.taxperson.tests;

import java.util.HashMap;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.chella.taxperson.TaxPersonCalculator;

public class TaxPersonCalculatorTestNG {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void checkInvalidItem(){
		HashMap<Integer, Integer> itemCountMap = new HashMap<Integer,Integer>();
		itemCountMap.put(111, 1);
		TaxPersonCalculator taxPersonCalculator = new TaxPersonCalculator();
		taxPersonCalculator.calculateTotalAmount(itemCountMap);
	}
	
	@Test
	public void checkLuxuryItemTotalPrice(){
		HashMap<Integer, Integer> itemCountMap = new HashMap<Integer,Integer>();
		itemCountMap.put(124, 1);
		TaxPersonCalculator taxPersonCalculator = new TaxPersonCalculator();
		Double calculateTotalAmount = taxPersonCalculator.calculateTotalAmount(itemCountMap);
		AssertJUnit.assertEquals(calculateTotalAmount, 1635000.0);
	}
	
	@Test
	public void checkNecessaryItemTotalPriceWithMultipleItemQuantity(){
		HashMap<Integer, Integer> itemCountMap = new HashMap<Integer,Integer>();
		itemCountMap.put(123, 2);
		TaxPersonCalculator taxPersonCalculator = new TaxPersonCalculator();
		Double calculateTotalAmount = taxPersonCalculator.calculateTotalAmount(itemCountMap);
		AssertJUnit.assertEquals(calculateTotalAmount, 404.0);
	}
	
	@Test
	public void checkMultipleItemTotalPriceWithMultipleItemQuantity(){
		HashMap<Integer, Integer> itemCountMap = new HashMap<Integer,Integer>();
		itemCountMap.put(123, 2);
		itemCountMap.put(124, 2);
		itemCountMap.put(125, 10);
		itemCountMap.put(127, 5);
		TaxPersonCalculator taxPersonCalculator = new TaxPersonCalculator();
		Double calculateTotalAmount = taxPersonCalculator.calculateTotalAmount(itemCountMap);
		AssertJUnit.assertEquals(calculateTotalAmount, 3682639.0);
	}
}
