package com.Viki20170315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MyList {
	
    
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
     Integer a1[] = new Integer[]{5,5,4,6,7,8,2,1,1,15};
     Integer a2[] = new Integer[]{1,5,12,7,9,9,11,17,19};
     List<Integer> list1 = Arrays.asList(a1);
     List<Integer> list2 = new ArrayList();
     for (int t:a2){
    	 if(list1.contains(t)){
    		 list2.add(t);
    	 }
     }
     Iterator it = list2.iterator();
     while(it.hasNext()){
    	 System.out.println(it.next());
     }
     

    /* int max;
     int second;
     if(array[0]>array[1]){
    	 max = array[0];
    	 second = array[1];
     }else{
    	 max = array[1];
    	 second = array[0];
     }
     
     for (int i=2;i<array.length;i++){
    	 if(array[i]>max){
    		 second = max;
    		 max = array[i];
    	 }
    	 if(array[i]<max&&array[i]>second){
    		 second = array[i];
    	 }
     }
     System.out.println(second);*/
     
    /* int max;
     int min;
     max=min=array[0];
     for (int i=0;i<array.length;i++){
    	 if (array[i]>max){
    		 max = array[i];
    	 }
         if (array[i]<min){
        	 min = array[i];
         }
    		 
		
	}
     System.out.println("最小值是："+min);
     System.out.println("最大值是"+max);

*/
		/*List<Integer> list  = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(7);
		list.add(6);
		list.add(100);
		list.add(11);
		
		int max;
		int min;
		max = Collections.max(list);
		min = Collections.min(list);
		
		System.out.println("最小值是："+min);
	    System.out.println("最大值是"+max);*/
		
}
}
