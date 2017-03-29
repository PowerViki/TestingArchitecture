package com.MessageExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MessageFileWrite {
	
	//ReadBigFile file = new ReadBigFile();
	private String messageid;
	private String[] filepath;
	private String newfilepath;
	private String filetype = ".txt";
	private String filename;
	private String os = System.getProperties().getProperty("os.name");
	
	public String getMessageid() {
		return messageid;
	}


	public String getFilename() {
		return filename;
	}

	public MessageFileWrite(String filename,String messageid){
		this.filename = filename;
		this.messageid = messageid;
	}

	public void writefile(String str){
		
		filepath = this.filename.split("/");
		StringBuffer str1= new StringBuffer();
        if (!os.matches("Windows")){
        	str1.append("/");
        	
        }
		for (int i=0;i<filepath.length-1;i++){
			str1.append(filepath[i]);
			str1.append("/");
		}
		str1.append(this.messageid);
		str1.append(filetype);
		
		newfilepath = str1.toString();
		//System.out.println(newfilepath);
		
		File myfile = new File(newfilepath);
		if (myfile.exists()){
			myfile.delete();
		}
		try {
			myfile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter f = null;
		try {
			f = new FileWriter(myfile);
			f.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void writefile(String str,int num){
		
		filepath = this.filename.split("/");
		StringBuffer str1= new StringBuffer();

		for (int i=0;i<filepath.length-1;i++){
			str1.append(filepath[i]);
			str1.append("/");
		}
		str1.append(this.messageid);
		str1.append(filetype);
		
		newfilepath = str1.toString();
		
		File myfile = new File(newfilepath);
		if (myfile.exists()){
			myfile.delete();
		}
		try {
			myfile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter f = null;
		try {
			f = new FileWriter(myfile,true);
			for (int j=0;j<num;j++){
			f.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
