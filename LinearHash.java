import java.util.Arrays;

public class LinearHash extends HashTable {
	
	private static int collisionNum=0;
	public LinearHash()
	{
		bucket = new MElement[128];
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
		long startTime = System.currentTimeMillis();
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
		long endTime = System.currentTimeMillis();
		System.out.println("Number of elements in the table: "+size);
		System.out.println("Number of keys that resulted in a collision: "+collisionNum);
		System.out.println("Number od probing attemos before adding: "+probingNum);
		System.out.println("Time to run the put method: "+(endTime-startTime));
		size++;
	}

	@Override
	public MElement get(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MElement remove(int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
