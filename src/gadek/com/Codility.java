package gadek.com;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import javax.naming.InvalidNameException;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Codility {
	@Test
    public void FizzBuzzV2(){
        assertEquals("Fizz", FizzBuzzOneLine(3));
        assertEquals("Buzz", FizzBuzzOneLine(5));
        assertEquals("FizzBuzz", FizzBuzzOneLine(15));
        assertEquals("2", FizzBuzzOneLine(2));
    }


	/*
	 * Main
	 * 
	 */
	public static void main(String[] args) {

	}
	
	
	public static String FizzBuzzOneLine (int number) {
		StringBuilder result = new StringBuilder();
		result.append((number % 3 == 0 ? "Fizz": "") + (number % 5 == 0 ? "Buzz" : ""));
		return result.length() > 0 ? result.toString() : String.valueOf(number);
	}
	//FizzBuzz for 100 numbers 
	public static void FizzBuzzIntStream() {
		IntStream.rangeClosed(0, 100).mapToObj(
				i -> i % 3 == 0 ?		
						(i  % 5 == 0 ? "FizzBuzz": "Fizz") :	 
						(i % 5 == 0 ? "Buzz" : i ))			
				.forEach(System.out::println);
	}
	
	public static String fizzBuzz(int number) {
		if(number % 15 == 0)
			return "FizzBuzz";
		else if(number % 3 == 0) return "Fizz";
		else if(number % 5 == 0) return "Buzz";
		return String.valueOf(number);
	}
	
	//	OddOccurrencesInArray
	//	Find value that occurs in odd number of elements.
	public static int solution2(int[] A) {
		//unique elements
		HashSet<Integer> dups = new HashSet<Integer>();
		int elem = -1;
		for (int i = 0; i < A.length; i++) {
			if (dups.add(A[i])) {
				elem = A[i];
			}
		}
		return elem;
	}
	
	// Cyclice Rotation two array
	public static int[] cyclicRotation(int[] A, int K) {
		int[] right = new int[1];
		int[] left = new int[A.length-1];
		for(int i= 0 ;i < K ; i++ )
		{
			right = Arrays.copyOfRange(A,A.length-1 ,A.length );
			left = Arrays.copyOfRange(A, 0,A.length-1 );
			A = combine(right, left);
		}	
		return A;
	}
	public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
	//frog
	public static int frogJmp(int X, int Y , int D) {
		return (int) Math.ceil((double) (Y-X)/D);
	}
	
	public static int frogJmp2(int X, int Y , int D) {
		int diff = Y-X;
		if(diff % D == 0) return diff/D;
		else return diff/D + 1;
	}
	//Missing element
	public static int PermMissingElem(int[] A) {
		Arrays.sort(A);
		 System.out.printf("Modified arr[] : %s", 
                 Arrays.toString(A)); 
		for(int x=0; x<A.length; x++) {
			if((x+1) != A[x]) {System.out.println(x+1); return x+1;}
		}
		return 10;
	}

	public static int TapeEqualibrium(int A[],int N) {
		long leftSum = 0;
		long rightSum = 0;
		long result;
		for(int i = 1 ; i< A.length ; i++) {
			rightSum += A[i];
		}
			leftSum = A[0];
			result = Math.abs(leftSum - rightSum);
			for(int P = 1 ; P < A.length ; P++) {
				if(Math.abs(leftSum - rightSum) < result){
					result = Math.abs(leftSum - rightSum);
					}
				leftSum += A[P];
				rightSum -= A[P];
			}
		return (int) result;
	}
	
	public static int PermCheck(int A[]) {
		Arrays.sort(A);
		
		for(int i = 0; i <A.length; i++) {
			if(A[i] != i + 1) {
				return 0;
			}
		}
		return 1;
	}
		
	public static int MissingInteger(int A[]) {
		HashSet<Integer> number = new HashSet<Integer>();
		int elem = 1;
		//add all elments to Set
		for (int i = 0; i < A.length; i++) {
			number.add(A[i]);
			}
		//check if hashset contain element if not return them
		while(number.contains(elem)) {
			elem++;
		}
		return elem;
	}
	
}
