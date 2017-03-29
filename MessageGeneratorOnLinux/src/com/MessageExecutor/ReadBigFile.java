package com.MessageExecutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBigFile {
	private String filepath;//= "D:/50041.txt";
	private String tempstr;
    private char[] buffer = new char[1024*1024*3];
    private int byteread = 0;
    private int start;
    private int end;
    private String messageid;
    
    public ReadBigFile(){
    }
    
    public ReadBigFile(String filepath){
    	this.filepath = filepath;
    }
    
    public String getFilePath(){
    	return this.filepath;
    }
    
    public String getMessageid() {
		return this.messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
    
	
	public void readFile() throws IOException{
		  //RandomAccessFile randomFile;
		  //randomFile = new RandomAccessFile(filepath, "r");
		 // long fileLength = randomFile.length();
		  BufferedReader cpreader = new BufferedReader(new InputStreamReader(new FileInputStream(this.getFilePath())));
		  while((byteread=cpreader.read(buffer))!=-1){
	          String str = new String(buffer,0,byteread);
			  Matcher start_line = Pattern.compile("\\[\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\]\\[Type\\]\\("+this.getMessageid()+"\\)").matcher(str);
			  
			  Matcher end_line = Pattern.compile("\\[\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\]msg_size = \\d{1,}").matcher(str);
	          
			 Matcher response_line = Pattern.compile("\\[\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\]<MAP>\\[AckMsgHead\\]").matcher(str);
			  
			  loop1:while(start_line.find()){
				  loop2:while(response_line.find()){
					  continue loop1;
				  }
				 // randomFile.seek(start);
			     // System.out.println(start_line.group());
				  loop3:while(end_line.find()){
					  start=start_line.start();
					  end = end_line.end();
					  tempstr = new String(buffer,start,end-start);
					  //System.out.println(end_line.group());
					  break loop1;
				  }
			  }
		  }
		  cpreader.close();
		  if (tempstr!=null){
			  MessageFileWrite write = new MessageFileWrite(this.getFilePath(),this.getMessageid());
			  write.writefile(tempstr);
		  }

    }

}
