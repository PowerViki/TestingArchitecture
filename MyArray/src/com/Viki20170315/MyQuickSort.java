package com.Viki20170315;

public class MyQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[]{5,7,3,2,4,1,15,7,19};
		QuickSort qs = new QuickSort();
		//qs.quick(array);
		qs.printArr(array);
		qs.quickSort(array, 0, array.length-1);
		qs.printArr(array);
	}
	
	public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }

}
