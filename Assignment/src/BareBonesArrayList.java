//We list all the methods that we need in AL here
public interface BareBonesArrayList <E>
{
    public void add(E a); //This methods adds to the end of the list
    public void add(E a,int index); // Adds at specified index
    public E remove(int index); // Returns t
    public E get(int index); // Returns the element without deleting
    public void set (E a, int index); // Update the element
    public int getSize(); // Tells how many element size
    public int indexOf(E a); //Search for element, return -1 if not found
}