package csc311.fall2026;

// This is the interface for the stack
public interface BareBonesStack <E>
{
    void push (E obj); // This is to add elements to the stack
    E pop(); // This is to remove the top element from the stack
    E peek(); // This returns the top element without removing it
    boolean isEmpty(); // Returns true if the stack is empty

}