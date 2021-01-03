public class MyArrList<T>
{
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] theItems;
    private int theSize;

    public boolean isContainID (String givenID){
        for(int i = 0 ; i < theItems.length ; i++){
            if( get(i).studentID == givenID){
                return false;
            }
        }
        return false;
    }

    
    public MyArrList()
    {
        clear();
    }
    
    public void clear()
    {
        theSize = 0;
        theItems = (T[]) new Object[DEFAULT_CAPACITY];
    } 

    public T get( int idx )
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );
        
        return theItems[ idx ];    
    }
        
    public T set( int idx, T newVal )
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );
        
        T old = theItems[ idx ];    
        theItems[ idx ] = newVal;
        
        return old;    
    }
    
    public void add(T x)
    {
        add(theSize, x);
    }
    
    public void add(int idx, T x)
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
      
    public T remove(int idx)
    {
        if( idx < 0 || idx >= theSize )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + theSize );
        
        T removedItem = theItems[ idx ];
        
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
        T[] old = theItems;
        
        theItems = (T[]) new Object[newCapacity];
        
        for( int i = 0; i < theSize; i++ )
            theItems[ i ] = old[ i ];
    } 
}