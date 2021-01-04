public class MyArrList<AnyType>
{
    private static final int DEFAULT_CAPACITY = 10;

    private AnyType[] theItems;
    private int theSize;

    public MyArrList()
    {
        clear();
    }

    public AnyType get( int idx )
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );

        return theItems[ idx ];
    }

    public AnyType set( int idx, AnyType newVal )
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );

        AnyType old = theItems[ idx ];
        theItems[ idx ] = newVal;

        return old;
    }

    public boolean add(AnyType x)
    {
        add(theSize, x);
        return true;
    }

    public void add(int idx, AnyType x)
    {
        if( idx < 0 || idx > theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );

        if(theItems.length == theSize)
            ensureCapacity(theSize * 2);

        for(int i=theSize; i>idx; i--)
            theItems[i] = theItems[i - 1];

        theItems[idx] = x;

        theSize++;
    }

    public AnyType remove(int idx)
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );

        AnyType removedItem = theItems[ idx ];

        for(int i=idx; i<theSize-1; i++)
            theItems[i] = theItems[i + 1];

        theSize--;

        return removedItem;
    }

    public int size()
    {
        return theSize;
    }

    public boolean isEmpty()
    {
        return theSize == 0;
    }

    public void clear()
    {
        theSize = 0;
        theItems = (AnyType[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString()
    {
        String rStr = "[ ";

        for(int i=0; i<theSize; i++)
            rStr = rStr + theItems[i] + " ";

        rStr = rStr + "]";

        return rStr;
    }

    private void ensureCapacity(int newCapacity)
    {
        AnyType[] old = theItems;

        theItems = (AnyType[]) new Object[newCapacity];

        for( int i = 0; i < theSize; i++ )
            theItems[ i ] = old[ i ];
    }
}