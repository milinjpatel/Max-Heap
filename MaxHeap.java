import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class MaxHeap
{
   public static void main(String[] args) throws IOException
   {
      Heap seqTree = new Heap(100);  // Make a sequentially inserted heap for 100 items
      Heap optTree = new Heap(100); // Make an optimally inserted heap for 100 items
      int seqCounter = 0;
      int optCounter = 0;
      Scanner kb = new Scanner(System.in);

      System.out.print("Pick \"1\" for Random Values and \"2\" for Fixed Values: ");  
      int choice = kb.nextInt();
      int[] temp = new int[100];
      
      if(choice == 2)                   //Fixed numbers 1 to 100
      {
         for(int i = 0; i < 100; i++)   //Inserting numbers 1 to 100
         { 
            seqTree.seqInsert(i+1); 
            temp[i] = i+1;
         }
         optTree.optInsert(temp);
         System.out.println("Optimal Method Elements: ");
         optTree.printHeap();
         System.out.println("Sequential Method Elements: ");
         seqTree.printHeap();
         System.out.println("Optimal Swaps = " + optTree.getSwap());
         System.out.println("Sequential Swaps = " + seqTree.getSwap());
         
         for (int i = 0; i < 11; i++)
         {
        	 optTree.remove();
        	 seqTree.remove();
         } 
         
         System.out.println("Optimal Method Elements: ");
         optTree.printHeap();
         System.out.println("Sequential Method Elements: ");
         seqTree.printHeap();
      } 
      else if(choice == 1)
      {
    	  int[] opttemp = new int[100];
    	  
    	  for(int j = 0; j < 20; j++)             //create 20 tree objects
    	  {
    		  Random roll = new Random();       
    		  for(int i = 0; i < 100; i++)        //creating 100 nodes
    		  {
    			  int a = roll.nextInt();
    			  seqTree.seqInsert(a);
    			  opttemp[i] = a;
    		  }
    		  optTree.optInsert(opttemp);
    		  seqCounter += seqTree.getSwap();          //tracking number of swaps for sequential insert
    		  optCounter += optTree.getSwap();			//tracking number of swaps for optimal insert
    		  optTree = new Heap(100); //Empty out the heap for the next set
    		  seqTree = new Heap(100); //Empty out the heap for the next set
          }  
           
    	  double seqAvg = seqCounter/20.0;            //Average number of swaps for sequential
    	  System.out.println("The average number of swaps for sequential insert: " + seqAvg);
    	  double optAvg = optCounter/20.0;			  //Average number of swaps for optimal
    	  System.out.println("The average number of swaps for optimal insert: " + optAvg);

      }
      kb.close();
   }
}
