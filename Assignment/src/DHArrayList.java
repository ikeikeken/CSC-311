public class DHArrayList<E> implements BareBonesArrayList
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
        E[] temp = new Object[this.capacity]; // New array with double capacity
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
        //TODO Auto-generated method stub

    }

    @Override
    public E remove(int index)
    {
        //TODO Auto-generated method stub
        return null;
    }

    @Override
    public E get(int index)
    {
        //TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set (E a, int index)
    {
        //TODO Auto-generated method stub
    }

    @Override
    public int getSize()
    {
        //TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int indexOf(E a)
    {
        //TODO Auto-generated method stub
        return 0;
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
