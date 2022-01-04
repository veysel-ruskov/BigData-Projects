package MathAnalyzer.MathAnalyzer;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MyMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		StringTokenizer tokens = new StringTokenizer(value.toString(), ",");	
		
		if(tokens.hasMoreTokens()) {
			output.collect(new Text(tokens.nextToken()), new IntWritable(tokens.countTokens()));
		}
		
	}

}
