package com.viki20170320;

public class GetMinMax {
	private int max;
	private int min;
	private int tempmax;
	private int tempmin;
	private int len;
	
	public GetMinMax(int a[]){
		len = a.length;
		if(len>0){
			if (len%2!=0){
				max=min=a[0];
				
				for(int i=1;i<len;i=i+2){
					if (a[i]>a[i+1]){
						tempmax = a[i];
						tempmin = a[i+1];
					}
					else{
						tempmax = a[i+1];
						tempmin = a[i];
					}
					if (tempmax>max){
						max = tempmax;
					}
					if (tempmin<min){
						min = tempmin;
					}
				}
			}
			else{
				   if(a[0]<a[1]){
						max = a[1];
					    min = a[0];
					}
					else{
						max = a[0];
						min = a[1];
					}
				   for (int i=2;i<len;i=i+2){
					   if (a[i]>a[i+1]){
							tempmax = a[i];
							tempmin = a[i+1];
						}
						else{
							tempmax = a[i+1];
							tempmin = a[i];
						}
						if (tempmax>max){
							max = tempmax;
						}
						if (tempmin<min){
							min = tempmin;
						}
					   
				}
			}
	
		}
		
	}
	public int getMax(){
		return this.max;
	}
	public int getMin(){
		return this.min;
	}
}
