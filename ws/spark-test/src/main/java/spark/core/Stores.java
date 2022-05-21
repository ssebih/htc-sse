package spark.core;

import java.io.Serializable;
import java.sql.Date;

public class Stores implements Serializable {
	/**
	 * 
	 */
	private Integer storeId;
	;
	private Integer regionId;
	private String storeName;
	;
	;
	

	public static Stores parse(String csvLine) {
		String[] columns = csvLine.split(";");
		Stores stores = new Stores();
		stores.setStoreId(Integer.parseInt(columns[0]));
		stores.setStoreId(Integer.parseInt(columns[2]))   ;
		
		return stores;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	
	

}
