package com.Viki20170315;

public class MyReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "This is a Test!";
    /*    String newstr = new StringBuffer(str).reverse().toString();
        System.out.println(newstr);*/
        reverse3(str);
	}
	
	public static void reverse1(String s){
		char arr[] = s.toCharArray();
		String newstr = "";
		for(int i=arr.length-1;i>=0;i--){
			newstr = newstr+arr[i];
		}
		System.out.println(newstr);
		
	}
	public static void reverse2(String s){
		String newstr = "";
		for(int i=s.length()-1;i>=0;i--){
			newstr = newstr+s.charAt(i);
		}
		System.out.println(newstr);
		
	}
	public static void reverse3(String s){
		char arr[] = s.toCharArray();
		char a;
		int len = arr.length-1;
		for(int i=0;i<=len/2;i++){
			a = arr[i];
			arr[i] = arr[len-i];
			arr[len-i] = a;
		}
		System.out.println(new String(arr));
		
	}

}
