package com.MessageExecutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;


public class MessageExecutor {
	//public final static String filepath = "D:/50041.txt";
    public final static String filepath = "/home/sumscope/Gate.Monitor.V5.log/Gate.Monitor.V5.log";
    public final static String messageid = "50041";
	public static void main(String[] args) {
		ReadBigFile myreader = new ReadBigFile(filepath);
		myreader.setMessageid(messageid);
		try {
			myreader.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
