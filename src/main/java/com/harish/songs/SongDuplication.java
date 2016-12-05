package com.harish.songs;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SongDuplication {

	private static final Logger logger = LoggerFactory.getLogger(SongDuplication.class);
	public static void main(String[] args) {
		try{
			File rootFolder = new File("C:\\Users\\hshanmugam\\Desktop\\Chitra");
			for(File folder:rootFolder.listFiles()){
				if(folder !=null && folder.isDirectory()){
					for(File file:folder.listFiles()){
						System.out.println("Filename"+file.getAbsolutePath());
						String filepath = file.getAbsolutePath().replace(" .mp3", ".mp3");
						file.renameTo(new File(filepath));
						
					}
				}
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
        	ex.printStackTrace();
        }finally{
        	logger.debug("Exiting from main method");
        }
	}
	public static void findDeletedFolders(){
		try{
			logger.debug("Entering into findDeletedFolders method");
			File folder1 = new File("C:\\Users\\hshanmugam\\Desktop\\Chitra");
			File folder2 = new File("C:\\Harish\\Songs\\Movies");			
			String folder[] = folder1.list();
			List<String> folderList = Arrays.asList(folder);
			System.out.println(folderList);
			int count=0;
			for(String f2: folder2.list()){			
				if (!folderList.contains(f2)){					
					System.out.println(f2);
					count++;
				}				
			}
			System.out.println(count);
		}catch(Exception ex){
			logger.error("Exception:", ex);
        }finally{
        	logger.debug("Exiting from findDeletedFolders method");
        }
	}
	public static void findAverage(){
		try{
			logger.debug("Entering into main method");
			File rootfolder = new File("C:\\Users\\hshanmugam\\Desktop\\Chitra");
			int folderCount = 0;
			int filesCount =0;
			for(File folder: rootfolder.listFiles()){
				folderCount++;
				String files[] = folder.list();
				if(files != null)
					filesCount = filesCount + files.length;
			}
			System.out.println("Folder Count:"+ folderCount+ ", Files Coount:"+ filesCount + ", Average Files:"+ (filesCount/folderCount));
			int avg = filesCount/folderCount;
			for(File folder: rootfolder.listFiles()){
				String files[] = folder.list();
				if(files != null){
					if((files.length >7)){
						System.out.println(folder + "--"+ files.length);
					}
				}
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
        	ex.printStackTrace();
        }finally{
        	logger.debug("Exiting from main method");
        }
	}
	public static void findMissingSongs(){
		try{
			logger.debug("Entering into main method");
			File folder1 = new File("C:\\Users\\hshanmugam\\Desktop\\Chitra");
			File folder2 = new File("C:\\Harish\\Songs\\Music");
			
			String folder[] = folder1.list();
			List<String> folderList = Arrays.asList(folder);
			
			for(String f2: folder2.list()){			
				if (folderList.contains(f2)){					
					File file1 = new File("C:\\Users\\hshanmugam\\Desktop\\Chitra\\"+f2);
					File file2 = new File("C:\\Harish\\Songs\\Music\\"+f2);
					String files[] = file1.list();
					List<String> filesList = Arrays.asList(files);
					for(String f3: file2.list()){
						if(!filesList.contains(f3)){
							System.out.println("Folder:"+f2+";Song:"+f3);
						}
					}
				} else {
					
				}
			}
		}catch(Exception ex){
			logger.error("Exception:", ex);
        	ex.printStackTrace();
        }finally{
        	logger.debug("Exiting from main method");
        }
	}
}