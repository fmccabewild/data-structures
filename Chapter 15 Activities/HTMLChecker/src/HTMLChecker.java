import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\fmccabewild\\Desktop\\Software Engineering\\data-structures\\Chapter 15 Activities\\HTMLChecker\\src\\TagSample3.html";
        String value;
        Stack<String> startTags = new Stack<>();
        boolean works = true;
        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            while(in.hasNext())
            {
                value = in.next();
                if(!value.substring(1,2).equals("/"))
                {
                    startTags.push(value);
                }
                else
                {
                    if(!startTags.pop().substring(1,2).equals(value.substring(2,3)))
                    {
                        works = false;
                    }
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
        System.out.println(works);

    }
}
