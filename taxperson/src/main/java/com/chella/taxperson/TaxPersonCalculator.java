package com.chella.taxperson;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author chella
 *
 * This class calculates the total amount for the list of items purchased
 */
public class TaxPersonCalculator {

	//set of items available in stores for sale.
	private static HashMap<Integer, Item> itemsInStores = new HashMap<Integer,Item>();
	static{
		itemsInStores.put(123,new Item(123, "Water", false, 200));
		itemsInStores.put(124,new Item(124, "Rolex Watch", true, 1500000));
		itemsInStores.put(125,new Item(125, "Milk", false, 399));
		itemsInStores.put(126,new Item(126, "Salt", false, 399));
		itemsInStores.put(127,new Item(127, "iPad", true, 74900));
	}
	
	//tax percentage for Luxury / Necessity items
	private static final double taxForLuxury = .09;
	private static final double taxForNecessity = .01;
	
	/**
	 * This method takes the Item ID and quantity of items to be bought as a map.
	 * Formula to calculate totalSum = Item Price * No. of Items Quantity + Percentage Of (Item Price * No. of Items Quantity)
	 * 
	 * @param itemToCountMap
	 * @throws IllegalArgumentException - if the item sent for computation isn't part of store then throw Exception
	 * @return
	 */
	public Double calculateTotalAmount(HashMap<Integer, Integer> itemToCountMap) throws IllegalArgumentException{
		Double totalSum = 0.0;
		if(itemToCountMap==null || itemToCountMap.isEmpty()){
			return totalSum;
		}
		for(Map.Entry<Integer, Integer> entrySet : itemToCountMap.entrySet()){
			Item iteminStore = itemsInStores.get(entrySet.getKey());
			if(iteminStore!=null){
				Integer totalItemPrice = iteminStore.getPriceinCents() * entrySet.getValue() ;
				totalSum += totalItemPrice + totalItemPrice * (iteminStore.isLuxuryItem() ?taxForLuxury : taxForNecessity);
			}else{
				throw new IllegalArgumentException("Invalid Item Requested");
			}
		}
		return Long.valueOf(Math.round(totalSum)).doubleValue();
	}
}
