package fr.htc.sample;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class VerySimpleStreamingApp {
	private static final String HOST = "localhost";
	private static final int PORT = 9999;

	public static void main(String[] args) throws InterruptedException {

		
		
		// Configurer et initialiser le SparkStreamingContext
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("VerySimpleStreamingApp");

		JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Durations.seconds(5));

		Logger.getRootLogger().setLevel(Level.ERROR);
		// reception des données en temps réel de la source
		JavaReceiverInputDStream<String> lines = streamingContext.socketTextStream(HOST, PORT);

		JavaDStream<Integer> javaDStream = lines.map(new Function<String, Integer>() {

			@Override
			public Integer call(String line) throws Exception {
				
				/*String strIn = line.replace(" ", "").split(":")[1];
				return Integer.parseInt(strIn);*/
				Pattern p = Pattern.compile("\\d+");
				Matcher m = p.matcher(line); 
				if(m.find()) {
					return Integer.valueOf(m.group());
				}
				return null;
			}});
			
			
		/*
		 * line -> {if (Pattern.compile("\\d+")
		 * .matcher(line)) ==True){return Integer
		 * .valueOf(Pattern.compile("\\d+")
		 * .matcher(line).group())} else {return null}
		 **/
			
			
		
		// impression des lignes en sortie
		//javaDStream.print();
		
		
		javaDStream.countByValue().print();
		JavaDStream<Integer> javaDStreamAvg = javaDStream
				.reduceByWindow((val1, val2)->( Integer.sum(val1, val2)/2), Durations.seconds(5), Durations.seconds(5));
				

		
		
		
		javaDStreamAvg.map (avg -> avg +"�").print();
		// );		
		// Execute le job spark
		streamingContext.start();
		streamingContext.awaitTermination();
	}
}
