package com.harish.mp3tag;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import com.harish.mp3tag.util.LogValues;
import com.harish.mp3tag.util.Logger;

public class AlbumRenamer {
	public void execute(File file){
		try{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Entering into execute method");
			if(file.isDirectory()){
				iterate(file);
			}else if(file.isFile()){
				rename(file);
			}
		}catch(Exception ex){
			Logger.sysLog(LogValues.error, App.class.getName(), ex);
		}finally{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Exiting from execute method");
		}
	}
	
	public void rename(File file){
		try{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Entering into rename method");
			if(file.getName().endsWith(".mp3")){
				String albumnName = file.getParentFile().getName();
				String title = file.getName().replaceAll(".mp3", "").trim();				
				AudioFile audioFile = AudioFileIO.read(file);
				Tag tag = audioFile.getTagOrCreateAndSetDefault();				
				tag.setField(FieldKey.ALBUM,albumnName);
				tag.setField(FieldKey.TITLE, title);
				audioFile.commit();
				Logger.sysLog(LogValues.info, this.getClass().getName(), "File:"+file.getName()+";Albumn:"+albumnName);
			}
		}catch(Exception ex){
			Logger.sysLog(LogValues.error, App.class.getName(), ex);
			ex.printStackTrace();
		}finally{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Exiting from rename method");
		}
    	
	}
	public void iterate(File directory){
		try{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Entering into iterate method");
			File[] files = directory.listFiles();
			for(File file: files){
				if(file.isDirectory()){
					iterate(file);
				}else if (file.isFile()){
					rename(file);
				}
			}
		}catch(Exception ex){
			Logger.sysLog(LogValues.error, App.class.getName(), ex);
		}finally{
			Logger.sysLog(LogValues.debug, this.getClass().getName(), "Exiting from iterate method");
		}
	}
}