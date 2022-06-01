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

public class MySparkCoreDf {

	public static void main(String... args) {
		// Exercice 1: le point d'entrÃ©e
		SparkSession sc = SparkConfig.getSparkSession();

		//2 DF// Exercice 2: Charger le fichier des ventes (sales.csv) dans une df de type
		// String

		
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
//		salesAsDF.show();

		Sale sale = new Sale();
		//3 DS
		
		Dataset<Sale> salesAsDS = salesAsDF.as(Encoders.bean(Sale.class));
		
		salesAsDS.createOrReplaceTempView("salesView");
		sc.sql("SELECT * FROM salesView").show();;

		
//		salesAsDS.show();

		//4 CA
		Dataset<Row> caStore = salesAsDF
				.groupBy(column("StoreId"))
				.agg(sum(column("StoreSales")
				.multiply(column("UnitSales")))
				.as("ca"));
		
		
//caStore.show();
//		
//		Dataset<Row> caByStore = salesAsDF
//				.select(col("storeId"),( col("storeSales")
//				.multiply(col("unitSales"))
//				.as("rowCA")))
//                .groupBy(col("storeId"))
//                .agg(sum(col("rowCA")));
		
		
//		Dataset<Float> caByStore = salesAsDF
//				.select(col("storeId"), col("storeSales")
//						.multiply (col("unitSales"))
//						.as("rowCA"))
//                .groupBy(col("storeId"))
//                .sum("rowCA").as("ca");
//caByStore.show();
//		
		
		//5 unité par magasin
		
		Dataset<Row> unitByStore	= (salesAsDF
				.groupBy("storeId")
				.count());
				
//		unitByStore.show();
		
		
		//6
//		JavaPairRDD<Integer, Double> caByRegion = ...
//				avec un résultat correspondant à: 
//				Region : 23 avec un CA : 537768.1800000002
//				Region : 89 avec un CA : 151039.54000000007
//				Region : 26 avec un CA : 265264.4699999993
//				Region : 47 avec un CA : 310913.3200000007
//				Region : 2 avec un CA : 76719.89
		
		
		 StructType schemaR = new StructType()
                 .add("StoreId", "Integer")
                 .add("StoreType", "String")
                 .add("RegionId", "Integer")
                 .add("StoreName", "String")
                 .add("StoreNumber", "Integer")
                 .add("StoreStreetAdress", "String")
                 .add("StoreCity", "String")
                 .add("StoreState", "String")
                 .add("StorePostalCode", "Integer")
                 .add("StoreCountry", "String")
                 .add("StoreManager", "String")
                 .add("StorePhone", "String")
                 .add("storeFax", "String")
                 .add("FirstOpenedDate", "Date")
                 .add("LastRemodelDate", "Date")
                 .add("storeSqft", "Integer")
                 .add("grocerySqfl", "Integer")
                 .add("frozenSqft", "Integer")
                 .add("maetSqft", "Integer")
                 .add("coffeeBar", "Integer")
                 .add("videoStore", "Integer")
                 .add("saladBAR", "Integer")
                 .add("preparedFood", "Integer")
                 .add("florist", "Integer");
                 

		 Dataset<Row> storeAsDF = sc.read()
                 .option("header", false)
                 .option("delimiter", ";")
                 .schema(schemaR)
                 .csv("data/stores.csv");
     
		 
//		 storeAsDF.show(); 
		 
//		 Dataset<Stores> storeAsDS = storeAsDF.as(Encoders.bean(Stores.class));
     
     
    
		 Dataset<Row> caStoreAsDF = (storeAsDF.join(caStore, ( storeAsDF.col("StoreId")
				 .equalTo(caStore.col("StoreId"))))
                 .as("ca")
                 .select(storeAsDF.col("RegionId"), caStore.col("ca")));         
		 		
		 
		 //caStoreAsDF.show();       
		 
		 
		 //7-Solution de l'exercice 7 avec DataFrame: 
		 //Comparer les ventes (en termes de CA) entre les premiers trimestres (Q1) de 1997 et 1998
		 
		 StructType schemaT = new StructType()
                 .add("timeId", "Integer")
                 .add("col1", "String")
                 .add("col2", "String")
                 .add("col3", "String")
                 .add("year", "Integer")
                 .add("col4", "Integer")
                 
                 .add("col6", "Integer")
                 .add("col7", "Integer")
                 .add("quarter", "String")
                 ;
Dataset<Row> timeAsDF = sc.read()
                 .option("header", false)
                 .option("delimiter", ";")
                 .schema(schemaT)
                 .csv("data/time_by_day.csv");
     //storeAsDF.show();                         
Dataset<TimeByDay> timeAsDS = timeAsDF.as(Encoders.bean(TimeByDay.class));
timeAsDF.select("quarter").show();
sc.sql("SELECT * FROM timeAsDS").show();;


Dataset<Row> yearQuarterAsDF = ((timeAsDF.join(salesAsDF)
				.where( timeAsDF.col("timeId").equalTo(salesAsDF.col("timeId"))))
				.as("q")
				.groupBy("quarter","year")
				.agg(sum(column("StoreSales")
				.multiply (column("UnitSales")))
				. as ("ca")));    


//yearQuarterAsDF.show(); 
Dataset<Row> yearQuarterAAsDF =  yearQuarterAsDF.filter(col("quarter").equalTo("Q1"))  ;

//yearQuarterAAsDF.show();



   
		 
//		//Question 9Education level : Graduate Degree a un chiffre d'affaires : 284358.7000000002
//Education level : High School Degree a un chiffre d'affaires : 1614680.6999999923
//Education level : Partial College a un chiffre d'affaires : 506574.38000000064
//Education level : Bachelors Degree a un chiffre d'affaires : 1394302.7699999944
//Education level : Partial High School a un chiffre d'affaires : 1650653.7099999934

StructType schemaCustomer = new StructType()
			.add( "customerId", "Integer")
			.add("customerTime", "Long")
			.add( "lName", "String")
			.add( "fName", "String")
			.add( "mi", "String")
			.add( "address1", "String")
			.add(  "address2", "String")
			.add(  "address3", "Integer")
			.add(  "address4", "Integer")
			.add( "city", "String")
			.add( "stateProvince", "String")
			.add( "postalCode", "Integer")
			.add( "country", "String")
			.add( "customerRegionId", "Integer")
			.add( "phone1", "String")
			.add( "phone2", "String")
			.add( "birthdate", "String")
			.add("maritalStatus", "String")
			.add("yearlyIncome", "String")
			.add( "gender", "String")
			.add("totalChildren", "Integer")
			.add("numChildrenAtHome", "Integer")
			.add("education", "String")
			.add("dateAccountPpened", "String")
			.add("memberCard", "String")
			.add( "occupation", "String")
			.add("houseOwner", "String")
			.add("numCarsOwned", "Integer")
			.add( "fullName", "String");


				Dataset<Row> customerAsDF = sc.read()
							.option("header", false)
							.option("delimiter", ";")
							.schema(schemaCustomer)
							.csv("data/customers.csv");
				
				 customerAsDF.show();


//Dataset<Row> caByLevelAsDF = (salesAsDF.join(customerAsDF, ( salesAsDF.col("customerId")
//		 .equalTo(customerAsDF.col("customerId")))));
//               
//		
//caByLevelAsDF.show();

    
   
		
    
    
	

		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
