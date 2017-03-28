package com.viki20170320;

import java.io.File;
import java.io.IOException;

public class MyTest {
	 
	public static void main(String args[]){
		//String a = "Hello";
		//String b = "a";
		File f = new File("D:"+File.separator+"Test.txt");
		//System.out.print(a+""+b);
	/*	try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if (f.exists()){
			if (f.isDirectory()){
				
			}
		}
	}

}
