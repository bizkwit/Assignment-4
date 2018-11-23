
public abstract class  HashTable {
	
	protected int size;
	protected MElement[] bucket;
	
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	//for implementaion by children
	abstract public void put(int k, Object v);
	abstract public MElement get(int k);
	abstract public MElement remove(int k);
	
	
	/*{
		Object toReturn = null;
		int hashKey = hashCode(k) % bucket.length;
		
		toReturn = bucket[hashKey];
		
		return toReturn;
		
	}*/
	
	
	
	
	public int hashCode(int key)
	{
		int toReturn;
		//split integer into array of digits for polynomial accumulation
		if(key<0)
			key=(key-key)-key;
		String temp = Integer.toString(key);
		int[] keyArray = new int[temp.length()];
		for (int i=0; i<temp.length(); i++)
		    keyArray[i] = temp.charAt(i) - '0';
		
		//using horner's rule for hash function for smallest number of collisions
		toReturn = keyArray[0];
		for(int i=1; i<=keyArray.length-1; i++)
			toReturn+=keyArray[i]*(long)Math.pow(33,i);
		return toReturn;
	}

}
