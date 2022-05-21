package fr.htc.kpi;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperQuarter extends Mapper<Object, Text, Text, FloatWritable> {
	@Override
	protected void map(Object key, Text csvLine, Context context) throws IOException, InterruptedException {
		Text quarterYear = new Text();
		FloatWritable benefit = new FloatWritable();
		String[] splitCsv = csvLine.toString().split(";");

		float storeSales = Float.parseFloat(splitCsv[6]);

		float unitSales = Float.parseFloat(splitCsv[5]);

		float costSales = Float.parseFloat(splitCsv[7]);

		benefit.set(unitSales * (storeSales - costSales));

		String quarterSales = splitCsv[31];

		String keyYear = splitCsv[27];
		quarterYear.set(keyYear + "-" + quarterSales);

		context.write(quarterYear, benefit);

	}

}
