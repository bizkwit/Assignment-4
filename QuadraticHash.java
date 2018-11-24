
public class QuadraticHash extends HashTable {
	
	private static int QuadraticCollisionNum=0;
	
	public QuadraticHash()
	{
		bucket = new MElement[100];
		size =0;
	}
	
	public QuadraticHash(int n)
	{
		bucket = new MElement[n];
		size = 0;
	}

	@Override
	public void put(int k, Object v) {
		MElement toPut = new MElement(k, v);
		//getting compressed index for bucket
		int hashKey = toPut.hashCode()%bucket.length;
		int last = hashKey;
		boolean x=true;//condition for loop
		int probingNum=0;
		int j=0;
		if(bucket[hashKey]!=null && bucket[hashKey].getKey()!= k)
			QuadraticCollisionNum++;
		
		long startTime = System.nanoTime();
		while(x)
		{
			if(bucket[hashKey]!=null && bucket[hashKey].getKey()==k)
			{
				bucket[hashKey].setValue(v);
				x=false;
			}
			else if(bucket[hashKey]!=null && bucket[hashKey].getKey()!= k)
			{
				hashKey= (hashKey+(int)Math.pow(++j,2))%bucket.length;
				if( hashKey == last)
					break;
				probingNum++;
				x=true;
			}
			else
			{
				bucket[hashKey] = toPut;
				x=false;
			}
		}//end while
		long endTime = System.nanoTime();
		size++;
		System.out.println("Number of elements in the table: "+size);
		System.out.println("Number of keys that resulted in a collision: "+QuadraticCollisionNum);
		System.out.println("Number od probing attemos before adding: "+probingNum);
		System.out.println("Time to run the put method: "+(endTime-startTime));
		
	}

	@Override
	public MElement get(int k) {
		MElement toReturn = new MElement(k, null);
		//getting compressed index for bucket
		int hashKey = toReturn.hashCode()%bucket.length;
		int last = hashKey;
		int j=0;
		boolean x=true;//condition for loop
		
		long startTime = System.nanoTime();
		while(x)
		{
			if(bucket[hashKey].equals(toReturn) && bucket[hashKey] != null)
			{
				toReturn = bucket[hashKey];
				x = false;
			}
			else 
			{
				hashKey = (hashKey+(int)Math.pow(++j, 2))%bucket.length;
				//after full table traversal
				if(hashKey==last)
					toReturn = null;
			}
			
		}//end while
		long endTime = System.nanoTime();
		System.out.println("Time to run the get method: "+(endTime-startTime));
		return toReturn;
	}

	@Override
	public MElement remove(int k) {
		MElement toReturn = new MElement(k, null);
		//getting compressed index for bucket
		int hashKey = toReturn.hashCode()%bucket.length;
		int last = hashKey;
		boolean x=true;//condition for loop
		int j=0;

		long startTime = System.nanoTime();
		while(x)
		{
			if(bucket[hashKey].equals(toReturn) && bucket[hashKey] != null)
			{
				toReturn = bucket[hashKey];
				bucket[hashKey]=null;
				x = false;
			}
			else 
			{
				hashKey = (hashKey+(int)Math.pow(++j,2))%bucket.length;
				//after full table traversal
				if(hashKey==last)
					toReturn = null;
			}
			
		}//end while
		long endTime = System.nanoTime();
		System.out.println("Time to run the remove method: "+(endTime-startTime));
		size--;
		return toReturn;
	}

}
