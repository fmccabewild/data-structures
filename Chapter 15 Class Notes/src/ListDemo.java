import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*The addLast method can be used to populate a list. */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        System.out.println(staff);

        ListIterator<String> iterator = staff.listIterator();
        iterator.next();
        String avenger = iterator.next();
        System.out.println(avenger);
        iterator.add("Steve");
        iterator.add("Clint");
        iterator.next();
        iterator.remove();
        iterator.previous();
        iterator.set("T'Challa");

        iterator = staff.listIterator();
        while (iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")){
                iterator.remove();
            }
        }
        
        for (String n : staff){
            System.out.print(n + " ");
        }
        System.out.println();

        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")){
                //staff.remove("Tony");
            }
        }

        for (String n : staff)
        {
            if (n.equals("Tony"))
            {
                //staff.add("Bruce");
            }
        }
    }
}
