package fr.htc.spark.tp;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import config.SparkConfig;
import objects.Sale;
import scala.Tuple2;

public class Main {

	public static void main(String[] args) {
		
		
		JavaSparkContext sc = SparkConfig.getJavaSparkContext();
		
		
		/// 1 calcul de top 100  ca par magasin par vente
		
		JavaPairRDD<Integer, Float> caSaleByIdStore =sc.textFile("data/sales.csv").
		map(csvLine -> Sale.parse(csvLine)).
		mapToPair(sale -> new Tuple2<Integer,Float>(sale.getStoreId(), sale.calcCa()));
		
		
		JavaPairRDD<Float, Integer> StorebyCa = caSaleByIdStore.
				mapToPair(elem -> new Tuple2<Float, Integer>(elem._2, elem._1)).sortByKey(false);
		
//		StorebyCa.take(100).forEach(e -> System.out.println(e));
		
		
		
		//2 calcul de top100 benefit /produit
		
		
		JavaPairRDD<Integer, Float> benefitByIdProduct =sc.textFile("data/sales.csv").
				map(csvLine -> Sale.parse(csvLine)).
				mapToPair(sale -> new Tuple2<Integer,Float>(sale.getProductId(), sale.calcBenefit()));
		JavaPairRDD<Float, Integer> benefitByProduct =	 benefitByIdProduct.
				mapToPair(e -> new Tuple2<Float, Integer>(e._2, e._1)).sortByKey(false);
		
		benefitByProduct.saveAsObjectFile("/data/benefitByProduct1.data");

		
		
			
		
	}

}
