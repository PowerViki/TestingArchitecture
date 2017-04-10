package com.Viki20170315;

public class QuickSort {
	 public int getMiddle(int[] numbers, int low,int high)
	    {
		    int temp = numbers[low];
		    while(low<high)
		    {
		    	while(low<high && numbers[high]>=temp)
		    	{
		    		high--;
		    	}
		    	numbers[low] = numbers[high];
		    	while(low<high && numbers[low]<temp){
		    		low++;
		    	}
		    	numbers[high] = numbers[low];
		    	
		    }
		    numbers[high] = temp;
	    	return high;
	    }
	 
	 public void quickSort(int[] numbers,int low,int high)
	    {
		  if(low>high){
			  return;
		  }
			  int index = getMiddle(numbers,low,high);
			  quickSort(numbers,low,index-1);
			  quickSort(numbers,index+1,high);
			
		  
	    }
	 
	 public void quick(int[] numbers)
	    {
	        if(numbers.length > 0)   //查看数组是否为空
	        {
	        quickSort(numbers, 0, numbers.length-1);
	        }
	    }
	 
	 public void printArr(int[] numbers)
	    {
	        for(int i = 0 ; i < numbers.length ; i ++ )
	        {
	        System.out.print(numbers[i] + ",");
	        }
	        System.out.println("");
	    }

}
