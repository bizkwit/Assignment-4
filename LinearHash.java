import java.util.*;

public class LinearHash extends HashTable {
	
	private static int collisionNum=0;
	
	/**
	 * <h1> default constructor </h1>
	 */
	public LinearHash()
	{
		bucket = new MElement[128];
		size=0;
	}
	
	/**
	 * <h1> custom constructor </h1>
	 * @param n given number for size
	 */
	public LinearHash(int n)
	{
		bucket = new MElement[n];
		size=0;
	}
	
	/**
	 * <h1> resize the array </h1>
	 * doubles the size if reaching the boundary
	 */
	private void resizeUp() 
	 {
		   int newSize = bucket.length * 2;
		   bucket = Arrays.copyOf(bucket, newSize);
	 }
	
	/**
	 * <h1> put new element </h1>
	 * if exist a n element with same key, just update value. insert otherwise. and print the execution time
	 * @param k a given key
	 * @param v a given value
	 */
	@Override
	public void put(int k, Object v) 
	{
		//check if needs resizing
		if(size==bucket.length/2)
			resizeUp();
		System.out.println("Table size: "+bucket.length);
		
		boolean x=true;//condition for the loop
		MElement toPut = new MElement(k,v);
		int probingNum=0;
		//getting compressed index for bucket
		int hashKey = toPut.hashCode() % bucket.length;
		int last = hashKey;
		if(bucket[hashKey]!=null && bucket[hashKey].getKey()!= k)
			collisionNum++;
		long startTime = System.nanoTime();
		while (x)
		{
			if(bucket[hashKey]!=null && bucket[hashKey].getKey()==k)
			{
				bucket[hashKey].setValue(v);
				x=false;
			}
			else if(bucket[hashKey]!=null && bucket[hashKey].getKey()!= k && hashKey != last)
			{
				hashKey= (hashKey+1)%bucket.length;
				probingNum++;
				x=true;
			}
			else if( hashKey == last)
				break;
			else
			{
				bucket[hashKey] = toPut;
				x=false;
			}
		}//end of while
		long endTime = System.nanoTime();
		System.out.println("Number of elements in the table: "+size);
		System.out.println("Number of keys that resulted in a collision: "+collisionNum);
		System.out.println("Number od probing attemos before adding: "+probingNum);
		System.out.println("Time to run the put method: (ns)"+(endTime-startTime));
		size++;
	}
	
	/**
	 * <h1> gets element </h1>
	 * returns the element of a given key. null otherwise and print the execution time
	 * @param k given key
	 */
	@Override
	public MElement get(int k)
	{
		MElement toReturn = new MElement(k, null);
		//getting compressed index for bucket
		int hashKey = toReturn.hashCode()%bucket.length;
		int last = hashKey;
		boolean x=true;//condition for loop
		
		long startTime = System.nanoTime();
		while(x)
		{
			if(bucket[hashKey].equals(toReturn))
			{
				toReturn = bucket[hashKey];
				x = false;
			}
			else 
				hashKey = (hashKey+1)%bucket.length;
			//after full table traversal
			if(hashKey==last)
				toReturn = null;
		}//end while
		long endTime = System.nanoTime();
		System.out.println("Time to run the get method: (ns)"+(endTime-startTime));
		return toReturn;
	}
	
	/**
	 * <h1> removes an element </h1>
	 * removes an element given a key and prints the execution time
	 * @param k given key
	 */
	@Override
	public MElement remove(int k)
	{
		MElement toReturn = new MElement(k, null);
		//getting compressed index for bucket
		int hashKey = toReturn.hashCode()%bucket.length;
		int last = hashKey;
		boolean x=true;//condition for loop
		
		long startTime = System.nanoTime();
		while(x)
		{
			if(bucket[hashKey].equals(toReturn))
			{
				toReturn = bucket[hashKey];
				bucket[hashKey]=null;
				x = false;
			}
			else 
				hashKey = (hashKey+1)%bucket.length;
			//after full table traversal
			if(hashKey==last)
				toReturn = null;
		}//end while
		long endTime = System.nanoTime();
		System.out.println("Time to run the remove method: (ns)"+(endTime-startTime));
		size--;
		return toReturn;
	}

}
