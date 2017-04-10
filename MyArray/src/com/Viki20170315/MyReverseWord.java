package com.Viki20170315;

public class MyReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str = "This is a dog!";
       reverse(str);
	}
	public static void reverse(String s){
		String temp[] = s.split(" ");
		StringBuffer str = new StringBuffer();
		char c[];
		for(int i=temp.length-1;i>=0;i--){
			if (temp[i].contains("!")||temp[i].contains(".")||temp[i].contains("?")||temp[i].contains(",")){
				
				c = temp[i].toCharArray();
				String ss = ""+c[c.length-1];
				for(int j=0;j<c.length-1;j++){
					ss+=c[j];
				}
				temp[i] = ss;	
			
		}
		str.append(temp[i]);
		str.append(" ");
		}
		String newstr = str.substring(0, s.length());
		System.out.println(newstr);
	}

}
