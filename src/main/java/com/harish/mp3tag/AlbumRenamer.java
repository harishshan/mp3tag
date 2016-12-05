package com.harish.mp3tag;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlbumRenamer {
	private static final Logger logger = LoggerFactory.getLogger(AlbumRenamer.class);
	public void execute(File file){
		try{
			logger.debug("Entering into execute method");
			if(file.isDirectory()){
				iterate(file);
			}else if(file.isFile()){
				rename(file);
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
		}finally{
			logger.debug("Exiting from execute method");
		}
	}
	
	public void rename(File file, int trackNumber){
		try{
			logger.debug("Entering into rename method with trackNumber");
			if(file.getName().endsWith(".mp3")){
				String albumnName = file.getParentFile().getName();
				String title = file.getName().replaceAll(".mp3", "").trim();				
				AudioFile audioFile = AudioFileIO.read(file);
				Tag tag = audioFile.getTagOrCreateAndSetDefault();				
				tag.setField(FieldKey.ALBUM,albumnName);
				tag.setField(FieldKey.TITLE, title);
				try{
					tag.setField(FieldKey.ALBUM_ARTIST,"Harish Shan");
				}catch(Exception ex){
					//logger.error("Exception:", ex);
				}
				tag.setField(FieldKey.TRACK,String.valueOf(trackNumber));
				audioFile.commit();
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
			System.exit(0);
		}finally{
			logger.debug("Exiting from rename method");
		}
    	
	}
	public void rename(File file){
		try{
			logger.debug("Entering into rename method");
			if(file.getName().endsWith(".mp3")){
				String albumnName = file.getParentFile().getName();
				String title = file.getName().replaceAll(".mp3", "").trim();				
				AudioFile audioFile = AudioFileIO.read(file);
				Tag tag = audioFile.getTagOrCreateAndSetDefault();				
				tag.setField(FieldKey.ALBUM,albumnName);
				tag.setField(FieldKey.TITLE, title);
				try{
					tag.setField(FieldKey.ALBUM_ARTIST,"Harish Shan");
				}catch(Exception ex){
					//logger.error("Exception:", ex);
				}
				audioFile.commit();
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
		}finally{
			logger.debug("Exiting from rename method");
		}
    	
	}
	public void iterate(File directory){
		try{
			logger.debug("Entering into iterate method");
			File[] files = directory.listFiles();
			int i=1;
			for(File file: files){
				if(file.isDirectory()){
					iterate(file);					
				}else if (file.isFile()){
					rename(file,i);
					i++;
				}
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
		}finally{
			logger.debug("Exiting from iterate method");
		}
	}
}