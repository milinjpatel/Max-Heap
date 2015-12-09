public class Heap
{
   private int[] heapArray;
   private int maxSize;           //Size of the array
   private int currentSize;       //Number of elements in the array
   private int swap;              //Number of swaps during insertion
   public Heap(int max)           //The constructor which takes in the max size as an input
   {
      maxSize = max;
      currentSize = 0;
      heapArray = new int[maxSize];  //Create the array with a max size
   }
   public boolean isEmpty() //Checks if there are no nodes in the array
   { 
      return currentSize == 0;
   }
   public boolean seqInsert(int key)   //Method to insert into the array if it is not full
   {
      if(currentSize == maxSize) //Returns false if the heap is full
      {
         return false;
      }
      int newNode = key;
      heapArray[currentSize] = newNode;  //Makes room for the new data
      heapifyUp(currentSize++);          //Increment size of the array
      return true;
   } 
   public void optInsert(int[] elements)
   {
       for(int i = 0; i < elements.length; i++)
       {
           heapArray[i] = elements[i];
           currentSize++;
       }
       for(int i = currentSize - 1; i > 0; i--)
       {
           heapifyUp(i);
       }
   }
   public void heapifyUp(int index) //Method used for reheapification upwards
   {
      int parent = (index-1) / 2;
      int bottom = heapArray[index];

      while(index > 0 && heapArray[parent] < bottom)
      {
         heapArray[index] = heapArray[parent];  // Moves the node down
         index = parent;
         parent = (parent-1) / 2;
         swap++;
      } 
      heapArray[index] = bottom;
   }  
   public int remove() //Delete an item in the max heap
   {                           //Assuming that the list is not empty
      int root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      heapifyDown(0);
      swap++;
      return root;
   } 
   public void heapifyDown(int index) //The method used for reheapification downwards
   {
      int largerChild;
      int top = heapArray[index];        //Save the root
      while(index < currentSize/2)       // While the node has at least on child
      {                                  
         int leftChild = 2*index+1;
         int rightChild = leftChild+1;   //Find the larger child
         if(rightChild < currentSize && heapArray[leftChild] <heapArray[rightChild])
         {
            largerChild = rightChild;
         }
         else
         {
            largerChild = leftChild;
         }
         if(top >= heapArray[largerChild])
         {
            break;
         }
         swap++;
         heapArray[index] = heapArray[largerChild];
         index = largerChild;            //Go down in the heap
      }
      heapArray[index] = top;            //Set the root to the index
   }
   public int getSwap() //Returns the swap value
   {
      return swap;
   }
   public void printHeap()
   {
      for(int j = 0; j < 11; j++)
      {
    		  System.out.print(heapArray[j] + " ");                                     
      }
      System.out.println();
   }
}
