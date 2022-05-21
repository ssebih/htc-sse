package fr.htc.spark.tp;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import scala.Tuple2;
import spark.core.Customer;
import spark.core.Sale;
import spark.core.Stores;
import spark.core.TimeByDay;

public class MySparkCore {

	public static void main(String[] args) {
		
		
		String salespathcsv = args[0];
		
		String storespathcsv =args[1];
		
		String timepathcsv = args [2];
		
		String customerpathcsv = args[3];
		
		
		
		// Exercice 1: Quel est le point d'entrée pour un Job Spark ?
		JavaSparkContext sc = SparkConfig.getJavaSparkContext();

		// Exercice 2: Charger le fichier des ventes (sales.csv) dans une RDD de type
		// String
		JavaRDD<String> salesAsStringRdd = sc.textFile(salespathcsv);
		//salesAsStringRdd.take(10).forEach(e -> System.out.println(e));

		// Exercice 3: Charger le fichier des ventes (sales.csv) dans une RDD de type
		// Sale. La classe Sale est aussi à développer
		JavaRDD<Sale> salesAsObjectRdd = salesAsStringRdd.map(csvLine -> Sale.parse(csvLine));
		//salesAsObjectRdd.take(10).forEach(e -> System.out.println(e));

		// Exercice 4: Calculer le chiffre d'affaire par magasin
		// Magasin : 23 a un chiffre d'affaires : 151039.54000000007

		JavaPairRDD<Integer, Float> RDDSalesCa = salesAsObjectRdd
				.mapToPair(sale -> new Tuple2<Integer, Float>(sale.getStoreId(), sale.calcCa()));
		salesAsObjectRdd.mapToPair(sale -> new Tuple2<Integer, Float>(sale.getStoreId(), sale.calcCa()))
				.reduceByKey((v1, v2) -> v1 + v2).collectAsMap()
				.forEach((k, v) -> System.out.println("Magasin : " + k + " a un chiffre d'affaires : " + v));

		// Exercice 5: Calculer le nombre d'unités vendues par magasin
		// Magasin : 5 a un vendu : 1298 unités

		salesAsObjectRdd.mapToPair(sale -> new Tuple2<Integer, Float>(sale.getStoreId(), sale.getunitSales()))
				.reduceByKey((v1, v2) -> v1 + v2).collectAsMap()
				.forEach((k, v) -> System.out.println("Magasin : " + k + " a un vendu : " + v + "unités"));

		// Exercice 6: Calculer le chiffre d'affaire par région.
		// JavaPairRDD<Integer, Double> caByRegion = ...
		// Region : 23 avec un CA : 537768.1800000002

		JavaRDD<String> StoreAsString = sc.textFile(storespathcsv);

		JavaRDD<Stores> StoreAsObjectRdd = StoreAsString.map(csvLine -> Stores.parse(csvLine));
		JavaPairRDD<Integer, Integer> RDDIdRegionIdStore = StoreAsObjectRdd
				.mapToPair(store -> new Tuple2<Integer, Integer>(store.getStoreId(), store.getRegionId()));

		JavaPairRDD<Integer, Tuple2<Integer, Float>> RDDCaRegion = RDDIdRegionIdStore.join(RDDSalesCa);

		RDDCaRegion.mapToPair(e -> new Tuple2<Integer, Float>(e._1, e._2._2)).reduceByKey((x, y) -> x + y)
				.collectAsMap().forEach((k, v) -> System.out.println("Region : " + k + " avec un CA : " + v));

		// Exercice 7: Comparer les ventes (en termes de CA) entre les premiers
		// trimestres (Q1) de 1997 et 1998
		// JavaPairRDD<Integer, Double> yearCAQuarter= ...

		// CA Q1 de l'année 1997 : 460615.02999999735
		// CA Q1 de l'année 1998 : 965701.8800000021
		
		  SparkConfig.getJavaSparkContext()
          .textFile(salespathcsv)
          .map(csvLine -> Sale.parse(csvLine))
          .mapToPair(sale -> new Tuple2<Integer, Float>(sale.getTimeId(), sale.calcCa()))
          .join(
                          SparkConfig.getJavaSparkContext().textFile(timepathcsv)
                          .map(timeCsv -> TimeByDay.parse(timeCsv))
                          .filter(time -> time.getQuarter().equals("Q1"))
                          .mapToPair(time -> new Tuple2<Integer, TimeByDay>(time.getTimeId(), time))
                          )
           .mapToPair(joinElt -> new Tuple2<String, Float>(generatConcatKey(joinElt._2._2), joinElt._2._1 ))
           .reduceByKey((ca1, ca2) -> ca1 + ca2)
           .collectAsMap()
           .forEach((k, v) -> System.out.println("CA "+ k + " est de " + v));
          System.out.println("the end ;)");
//
//		  JavaPairRDD<Integer, Float> saleCaPairRdd = salesAsObjectRdd
//                  .mapToPair(sale -> new Tuple2<Integer, Float>(sale.getTimeId(), sale.calcCa()));
//  
//  JavaRDD<String> timeAsStringRdd = sc.textFile("data/time_by_day");
//	
//		
		
//		JavaRDD<T>	yearQuarter	=year97QuarterAsObject.filter((quarter) -> "true") quarter -> quarter.getQuarter().equals("Q1")) ;
          sc.textFile(customerpathcsv).map(csvLine -> Customer.parse(csvLine))
			.mapToPair(customer -> new Tuple2<Integer, String>(customer.getCustomerId(), customer.getEducation()))
			.join(sc.textFile("data/sales.csv").map(csvLine -> Sale.parse(csvLine))
					.mapToPair(sale -> new Tuple2<Integer, Float>(sale.getCustomerId(), sale.calcCa())))
			.mapToPair(saleCusomerJoin -> new Tuple2<String, Float>(saleCusomerJoin._2._1, saleCusomerJoin._2._2))
			.reduceByKey((ca1, ca2) -> ca1 + ca2).collectAsMap().forEach((educLeven, ca) -> System.out
					.println(educLeven + ": a un chiffre d'affaires : " + ca));
		
		
	}

	 private static String generatConcatKey(TimeByDay timeById) {
         return timeById.getQuarter() + "_" + timeById.getYear();
 }
	 
	 
	

}
