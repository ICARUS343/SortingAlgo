/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.Calendar;

public class Sorting {


	/**
	 * 
	 * Sorts the numbers present in the file based on the algorithm provided.
	 * 0 = Arrays.sort() (Java Default)
	 * 1 = Bubble Sort
	 * 2 = Selection Sort 
	 * 3 = Insertion Sort 
	 * 4 = Mergesort
	 * 5 = Quicksort
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args)  { 
		In in = new In(args[0]);
		int useAlgo = 0;
		
		if (args.length > 0) {
			try {
				useAlgo = Integer.parseInt(args[1]);
				
			} catch (NumberFormatException e) {
				System.err.println("Argument  " + args[1] + " must be an integer.");
				System.exit(1);
			}
		} 

		// Storing file input in an array
		int[] a = in.readAllInts();
		int[] b = a.clone();

		Arrays.sort(b);

		int[] c = b.clone();
		int temp;
		for (int i = 0; i < c.length/2; i++) 
		{
			temp = c[i];

			c[i] = c[c.length-1-i];

			c[c.length-1-i] = temp;
		}

		int[] d = b.clone();
		for (int i = 0; i < d.length*.1; i++) 
		{
			temp = d[i];

			d[i] = d[d.length-1-i];

			d[d.length-1-i] = temp;

		}


		
		
			Stopwatch timer = new Stopwatch();
		double time1=0.0;
		double time2=0.0;
		double time3=0.0;
		double time4=0.0;
			String algorithmUsed = "Java Default";
			
		if(useAlgo == 0){
			 algorithmUsed = "Java Default";

			Arrays.sort(a);
				 time1 = timer.elapsedTimeMillis();
		
			
			
			Arrays.sort(b);
			 time2 = timer.elapsedTimeMillis();
		
			Arrays.sort(c);
			 time3 = timer.elapsedTimeMillis();
		
			Arrays.sort(d);
			 time4 = timer.elapsedTimeMillis();
		
		}


		if(useAlgo == 1){
		 algorithmUsed = "Bubble Sort";
			
			


			bubbleSort(a);
				 time1 = timer.elapsedTimeMillis();
		
			bubbleSort(b);
			 time2 = timer.elapsedTimeMillis();
		
			bubbleSort(c);
			 time3 = timer.elapsedTimeMillis();
			
			bubbleSort(d);
			 time4 = timer.elapsedTimeMillis();
			
		}			
		else if(useAlgo == 2){
			 algorithmUsed = "Selection";

			selectionSort(a);
				 time1 = timer.elapsedTimeMillis();
		
			selectionSort(b);
			 time2 = timer.elapsedTimeMillis();
		
			selectionSort(c);
			 time3 = timer.elapsedTimeMillis();
		
			selectionSort(d);
	 		time4 = timer.elapsedTimeMillis();
		
			
		}


		else if(useAlgo == 3){
			 algorithmUsed = "Insertion Sort";

			insertionSort(a);
				 time1 = timer.elapsedTimeMillis();
		
			insertionSort(b);
			 time2 = timer.elapsedTimeMillis();
		
			insertionSort(c);
			 time3 = timer.elapsedTimeMillis();
		
			insertionSort(d);
			 time4 = timer.elapsedTimeMillis();
			

		}



	else if(useAlgo == 4){
			 algorithmUsed = "Merge Sort";

			mergeSort(a);
			 time1 = timer.elapsedTimeMillis();
			
			mergeSort(b);
			 time2 = timer.elapsedTimeMillis();
			
			mergeSort(c);
			 time3 = timer.elapsedTimeMillis();
			
			mergeSort(d);
			 time4 = timer.elapsedTimeMillis();
			

			}

			else if(useAlgo == 5){
		
			 algorithmUsed = "Quick Sort";
			quickSort(a);
			 time1 = timer.elapsedTimeMillis();
			
			quickSort(b);
			 time2 = timer.elapsedTimeMillis();
			
			quickSort(c);
			 time3 = timer.elapsedTimeMillis();
			
			quickSort(d);
			 time4 = timer.elapsedTimeMillis();
			
			}
			//quick sort
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String netID = "pshivako";
			
			String arrayUseda = "a";
			Write(a,1);
			StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUseda, time1, timeStamp, netID, args[0]);

			String arrayUsedb = "b";
			Write(b,2);
			
			StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedb, time2-time1, timeStamp, netID, args[0]);

			String arrayUsedc = "c";
			Write(c,3);
			
			StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedc, time3-time2, timeStamp, netID, args[0]);

			String arrayUsedd = "d";
			Write(a,4);
			
			
			StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsedd, time4-time3, timeStamp, netID, args[0 ]);

			System.out.println("                                                                        ");

		
}

	








	public static void bubbleSort(int[] unsorted) {

		for(int i = 0; i < unsorted.length; i++) {
			for(int j = 0; j < unsorted.length; j++) {
				if(unsorted[i] < unsorted[j]) {
					int temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}

	}

	public static  void insertionSort(int[] input){

		int temp;
		for (int i = 1; i < input.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(input[j] < input[j-1]){
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] a) {

		int min;
		for (int out = 0; out < a.length - 1; out++) {
			min = out;
			for (int in = out + 1; in < a.length; in++) {
				if (a[in] < a[min]) {
					min = in;

				}
			}
			int tempValue = a[out];
			a[out] = a[min];
			a[min] = tempValue;

		}    
	}


//==================================================================================\\
//Starting merge sort

//the main function which makes recursive calls on the other function
	public static void mergeSort(int [ ] a)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}

//this function does the sorting section
//breaks down functions until reach the base case at which time we will merge the arrays button up	
	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

//The merge function merges once every element is in it's base case: single elements
    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left]<(a[right]))
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    //end of mergeSort
 //=========================================================================================\\

//=========================================================================================\\
    //starting quick sort//////////////////////////////////////
    public static void quickSort (int[] newArray){
    	quickSort(newArray, 0, newArray.length-1);
    }
    public static void quickSort(int[] inputArray, int low, int high) {
		
		int iLowerIndex = low;
		int iHighIndex = high;
		
		// Take middle as pivot element.
		int middle = low + (high - low) / 2;
		int pivotElement = inputArray[middle];

		while (iLowerIndex <= iHighIndex) {

			// Keep scanning lower half till value is less than pivot element
			while (inputArray[iLowerIndex] < pivotElement) {
				iLowerIndex++;
			} 
			
			// Keep scanning upper half till value is greater than pivot element 
			while (inputArray[iHighIndex] > pivotElement) {
				iHighIndex--;
			}

			//swap element if they are out of place
			if (iLowerIndex <= iHighIndex) {
				swap(inputArray, iLowerIndex, iHighIndex);
				iLowerIndex++;
				iHighIndex--;
			}
		}

		// Sort lower half -- low to iHighIndex
		if (low < iHighIndex) {
			quickSort(inputArray, low, iHighIndex);
		}

		// Sort upper half -- iLowerIndex to high
		if (iLowerIndex < high) {
			quickSort(inputArray, iLowerIndex, high);
		}
	}

	//swap elements
	private static void swap(int[] arr, int iElement1, int iElement2) {
		int temp = arr[iElement1];
		arr[iElement1] = arr[iElement2];
		arr[iElement2] = temp;
	}































/*This function creates and writes a new file every time we sort any function
The default file name is 1.txt for the initially unsorted array a  
*/
	public static void Write(int array[], int fileName){
        try {
            //Whatever the file path is.
        	File file = new File("1.txt");
        	if(fileName == 1){
            file = new File("1.txt");
            }
            else if(fileName == 2)
            {
             file = new File("2.txt");
            }
            else if(fileName == 3)
            {
             file = new File("3.txt");
            }
            else if(fileName == 4)
            {
            	 file = new File("4.txt");
            }
   	
            FileOutputStream is = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write(Arrays.toString(array));
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
       
            
    
  }





} 


