
public abstract class  HashTable {
	
	protected int size;
	protected MElement[] bucket;
	
	/**
	 * <h1> checks for the size of the hash table </h1>
	 * @return the number of elements in the table
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * <h1> checks if hash table is empty </h1>
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return size==0;
	}
	
	//for implementaion by children
	abstract public void put(int k, Object v);
	abstract public MElement get(int k);
	abstract public MElement remove(int k);
	
	
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
