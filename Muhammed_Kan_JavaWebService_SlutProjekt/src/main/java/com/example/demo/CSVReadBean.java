package com.example.demo;

public class CSVReadBean {
	private String OrderDate;
	private String Region;
	private String Rep1;
	private String Rep2;
	private String Item;
	private String Units;
	private String UnitCost;
	private String Total;

	public CSVReadBean() {

	}

	public CSVReadBean(String orderDate, String region, String rep1, String rep2, String item, String units,
			String unitCost, String total) {
		OrderDate = orderDate;
		Region = region;
		Rep1 = rep1;
		Rep2 = rep2;
		Item = item;
		Units = units;
		UnitCost = unitCost;
		Total = total;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public String getRegion() {
		return Region;
	}

	public String getRep1() {
		return Rep1;
	}

	public String getRep2() {
		return Rep2;
	}

	public String getItem() {
		return Item;
	}

	public String getUnits() {
		return Units;
	}

	public String getUnitCost() {
		return UnitCost;
	}

	public String getTotal() {
		return Total;
	}
}