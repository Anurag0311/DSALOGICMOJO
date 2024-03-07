package com.anurag.Arrays;


/*
 * 
You need to design a data structure which support below operation in O(1) time complexity
1) Insert() which adds an element to the data structure
2) remove() which removes an element from the data structure
3) findMiddle() which will return middle element
4) deleteMiddle() which will delete the middle element.

Insert(1) --- O(1) time complexity
Insert(2)
Insert(3)
findMiddle() – 2 in O(1) time complexity
Insert(4)
Insert(5)
deleteMiddle() - remove 3 in O(1) time complexity
remove(5) – in O(1) time complexity
 * */

public class DesignDS2 {
	
	class DLL{
		DLL next;
		DLL prev;
		int value;
		DLL(int data){
			this.value = data;
			next = null;
			prev=null;
		}
		
	}
	
	DLL head = null;
	DLL middle;
	int size =0;
	public void push(int val) {
		size++;
		if(head == null) {
			head = new DLL(val);
			middle = head;
		}
		else {
			DLL node = new DLL(val);
			node.next = head;
			node.prev = node;
			head = node;
			if(size % 2 == 0) {
				middle = middle.prev;
			}
			
		}
	}
	
	public int pop() {
		if(head == null) {
			return -1;
		}
		size--;
		int ret;
		ret = head.value;
		if(size == 0) {
			head = null;
			middle = null;
		}
		else {
			head = head.next;
			head.prev = null;
			if(size % 2 == 1) {
				middle = middle.next;
			}
		}
		return ret;
	}
	
	public int findMiddle() {
		return middle.value;
	}
	
	public void deleteMiddle() {
		size--;
		if(middle.prev != null) {
			middle.prev.next = middle.next;
		}
		if(middle.next != null) {
			middle.next.prev = middle.prev;
		}
		if(size % 2 == 1) {
			middle = middle.next;
		}
		else {
			middle = middle.prev;
		}
	}
	
	public static void main(String args[]) 
	{ 
		DesignDS2 ms = new DesignDS2();
		ms.push(11); 
		ms.push(22); 
		ms.push(33); 
		ms.push(44); 
		ms.push(55); 
		ms.push(66); 
		ms.push(77); 
		
		System.out.println("Item popped is " + ms.pop()); 
		System.out.println("Item popped is " + ms.pop()); 
		System.out.println("Middle Element is " + ms.findMiddle()); 
	} 

}
