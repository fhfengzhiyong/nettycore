package com.straw.nettycore;

import com.straw.nettycore.core.MyIOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author fengzy
 * @date 1/10/2018
 */
public class HdfsTest {
    private static final Logger logger = Logger.getLogger(HdfsTest.class);
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(new ConsoleAppender(new PatternLayout("%-6r [%p] %c - %m%n")));
    }
    //String HDFS_URL = "hdfs://172.19.2.80:9000";
    String HDFS_URL = "hdfs://192.168.2.105:9000";

    @Test
    public void find() throws Exception {
        InputStream in = null;
        try{
            String hdfsurl = HDFS_URL+"/user/a.txt";
            in = new URL(hdfsurl).openStream();
            IOUtils.copyBytes(in,System.out,4096,false);
        }catch (Exception e){
            IOUtils.closeStream(in);
            e.printStackTrace();
        }
    }
    @Test
    public void put() throws IOException, URISyntaxException, InterruptedException {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        logger.addAppender(consoleAppender);
        //HDFS URI
        String hdfsuri = HDFS_URL;
        String path="/user/hdfs/example/hdfs/";
        String fileName="hello.csv";
        String fileContent="hello;world";
        // ====== Init HDFS File System Object
        Configuration conf = new Configuration();
        // Set FileSystem URI
        conf.set("fs.defaultFS", hdfsuri);
        // Because of Maven
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());

        // Set HADOOP user
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        System.setProperty("hadoop.home.dir", "/");
        String user = "hadoop";
        //Get the filesystem - HDFS
        FileSystem fs = FileSystem.get(URI.create(hdfsuri), conf,user);

        //==== Create folder if not exists
        Path workingDir=fs.getWorkingDirectory();
        Path newFolderPath= new Path(path);
        if(!fs.exists(newFolderPath)) {
            // Create new Directory
            fs.mkdirs(newFolderPath);
            logger.info("Path "+path+" created.");
        }

        //==== Write file
        logger.info("Begin Write file into hdfs");
        //Create a path
        Path hdfswritepath = new Path(newFolderPath + "/" + fileName);
        //Init output stream
        FSDataOutputStream outputStream=fs.create(hdfswritepath);
        //Cassical output stream usage
        outputStream.writeBytes(fileContent);
        outputStream.close();
        logger.info("End Write file into hdfs");

        //==== Read file
        logger.info("Read file into hdfs");
        //Create a path
        Path hdfsreadpath = new Path(newFolderPath + "/" + fileName);
        //Init input stream
        FSDataInputStream inputStream = fs.open(hdfsreadpath);
        //Classical input stream usage
        String out= MyIOUtils.toString(inputStream, "UTF-8");
        logger.info(out);
        inputStream.close();
        fs.close();
    }

}
