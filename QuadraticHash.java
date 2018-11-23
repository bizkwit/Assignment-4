
public class QuadraticHash extends HashTable {
	
	private static int collisionNum=0;
	
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
			collisionNum++;
		
		long startTime = System.currentTimeMillis();
		while(x)
		{
			if(bucket[hashKey]!=null && bucket[hashKey].getKey()==k)
			{
				bucket[hashKey].setValue(v);
				x=false;
			}
			else if(bucket[hashKey]!=null && bucket[hashKey].getKey()!= k && hashKey != last)
			{
				hashKey= (hashKey+(int)Math.pow(j,2))%bucket.length;
				j++;
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
		}//end while
		long endTime = System.currentTimeMillis();
		System.out.println("Number of elements in the table: "+size);
		System.out.println("Number of keys that resulted in a collision: "+collisionNum);
		System.out.println("Number od probing attemos before adding: "+probingNum);
		System.out.println("Time to run the put method: "+(endTime-startTime));
		size++;
	}

	@Override
	public MElement get(int k) {
		MElement toReturn = new MElement(k, null);
		//getting compressed index for bucket
		int hashKey = toReturn.hashCode()%bucket.length;
		int last = hashKey;
		int j=0;
		boolean x=true;//condition for loop
		
		long startTime = System.currentTimeMillis();
		while(x)
		{
			if(bucket[hashKey].equals(toReturn))
			{
				toReturn = bucket[hashKey];
				x = false;
			}
			else 
			{
				hashKey = (hashKey+(int)Math.pow(j, 2))%bucket.length;
				j++;
			}
			//after full table traversal
			if(hashKey==last)
				toReturn = null;
		}//end while
		long endTime = System.currentTimeMillis();
		System.out.println("Time to run the get method: "+(endTime-startTime));
		return toReturn;
	}

	@Override
	public MElement remove(int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
