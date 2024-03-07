package com.anurag.Arrays;

public class LinearJump {

	public static int linearJ(int [] array){
        int jumps=0;
        int i=0;
        while(i!=array.length-1){
        	System.out.println("SAFAWDWCSA");
            if(array[i]==1){
            	System.out.println("1");
            	i++;
                jumps++;
            }
            if(array[i]>=array.length-1){
            	System.out.println("2");
            	jumps++;
                break;
            }
            if(array[i]!=1){
            	System.out.println("3");
            	int greaterInRange=Integer.MIN_VALUE;
                int index=0;
                for(int j=i+1;j<=i+array[i];j++){
                    if(array[j]>greaterInRange){
                    	System.out.println(i+" "+j);
                        greaterInRange=array[j];
                        System.out.println(greaterInRange);
                        index=j;
                    }
                    System.out.println("indx"+index);
                }            
                i=index;
                jumps++;
            }
              
        }
        System.out.println(jumps);
        return jumps;
    }
	
	public static int linearJumpLogicMojo(int [] array) {
		int a=array[0];//using this we can identify when it is best to jump
		int b=array[0];//using this we store the greatest number of jumps we can take in the range of previous jump 
		int jumps=1;
		for(int i=1;i<array.length;i++) {
			//Reached the end of an array
			if(i==array.length-1) {
				return jumps;
			}
			//we do this step to identify next best location to jump
			a--;
			b--;
			if(array[i]>b) {
				b=array[i];
			}
			//when condition matches we jump to next location 
			if(a==0) {
				jumps++;
				a=b;
			}
		}
		return jumps;
	}
	
    public static void main(String[] args){
        int arr[]={2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(linearJumpLogicMojo(arr));
    }

}
