package com.MessageExecutor;


import java.io.IOException;



public class MessageExecutor {
	//public final static String filepath = "F:/Serverlogaa.txt";
    public final static String filepath = "/home/sumscope/Gate.Monitor.V5.log/GateMonitorV5_20161129.log";
    public final static String messageid = "55020";
    
	public static void main(String[] args) {
		ReadBigFile myreader = new ReadBigFile(filepath);
		String msglist[] = new String[]{"50330","50666","50255","50049","55300","50048","50658","50659","50620","50667","61160","50253"};
		for(int i=0;i<msglist.length;i++){
			myreader.setMessageid(msglist[i]);
			try {
				myreader.readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
    }
}
