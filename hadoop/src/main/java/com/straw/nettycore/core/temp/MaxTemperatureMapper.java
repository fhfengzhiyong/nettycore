package com.straw.nettycore.core.temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    public static final int MISSING = 9999;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.length()<10){
            return;
        }
        String yesr = line.substring(1, 5);
        int airTemperature;
        airTemperature = Integer.parseInt(line.substring(5,10));
        context.write(new Text(yesr),new IntWritable(airTemperature));
    }
}
