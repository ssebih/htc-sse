package fr.htc.kpi;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class QuarterReducer extends Reducer <Text, FloatWritable, Text, FloatWritable> {
	private FloatWritable benefitByLine = new FloatWritable();
	
	@Override
	protected void reduce (Text quarterYear, Iterable<FloatWritable> benefits, Context context)
			throws IOException, InterruptedException {
		float sum = 0;
		for (FloatWritable be : benefits) {
			sum += be.get();
		}
		benefitByLine.set(sum);

		context.write(quarterYear, benefitByLine);
	}

}
