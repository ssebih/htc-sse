package objects;

import java.beans.Transient;
import java.io.Serializable;

public class Sale implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer ProductId;
        private Integer TimeId;
        private Integer CustomerId;
        private Integer PromotionId;
        private Integer StoreId;
        private Float StoreSales;
        private Float StoreCost;
        private Float UnitSales;
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
         sale.UnitSales(Float.parseFloat(columns[7]));

         return sale;
                
        }
        
        

        @Override
        public String toString() {
                return "Sale [ProductId=" + ProductId + ", TimeId=" + TimeId + ", CustomerId=" + CustomerId + ", PromotionId="
                                + PromotionId + ", StoreId=" + StoreId + ", StoreSales=" + StoreSales + ", StoreCost=" + StoreCost
                                + ", UnitSales=" + UnitSales + "]";
        }



        public Integer getProductId() {
                return ProductId;
        }

        public void setProductId(Integer productId) {
                ProductId = productId;
        }

        public Integer getTimeId() {
                return TimeId;
        }

        public void setTimeId(Integer timeId) {
                TimeId = timeId;
        }

        public Integer getCustomerId() {
                return CustomerId;
        }

        public void setCustomerId(Integer customerId) {
                CustomerId = customerId;
        }

        public Integer getStoreId() {
                return StoreId;
        }

        public void setStoreId(Integer storeId) {
                StoreId = storeId;
        }

        public Integer getPromotionId() {
                return PromotionId;
        }

        public void setPromotionId(Integer promotionId) {
                PromotionId = promotionId;
        }

        public Float getStoreSales() {
                return StoreSales;
        }

        public void setStoreSales(Float storeSales) {
                StoreSales = storeSales;
        }

        public Float getStoreCost() {
                return StoreCost;
        }

        public void setStoreCost(Float storeCost) {
                StoreCost = storeCost;
        }

        public Float getUnitSales() {
                return UnitSales;
        }

        public void UnitSales(Float f) {
                UnitSales = f;
        }


        @Transient
        public Float calcCa() {
                return this.StoreSales * this.UnitSales;
        }
        @Transient
        public Float calcBenefit() {
        	return (this.StoreSales * this.UnitSales)-(this.StoreCost*this.UnitSales);
        	
        }

}