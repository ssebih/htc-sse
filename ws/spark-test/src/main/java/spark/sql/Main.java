package spark.sql;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.column;
import static org.apache.spark.sql.functions.sum;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

import fr.htc.spark.tp.SparkConfig;
import spark.core.Stores;
import spark.core.copy.Sale;
import spark.core.copy.TimeByDay;

public class Main {

	public static void main(String[] args) {
		
		SparkSession sc = SparkConfig.getSparkSession();
		
		StructType schema = new StructType()
				.add("ProductId", "Integer")
				.add("TimeId", "Integer")
				.add("CustomerId", "Integer")
				.add("PromotionId", "Integer")
				.add("StoreId", "Integer")
				.add("StoreSales", "Float")
				.add("StoreCost", "Float")
				.add("UnitSales", "Float");

		Dataset<Row> salesAsDF = sc.read()
				.option("header", false)
				.option("delimiter", ";")
				.schema(schema)
				.csv("data/sales.csv");
		
		salesAsDF.show();
		
//		 StructType schemaR = new StructType()
//                 .add("StoreId", "Integer")
//                 .add("StoreType", "String")
//                 .add("RegionId", "Integer")
//                 .add("StoreName", "String")
//                 .add("StoreNumber", "Integer")
//                 .add("StoreStreetAdress", "String")
//                 .add("StoreCity", "String")
//                 .add("StoreState", "String")
//                 .add("StorePostalCode", "Integer")
//                 .add("StoreCountry", "String")
//                 .add("StoreManager", "String")
//                 .add("StorePhone", "String")
//                 .add("storeFax", "String")
//                 .add("FirstOpenedDate", "Date")
//                 .add("LastRemodelDate", "Date")
//                 .add("storeSqft", "Integer")
//                 .add("grocerySqfl", "Integer")
//                 .add("frozenSqft", "Integer")
//                 .add("maetSqft", "Integer")
//                 .add("coffeeBar", "Integer")
//                 .add("videoStore", "Integer")
//                 .add("saladBAR", "Integer")
//                 .add("preparedFood", "Integer")
//                 .add("florist", "Integer");
//                 
//
//		 Dataset<Row> storeAsDF = sc.read()
//                 .option("header", false)
//                 .option("delimiter", ";")
//                 .schema(schemaR)
//                 .csv("data/stores.csv")
//                 .select(col("StoreId").as("stId"));
//     
////		 storeAsDF.show();
////		 
//		 Dataset<Row> salesCleant = salesAsDF
//				 .drop(col("storeCost"))
//				 .drop(col("storeSales"))
//				 .drop(col( "unitSales"))
//				 .drop(col("customerId"))
//	             .where(col("storeCost").gt(0).and(col("storeSales").gt(0)).and(col("unitSales").gt(0)));
//		 
//		
////		 salesCleant.show();
//		 
////		 
//	 Dataset<Row> salesCleant1 = salesCleant
//				 .drop(col("ProductId"))
//				 .drop(col("TimeId"))
//				 
//				 .drop(col("PromotionId"))
//			     .drop(col("StoreId"))
//				 .drop(col("storeCost"))
				 .where(col("customerId").gt(0));
				 
		 
	 
//	 salesCleant1.show();
 
		
		 
		
		

	}

}
