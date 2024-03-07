package com.anurag.Arrays;




import java.util.*; 
  
public class DesignDS1 
{ 
   //My first Data Structure to perform all operations in O(1) Time
   ArrayList<Integer> array;   
   //My second Data Structure to perform all operations in O(1) Time
   HashMap<Integer, Integer>  hash; 
  
   public DesignDS1() 
   { 
       array = new ArrayList<Integer>(); 
       hash = new HashMap<Integer, Integer>(); 
   } 
  //Inserting value in data structure involve two operations
  //addition in the arraList and inserting entry in HashMap
   void insert(int Num) 
   { 
      if (hash.get(Num) != null) 
          return; 
       
      int size = array.size(); 
      //Insert the Num in the array
      array.add(Num); 
      //Perform put() operation in the HashMap where key is 'Num'
      hash.put(Num, size); 
   } 
  //Removing element is Tricky and most imp 
   void remove(int Num) 
   { 
       //Peform Get() operation in HashMap to return value from key 'Num'
       Integer index = hash.get(Num); 
       if (index == null) 
          return; 
       //Remove Entry set having a key as 'Num'
       hash.remove(Num); 
       int size = array.size(); 
       Integer last = array.get(size-1);
       //we do not care about ordering, we can simply swap the element we want to delete with the last element
       Collections.swap(array, index,  size-1); 
       // removing the last element, which is O(1)
       array.remove(size-1); 
  
       hash.put(last, index); 
    } 
    //Returns the ransom element from array 
    int getRandom() 
    { 
       Random rand = new Random(); 
       //find any random number
       //randomly choosing an index from array.size()
       int index = rand.nextInt(array.size()); 
       
       return array.get(index); 
    } 
  
    Integer search(int Num) 
    { 
       return hash.get(Num); 
    } 

  
public static void main (String[] args) 
{ 
	DesignDS1 ds = new DesignDS1(); 
    ds.insert(12); 
    ds.insert(16); 
    ds.insert(14); 
    ds.insert(20);
    ds.insert(30);
    System.out.println(ds.search(30)); 
    ds.remove(14); 
    System.out.println(ds.search(20)); 
    System.out.println(ds.getRandom()); 
} 
} 

/* Try more Inputs
Case 1:
Main ds = new Main();
ds.insert(12); 
ds.insert(16);
ds.insert(30);
result = ds.search(30);
expected = [2]
ds.remove(30);
result = ds.search(12);
expected = [0]

Case2:
Main ds = new Main();
ds.insert(1); 
ds.insert(2);
ds.insert(-1);
result = ds.search(-1);
expected = [2]
*/

