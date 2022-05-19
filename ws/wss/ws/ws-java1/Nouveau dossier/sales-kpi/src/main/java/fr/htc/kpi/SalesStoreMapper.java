package fr.htc.kpi;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalesStoreMapper extends Mapper<Object, Text, Text, FloatWritable> {

	private Text storeName = new Text();
	private FloatWritable caByline = new FloatWritable();

	@Override
	protected void map(Object key, Text csvLine, Context context) throws IOException, InterruptedException {

		String[] salesColumns = csvLine.toString().split(";");

		float storeSales = Float.parseFloat(salesColumns[5]);
		float unitSales = Float.parseFloat(salesColumns[7]);

		storeName.set(salesColumns[72]);
		caByline.set(storeSales * unitSales);

		context.write(storeName, caByline);

	}

}
