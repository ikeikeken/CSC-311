public class DHArrayList<E> implements BareBonesArrayList<E>
{
    //Data
    private int size; //How many elements are there
    private int capacity; //How big is the array
    private E[] myArray; //Reference to the actual array, yet to be created
    private static final int INITIAL_CAPACITY = 10; //Default capacity

    //Constructors (has no return type)
    public DHArrayList()
    {
        this.capacity = this.INITIAL_CAPACITY;
        this.size = 0; //There are no elements when the ArrayList is being created
        myArray = (E[]) new Object[this.capacity]; // This creates the actual array for the AL

    }

    //Overloaded constructor, with user supplied capacity
    public DHArrayList(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        myArray = (E[]) new Object[this.capacity];
    }

    @Override
    public void add(E a)
    {
        //adds element to the end of AL
        //First we need to check if there is space to add
        if (this.capacity > this.size)
        {
            //This means there is space
            //The last index where the data is to be inserted is given by its size
            myArray[size] = a; //Insert without issue
            size++; //update size after successful update
        }
        else
        {
            //No Space! We need to call reallocate
            System.out.println("There isn't space, calling reallocate");
            this.reallocate();
            this.add(a); //once reallocate provides the space, call add again
        }
    }

    private void reallocate()
    {
        //Double the size of the array
        this.capacity *=2;
        E[] temp = (E[]) new Object[this.capacity]; // New array with double capacity
        //copy over elements
        for (int i = 0 ; i < myArray.length; i++)
        {
            temp [i] = myArray[i];
        }
        //once copying is done, update the reference
        this.myArray = temp;
    }

    @Override
    public void add(E a, int index)
    {
        // This methods adds at a given index
        // First thing we need to do is check the validity of index
        if(index < 0 || index > size)
        {
            System.out.println("Invalid index!");
            return;
        }
        else if (index == size)
        {
            // We are trying to add at end of the AL
            this.add(a); // we already have this methhod
        }
        else
        {
            //We have a valid index, and need shifting index
            // Check if there is space to shift, if not reallocate
            if(this.size == this.capacity)
            {
                // the AL is full
                this.reallocate();
            }
            //Once reallocate is done, we have space to shift the elements
            // we need to shift all elements from index to end one position to the right
            // Copy over the elements from the last one of the index
            for (int i = size; i > index; i--)
            {
                this.myArray[i] = this.myArray[i-1];
            }
            // once the elements are shifted, insert the data
            this.myArray[index] = a;
            this.size++; //update how many elements in the array
        }
    }

    @Override
    public E remove(int index)
    {
        //this will delete the element at index
        //first check the validity of the index
        if (index < 0  || index >= size)
        {
            System.out.println("Invalid index!");
            return null;
        }
        // now shifting might be required
        // save the element to be deleted so that it can be return
        E temp = myArray[index];
        //shifting left
        for (int i = index; i < size -1; i++)
        {
            this.myArray[i] = this.myArray[i+1];
        }
        this.size--; // Decrease the number of elements in the array
        return temp; // return the deleted element
    }

    @Override
    public E get(int index)
    {
        //this returns the element at index but no delete
        //first check the validity of the index
        if (index < 0  || index >= size)
        {
            System.out.println("Invalid index!");
            return null;
        }
        return myArray[index]; //if index is valid return the element at index
    }

    @Override
    public void set (E a, int index)
    {
        //update the element at the index
        //first check the validity of the index
        if (index < 0  || index >= size)
        {
            System.out.println("Invalid index!");
            return;
        }
        myArray[index] = a; //if the index is valid, update the index
        return;
    }

    @Override
    public int getSize()
    {
        //returns how many elements are in the AL
        return this.size;
    }

    @Override
    public int indexOf(E a)
    {
        //find the first location of an element that we are searching in the AL
        //first check the validity of the index
        if (size == 0)
        {
            System.out.println("Invalid index! Size or Capacity has to be greater than 0");
            return -1 ;
        }
        for (int i = 0; i < size; i++)
        {
            if (myArray[i] == a)//(myArray[i].equals(a)) did not define equals function yet
            {
                //System.out.println("was found at " + i);
                return i;
            }
            /*else if (i == size - 1 && myArray[i] != a)
            {
                return -1;
            }*/
        }
        return -1;
    }

    //We are going to implement to string method
    //Converts the data in the data structure into a string and returns it

    public String toString()
    {   // This method returns the contents of the array in a string
        String s ="";
        // We will iterate over the elements and add to the String
        for (int i = 0; i < this.size; i++)
        {
            s = s + myArray[i] + ", "; //", " for formatting
        }
        return s;
    }
}
