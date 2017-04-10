package com.Viki20170315;

public class Mysort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = new int[]{1,5,7,8,9,12,15,17,21};
        int[] a1 = new int[]{5,6,7,12,19,20,21,22};
        int flg = 0;
        loop1:for(int i=0;i<a.length;i++){
          loop2:for(int j=flg;j<a1.length;j++){
        	    
        		if(a[i]>a1[j]){
        			flg = j+1;
        		}
        		else if(a[i]==a1[j]){
        			flg = j+1;
        			System.out.println(a[i]);
        			continue loop1;

        		}
        	}
        }
	}

}
