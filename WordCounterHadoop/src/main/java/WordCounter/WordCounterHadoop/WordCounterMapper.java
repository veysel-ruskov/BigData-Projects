package WordCounter.WordCounterHadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WordCounterMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text , IntWritable>{

	Text word = new Text();
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		String line = value.toString();
		
		StringTokenizer tokens = new StringTokenizer(line, " ");
		
		while(tokens.hasMoreTokens()) {
			word.set(tokens.nextToken());
			
			output.collect(word, new IntWritable(1));
		}
	
	}
}
