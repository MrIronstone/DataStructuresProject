import java.util.*;

public class MySeparateChainingHashTable<T>
{
    private static final int DEFAULT_TABLE_SIZE = 10;

    private LinkedList<T>[] theLists;

    public MySeparateChainingHashTable()
    {
        theLists = new LinkedList[DEFAULT_TABLE_SIZE];

        for(int i=0; i<theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    public void insert(T x)
    {
        LinkedList<T> whichList = theLists[myHash(x)];

        if(!whichList.contains(x))
            whichList.add(x);
    }

    public void remove(T x)
    {
        LinkedList<T> whichList = theLists[myHash(x)];

        if(whichList.contains(x))
            whichList.remove(x);
    }

    public boolean contains(T x)
    {
        LinkedList<T> whichList = theLists[myHash(x)];

        return whichList.contains(x);
    }

    public void makeEmpty()
    {
        for(int i=0; i<theLists.length; i++)
            theLists[i].clear();
    }

    public void printHashTable()
    {
        LinkedList<T> whichList;

        for(int i=0; i<theLists.length; i++)
        {
            whichList = theLists[i];

            System.out.print("|" + i + "|" + " --> ");

            for(int j=0; j<whichList.size(); j++)
                System.out.print(whichList.get(j) + " --> ");

            System.out.println();
        }
    }

    private int myHash(T x)
    {
        return (x.hashCode() % theLists.length);
    }
}