import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;



public class HeapSortAlgo

{
    static  int heapsize;

    public static void main(String args[])
    {
        
       Vector<Integer> numArray = new Vector<Integer>(); // numArray used to store 90001.txt file integers
        Scanner myScanner = new Scanner("foo"); // variable used to read file
        String userinput="90001.txt";
        

        try
        {
             File inputfile = new File("C:\\Users\\krown\\eclipse-workspace\\HeapSort_10000words\\src\\" + userinput);
             myScanner = new Scanner(inputfile);

        }
        catch(FileNotFoundException e)
        {
            System.out.println("File cant be found");
        }



        String line = myScanner.nextLine(); //read 1st line and using the number of numbers to be sorted

        while (myScanner.hasNext())
        {
            numArray.add(myScanner.nextInt());
        }



        heapsize = numArray.size();

        sort(numArray);
        
        
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ; i<numArray.size();i++) {
        	set.add(numArray.get(i));
        }
        
        Iterator<Integer> itr = set.iterator();
        int flag=0;
        while(itr.hasNext()) {
           flag = itr.next();
           Collections.frequency(numArray, flag);
           flag++;
        }
        System.out.println("The number to be heapSorting : "+(numArray.size()+1)/2+ " number" +  "|" + " After Heapsorted: " + (flag+1)/2);
   


    }

      public static void swap(Vector<Integer> numArray, int i, int j)
      {
        

          int tmp = numArray.get(i);
          numArray.set(i, numArray.get(j));
          numArray.set(j, tmp);

      }   

      public static void maxheap(Vector<Integer> numArray, int i) //ensure max number is the parent
        { 
            int left = 2*i ;
            int right = 2*i + 1;
            int max = i;
            if (left <= heapsize && numArray.get(left) > numArray.get(i)) {
                max = left;
            }
            if (right <= heapsize && numArray.get(right) > numArray.get(max)) {        
                max = right;
            }

            if (max != i)
            {
                swap(numArray, i, max);
                maxheap(numArray, max);
            }
        } 

        public static void heapify(Vector<Integer> numArray)  //built a heap
        {
            heapsize = numArray.size()-1;
            for (int i = heapsize/2; i >= 0; i--)
                maxheap(numArray, i);        
        }


        public static void sort(Vector<Integer> numArray)
        {       
            heapify(numArray);        
            for (int i = heapsize; i > 0; i--)
            {
                swap(numArray,0, i);
                heapsize = heapsize-1;
                maxheap(numArray, 0);
            }
           
        }
       
}
