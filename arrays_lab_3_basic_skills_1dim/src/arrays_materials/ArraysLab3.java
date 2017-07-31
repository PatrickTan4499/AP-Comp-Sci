package arrays_materials;

import java.util.Arrays;
/*
 * Patrick Tan
 * 11/1/16
 * 1st Period APCS
 * Array Lab 3 - Goal: To create a class named ArraysLab3 that contains 6 static methods: 
 * sum - Make new array and add indexes of i together in for loop and assign the value to the index of new array i
 * append - Make new array of length +1 using copyOfAssign last index to num
 * remove - Look for index given in for loop then use if statement to delete the element
 * sumEven - For loop to add all indexes if they are divisible by 2
 * rotateRight - Store first element then Make element at index i = index of i-1 and last index the first index by storing it in a variable
 * and main that alters arrays in different ways
 * 
 */
public class ArraysLab3 
{
	/*
	 * Write a method named sum that accepts two arrays of integers arr1 and arr2 
	 * and returns an array of integers, 
	 * in which every element is the sum of the elements at that index for the arrays arr1 and arr2. 
	 * You can assume arrays arr1 and arr2 have at least one element each and are the same length.
	 */
	public static int[] sum(int[] arr1, int[] arr2)
	{
		assert (arr1.length > 0);
		assert (arr2.length > 0);
		assert (arr1.length == arr2.length);
		int[] arr3 = new int[arr1.length];  //makes new array to store values added from arr1 and arr2 at indexes of 1
		for(int i=0; i <arr1.length; i++){
			arr3[i] = arr1[i] + arr2[i];
		}
		return arr3;
	}
	
	/*
	 * Write a method named append that accepts an array of integers arr of length n 
	 * and an integer num, and returns an array of integers of length n+1 
	 * that consists of the elements of arr with num appended to the end.  
	 * You can assume array arr has at least one element.
	 */
	public static int[] append(int[] arr, int num)
	{
		assert (arr.length > 0);
		int[] append = new int[arr.length+1];
		for(int i=0; i<arr.length; i++){
			append[i] = arr[i];					//copies all values from inputed array into new arr with 1 empty index at the end 
		}
		append[append.length-1] = num;
		return append;
		
	}
	
	/*
	 * Write a method named remove that accepts an array of integers arr and an integer idx 
	 * and returns an array of integers consisting of all of the elements of arr 
	 * except for the element at index idx (thus, the returned array has a length of arr.length � 1).  
	 * You can assume arr has at least two elements.
	 */
	public static int[] remove(int[] arr, int idx)
	{
		assert (arr.length >= 2);
		int[] arr2 = new int[arr.length-1];
		for(int i=0; i < idx; i++){					//copies all elements into new array up to inputed index
				 arr2[i]= arr[i];
		}
		for(int i=idx; i<arr.length-1; i++){
			arr2[i]=arr[i+1];					//skip the inputed index and move ever next element into the new array
		}
		return arr2;
		}
	
	/*
	 * Write a method sumEven that accepts an array of integers arr 
	 * and returns an integer containing the sum of the elements at the even indices of arr.  
	 * (That means elements at indices 0,2,4,6,8.)  You can assume arr has at least one element.
	 */
	public static int sumEven(int[] arr)
	{
		assert (arr.length > 0);
		int total = 0;
		for (int i =0; i<arr.length; i++){
			if(i % 2 == 0){					// tests if index if even and then adds the element to an outside variable to total all elements up
				total += arr[i];
			}
		}
		return total;
		
	}
	
	/*
	 * Write a method rotateRight that accepts an array of integers arr 
	 * and does not return a value.  
	 * The rotateRight method moves each element of arr one index to the right 
	 * (element 0 goes to element 1, element 1 goes to element 2, �, element n-1 goes to element 0).  
	 * You can assume arr has at least one element.
	 */
	public static void rotateRight(int[] arr)
	{
		assert (arr.length > 0);
		int last = arr[arr.length-1];			//stores last element into a variable
		for(int i=arr.length-1; i>=1; i--){ 	// rotates everything to the right
			arr[i] = arr[i-1];					
		}
		arr[0]= last;						// puts stored element into the first index
	}

	/*
	 * Write a main method that will 
		Contain
			integer arrays a1, a2, sumArr, appendArr, removeArr
			int variables appendNum, removeIdx, sumOfEvens
		Carry out the following actions
			Declare array a1 containing the values (5, 10, 15, 20, 25, 30, 35, 40) 
			and array a2 containing the values (7, 14, 21, 28, 35, 42, 49, 56)
			Form sumArr by calling the sum method with a1 and a2 as inputs
			Declare int appendNum and set it to 200.
			Form appendArr by calling the append method with a1 and appendNum as inputs
			Declare int removeIdx and set it to 5.
			Form removeArr by calling remove with a2 and removeIdx
			Form sumOfEvens by calling sumEven with appendArr as the input
			Call rotateRight with a1 as the input
			On their own lines print out (use Arrays.toString to transform arrays into a printable strings) :
				sumArr
				appendArr
				removeArr
				sumOfEvens (an int you don�t need Arrays.toString)
				a1
	 */
	
	public static void main(String[] args) 
	{
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr;
		int[] appendArr;
		int[] removeArr;
		int appendNum;
		int removeIdx;
		int sumOfEvens;
		
		sumArr = sum(a1, a2);
		appendNum = 200;
		appendArr = append(a1, appendNum);
		removeIdx = 5;
		removeArr = remove(a1, removeIdx);
		sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
				
	}
}
