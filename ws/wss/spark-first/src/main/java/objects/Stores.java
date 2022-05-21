package objects;

import java.beans.Transient;
import java.io.Serializable;

import org.apache.arrow.flatbuf.Date;

public class Stores implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer StoreId;
        private String StoreType;
        private Integer RegionId;
        private String StoreName;
        private Integer StoreNumber;
        private String StoreStreetAdress;
        private String StoreCity;
        private String StoreState;
        private Integer StorePostalCode;
        private String StoreCountry;
        private String StoreManager;
        private String StorePhone;
        private String StoreFax;
        private Date FirstOpenedDate;
        private Date LastRemodelDate;
        private Integer StoreSqft;
        private Integer GrocerySqfl;
        private Integer FrozenSqft;
        private Integer MaetSqft;
        private Integer CoffeeBar;
        private Integer VideoStore;
        private Integer SaladBAR;
        private Integer PreparedFood;
        private Integer Florist;
        public static Stores parse(String csvLine) {
                 String[] columns = csvLine.split(";");
         Stores stores = new Stores();
         stores.setStoreId(Integer.parseInt(columns[0]));
         //stores.setRegionId(Integer.parseInt(columns[2]));
         stores.setStoreName((columns[3]));
         /* sale.setStoreNumber(Integer.parseInt(columns[4]));
         sale.setStoreStreetAdress(Float.parseFloat(columns[5]));
         sale.setStoreCity(Float.parseFloat(columns[6]));
         sale.setStoreState(Float.parseFloat(columns[7]));
         sale.setStorePostalCode(Integer.parseInt(columns[8]));
         sale.setStoreCountry(Integer.parseInt(columns[9]));
         sale.setStoreManager(Integer.parseInt(columns[10]));
         sale.setStorePhone(Integer.parseInt(columns[11]));
         sale.setStoreFax(Integer.parseInt(columns[12]));
         sale.setFirstOpenedDate(Float.parseFloat(columns[13]));
         sale.setLastRemodelDate(Float.parseFloat(columns[14]));
         sale.setStoreSqft(Float.parseFloat(columns[15]));
         sale.setGrocerySqfl(Integer.parseInt(columns[16]));
         sale.setFrozenSqft(Integer.parseInt(columns[17]));
         sale.setMaetSqft(Integer.parseInt(columns[18]));
         sale.setCoffeeBar(Integer.parseInt(columns[19]));
         sale.setVideoStore(Integer.parseInt(columns[20]));
         sale.setSaladBAR(Float.parseFloat(columns[21]));
         sale.setPreparedFood(Float.parseFloat(columns[22]));
         sale.setFlorist(Float.parseFloat(columns[23]));*/

         return stores;
                
        }
        public String getStoreName() {
        return this.StoreName;	
        }
        
        

        public void setStoreName(String string) {
			// TODO Auto-generated method stub
			
		}



		@Override
        public String toString() {
                return "Stores  StoreId=" + StoreId + ", RegionId=" + RegionId  + "]";
        }



        public Integer getStoreId() {
                return StoreId;
        }



        public void setStoreId(Integer storeId) {
                StoreId = storeId;
        }



        public Integer getRegionId() {
                return RegionId;
        }



        public void setRegionId(Integer regionId) {
                RegionId = regionId;
        }



        
}