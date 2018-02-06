package com.straw.nettycore.core.maxnum;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author fengzy
 * @date 1/12/2018
 */
public class NumReduce extends Reducer<Text, IntWritable, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        Iterator<IntWritable> iterator = values.iterator();
        int v = 0;
        while (iterator.hasNext()) {
            IntWritable next = iterator.next();
            v = next.get() > v ? next.get() : v;
        }
        context.write(new Text(key), new Text("" + v));
    }
}
