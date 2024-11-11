//Write a Java Program to implement Adapter pattern for Enumeration iterator



import java.util.*;

class EnumerationAdapterIterator implements Iterator
{
    Enumeration enumeration;

    EnumerationAdapterIterator(Enumeration enumeration)
    {
        this.enumeration = enumeration;
    }

    public boolean hasNext()
    {
        return enumeration.hasMoreElements();
    }

    public Object next()
    {
        return enumeration.nextElement();
    }

    public static void main(String[] args) 
    {
        Vector<String> v = new Vector<>();
        v.add("A");
        v.add("B");
        v.add("C");
    
        Iterator i = new EnumerationAdapterIterator(v.elements());

        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}


// Output :

// A
// B
// C