package com.harish.mp3tag;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        try{
        	//Java Logging Configuration
        	java.util.logging.Logger rootLogger = java.util.logging.Logger.getLogger("");
        	rootLogger.setLevel(java.util.logging.Level.WARNING);
        	rootLogger.getHandlers()[0].setLevel(java.util.logging.Level.WARNING);
        	logger.info("Entering into main method- Album Rename process starting");
        	
        	String path = "C:\\Harish\\Songs\\Music";
        	if(args.length == 1)
        		path = args[0];
        	AlbumRenamer albumRenamer = new AlbumRenamer();
        	File rootFolder = new File(path);
        	if(rootFolder.exists()){
        		albumRenamer.execute(rootFolder);
        	}else{
        		logger.info("No file/folder found");
        	}        	
        }catch(Exception ex){
        	logger.error("Exception:",ex);
        }finally{
        	logger.info("Exiting from main method");
        }
    }
    
}
