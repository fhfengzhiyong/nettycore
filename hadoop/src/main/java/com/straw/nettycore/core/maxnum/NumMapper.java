package com.straw.nettycore.core.maxnum;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author fengzy
 * @date 1/12/2018
 */
public class NumMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String year = line.substring(0, 4);
        context.write(new Text(year), new IntWritable(Integer.parseInt(line.substring(4, line.length()))));
    }
}
