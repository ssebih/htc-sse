package fr.htc.spark.hdfs;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import objects.Customer;
import objects.Sale;
import scala.Tuple2;

public class Main {
	public static void main(String[] args) {
		
		int mode = Integer.parseInt(args[0]);
		
		JavaSparkContext jsc = SparkConfig.getJavaSparkContext();
		
		JavaPairRDD<String, Float> caByLevel = jsc.textFile("data/customers.csv").map(csvLine -> Customer.parse(csvLine))
		.mapToPair(customer -> new Tuple2<Integer, String>(customer.getCustomerId(), customer.getEducation()))
		.join(
				jsc.textFile("data/sales.csv")
				.map(csvLine -> Sale.parse(csvLine))
				.mapToPair(sale -> new Tuple2<Integer, Float>(sale.getCustomerId(), sale.calcCa()))
			)
		.mapToPair(saleCusomerJoin -> new Tuple2<String, Float>(saleCusomerJoin._2._1, saleCusomerJoin._2._2))
		.reduceByKey((ca1, ca2) -> ca1 + ca2) ;
		
		if(mode == 1) {
			caByLevel.saveAsTextFile("data/ca_educ_level.data");
		}
		if(mode == 2) {
			caByLevel.saveAsObjectFile("data/ca_educ_level.");
		}
		//

	}
}