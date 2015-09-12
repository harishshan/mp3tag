package com.harish.mp3tag;

import java.io.File;

import com.harish.mp3tag.util.LogValues;
import com.harish.mp3tag.util.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
        	Logger.sysLog(LogValues.debug, App.class.getName(), "Entering into main method");
        	Logger.sysLog(LogValues.info, App.class.getName(), "Album Rename process starting");
        	AlbumRenamer albumRenamer = new AlbumRenamer();
        	File rootFolder = new File("D:/test");
        	if(rootFolder.exists()){
        		albumRenamer.execute(rootFolder);
        	}else{
        		Logger.sysLog(LogValues.info, App.class.getName(), "No file/folder found");
        	}
        	Logger.sysLog(LogValues.info, App.class.getName(), "Album Rename process finished");
        }catch(Exception ex){
        	Logger.sysLog(LogValues.error, App.class.getName(), ex);
        }finally{
        	Logger.sysLog(LogValues.debug, App.class.getName(), "Exiting from main method");
        }
    }
    
}
