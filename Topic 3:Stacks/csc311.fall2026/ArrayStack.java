package csc311.fall2026;

public class ArrayStack <E> implements BareBonesStack<E>
{
    //Storage for the stack
    private E[] theData; // This is the reference holder only
    private int topofStack = -1; // Variable for ToS, -1 indicates stack is empty
    private static final int INITIAL_CAPACITY = 10; // Default size of the stack
    private int size = 0; // How many elements in the stack

    //Constructors
    public ArrayStack() // the actual array will be created here
    {
        this.theData = (E[]) new Object[this.INITIAL_CAPACITY];
    }

    public ArrayStack(int capacity)
    {
        this.theData = (E[]) new Object[capacity];
    }

    @Override
    public void push (E obj) // This is to add elements to the stack
    {
        //if no space "OVERFLOW"
        if (this.topofStack == this.theData.length -1 )
        {
            //if you want, create a reallocate method call here
            //for this implementation, we will say "Overflow"
            System.out.println("Stack Overflow!");
            return;
        }
        //otherwise, there is space to add the data
        this.topofStack++;
        this.theData[topofStack] = obj;
        return;
    }

    @Override
    public E pop() // This is to remove the top element from the stack
    {
        return null;
    }

    @Override
    public E peek() // This returns the top element without removing it
    {

    }

    @Override
    public boolean isEmpty() // Returns true if the stack is empty
    {

    }
}
