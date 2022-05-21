package spark.core;

import java.beans.Transient;
import java.io.Serializable;

public class Sale implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private int timeId;
	private int customerId;
	private int promotionId;
	private int storeId;
	private float storeSales;
	private float storeCost;
	private float unitSales;

	public Sale(int productId, int timeId, int customerId, int promotionId, int storeId, int storeSales, int storeCost,
			int unitSales) {
		super();
		this.productId = productId;
		this.timeId = timeId;
		this.customerId = customerId;
		this.promotionId = promotionId;
		this.storeId = storeId;
		this.storeSales = storeSales;
		this.storeCost = storeCost;
		this.unitSales = unitSales;
	}

	public Sale() {

	}

	public static Sale parse(String csvLine) {
		String[] columns = csvLine.split(";");
		Sale sale = new Sale();
		sale.setProductId(Integer.parseInt(columns[0]));
		sale.setTimeId(Integer.parseInt(columns[1]));
		sale.setCustomerId(Integer.parseInt(columns[2]));
		sale.setPromotionId(Integer.parseInt(columns[3]));
		sale.setStoreId(Integer.parseInt(columns[4]));
		sale.setStoreSales(Float.parseFloat(columns[5]));
		sale.setStoreCost(Float.parseFloat(columns[6]));
		sale.setunitSales(Float.parseFloat(columns[7]));

		return sale;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public float getStoreSales() {
		return storeSales;
	}

	public void setStoreSales(float f) {
		this.storeSales = f;
	}

	public float getStoreCost() {
		return storeCost;
	}

	public void setStoreCost(float f) {
		this.storeCost = f;
	}

	public float getunitSales() {
		return unitSales;
	}

	public void setunitSales(float unitSales) {
		this.unitSales = unitSales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Transient
	public Float calcCa() {
		return this.storeSales * this.unitSales;
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public String toString() {
		return "Sale [productId=" + productId + ", timeId=" + timeId + ", customerId=" + customerId + ", promotionId="
				+ promotionId + ", StoreId=" + storeId + ", storeSales=" + storeSales + ", storeCost=" + storeCost
				+ ", StriUnitSales=" + unitSales + "]";
	}

}
