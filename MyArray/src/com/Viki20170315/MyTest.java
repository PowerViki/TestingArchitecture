package com.Viki20170315;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int array[] = new int[]{5,3,7,4,1,9,0,5,11,19,13};
       quickSort(array,0,array.length-1);
       for(int i=0;i<array.length-1;i++){
    	   System.out.print(array[i]+",");
       }
       System.out.println(array[array.length-1]);
	}
	
	public static int partition(int a[],int low,int high){
		int temp = a[low];
		while(low < high){
			while(a[high]>=temp && high>low){
				high--;
			}
			a[low] = a[high];
			while(a[low]<=temp && high>low){
				low++;
			}
			a[high] = a[low];
		}
		temp = a[high];
		return high;
		
	}
	
	public static void quickSort(int a[],int low,int high){
		if(low>high){
			return;
		}
		int index = partition(a,low,high);
		quickSort(a,low,index-1);
		quickSort(a,index+1,high);
	}

}
