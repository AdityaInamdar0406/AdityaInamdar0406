// //Write a Java Program to implement I/O Decorator for converting uppercase letters to 
// lower case letters.


import java.io.*;
import java.util.*;

class LowerCaseInputStream extends FilterInputStream
{
    LowerCaseInputStream(InputStream in)
    {
        super(in);
    }

    public int read() throws IOException
    {
        int c = super.read();
        return Character.toLowerCase(c);
    }
}

public class Slip1
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.next();    

        InputStream in = new LowerCaseInputStream(new ByteArrayInputStream(input.getBytes()));

        int c;
        while((c = in.read()) != -1)
        {
            System.out.println((char)c);
        }
    }
}

// Output :
// Enter String : 
// JAVA
// j
// a
// v
// a