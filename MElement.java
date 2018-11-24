import java.util.Random;

public class MElement {
	private int key;
	private Object value;
	private Random random = new Random();	//random generator
	
	/**
	 * <h1> default constructor</h1>
	 * this constructor assigns a random integer as a key
	 */
	public MElement()
	{
		key = random.nextInt();
		value = null;
	}
	
	/**
	 * <h1> custom constructor </h1>
	 * @param k designated key
	 * @param v designated value
	 */
	public MElement(int k, Object v)
	{
		key = k;
		value = v;
	}
	
	/**
	 * <h1>  gets the key </h1>
	 * @return key
	 */
	public int getKey()
	{
		return key;
	}
	
	/**
	 * <h1> gets the value </h1>
	 * @return value
	 */
	public Object getValue()
	{
		return value;
	}
	
	/**
	 * <h1> sets the key </h1>
	 * @param k new key
	 */
	public void setKey(int k)
	{
		key = k;
	}
	
	/**
	 * <h1> sets the value </h1>
	 * @param v new value
	 */
	public void setValue(Object v)
	{
		value = v;
	}
	
	/**
	 * <h1> prints the element with the key and the value </h1>
	 */
	public String toString()
	{
		return "Key: "+key+", Value: "+value;
	}
	
	/**
	 * <h1> checks whether two elements are the same </h1>
	 * @param n another element to compare
	 * @return true if the same, false otherwise
	 */
	public boolean equals(MElement n)
	{
		if(n==null)
			return false;
		else if(n.getClass()!=this.getClass())
			return false;
		else if (key==n.getKey())
			return true;
		else
			return false;
	}
	
	/**
	 * <h1> hash function </h1>
	 * this function uses horner's rule to get a special key for assignment in the hash table
	 */
	public int hashCode()
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
	
	public boolean isLinkedList() {
		return false;
	}
}
