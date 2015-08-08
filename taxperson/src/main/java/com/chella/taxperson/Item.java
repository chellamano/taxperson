package com.chella.taxperson;

public class Item {

	private Integer itemId;
	private String itemName;
	private boolean isLuxuryItem;
	private Integer priceinCents; // Keeping data type as integer, as we compute price in cents
	public long getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setLuxuryItem(boolean isLuxuryItem) {
		this.isLuxuryItem = isLuxuryItem;
	}
	public Integer getPriceinCents() {
		return priceinCents;
	}
	public void setPriceinCents(Integer priceinCents) {
		this.priceinCents = priceinCents;
	}
	public boolean isLuxuryItem() {
		return isLuxuryItem;
	}
	
	public Item(Integer itemId, String itemName, boolean isLuxuryItem,
			Integer priceinCents) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.isLuxuryItem = isLuxuryItem;
		this.priceinCents = priceinCents;
	}
}
