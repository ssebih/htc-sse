package fr.htc.kpi;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SalesStoreReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	private FloatWritable caByline = new FloatWritable();

	@Override
	protected void reduce(Text StoreNameKey, Iterable<FloatWritable> caValues, Context context)

			throws IOException, InterruptedException {
		float sum = 0;
		for (FloatWritable ca : caValues) {
			sum += ca.get();

		}
		caByline.set(sum);

		context.write(StoreNameKey, caByline);

	}

}
