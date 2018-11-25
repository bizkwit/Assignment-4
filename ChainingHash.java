
public class ChainingHash extends HashTable {
	
	public ChainingHash() {
		bucket= new MElement[100];
		collisions=0;
		entries=0;
	}
	
	private int collisions;
	private int entries;
	
	public boolean isEmpty() {
		return collisions==0;
	}
	
	/*0)print table size
	 *1)create MElement
	 *2)get hashKey from k
	 *3)check index at hashKey
	 *4)if bucket[hashKey] !=null and bucket[hashKey].getKey == k => replace
	 *	if bucket[hashKey] !=null and bucket[hashKey].getKey != k 	=> 
	 *																=> create linkedList at bucket[hashKey]
	 *																=> add MElement
	 *																=> collision++
	 *	if bucket[hashKey] ==null => insert
	 *5)print number of elements in the table
	 *6)print collision
	 *7)print linkedList.size
	 *8)print time used to run
	 */
	@Override
	public void put(int k, Object v) {
		MElement node= new MElement(k,null);//1
		int hashKey=node.hashCode()%bucket.length;//2
		long start=System.nanoTime();
		if((bucket[hashKey] != null)&&bucket[hashKey].equals(node)) {//4 non-empty index, same key
			bucket[hashKey]=node;
		}
		else if((bucket[hashKey] != null)&&(!bucket[hashKey].equals(node))&&(!bucket[hashKey].isLinkedList())) {//4 different key, multiple values, no linked list!
			//create linked list in place and retrofit
			myLinkedList bucketList=new myLinkedList();
			bucketList.add(bucket[hashKey]);
			bucketList.add(node);
			bucket[hashKey]=bucketList;
			System.out.println("Bucket List: "+bucketList.size());
			collisions++;
		}
		else if((bucket[hashKey] != null)&&(!bucket[hashKey].equals(node))&&(bucket[hashKey].isLinkedList())) {//4 different key, multiple values, already linked list!
			((myLinkedList)bucket[hashKey]).add(node);
			System.out.println(("Bucket List: "+((myLinkedList)bucket[hashKey]).size()));
			collisions++;
		}
		else if(bucket[hashKey]==null) {//4 empty index
			bucket[hashKey]=node;
		}
		long end=System.nanoTime();
		node.setValue(v);
		entries++;
		System.out.println("Number of elements in the table: "+entries);//5 print entries
		System.out.println("Number of keys that resulted in a collision: "+collisions);//6 print collisions
		if(bucket[hashKey].isLinkedList()) {
			System.out.println("Bucket Size for Collision Handling event: "+((myLinkedList)bucket[hashKey]).size());
		}
		System.out.println("Time to run the put method: (ns)"+(end-start));//8
	}
	
	/*1)get hashKey from k
	 *2)check bucket[hashKey]
	 *3)if bucket[hashKey].isList != true => return bucker[hashKey]
	 *4)else (its a linkedList) => traverse linkedList until list[i].getKey == k
	 *5)return list [i]
	 *6)print time used to run
	 */
	@Override
	public MElement get(int k) {
		long start=System.nanoTime();
		MElement node = new MElement(k,null);
		int hashKey=node.hashCode()%bucket.length;//1,2
		if(bucket[hashKey]!=null) {//CHECK BUCKET TO SEE IF ITS NULL PRE-EMPTIVELY
			if(!bucket[hashKey].isLinkedList()) {//3 not a list
				node=bucket[hashKey];
			}
			if(bucket[hashKey].isLinkedList()) {//4
				node=((myLinkedList)bucket[hashKey]).find(node);
			}
		}
		long end=System.nanoTime();
		//print time
		System.out.println("Time to run the get method: "+(end-start)+"\n");//6
		return node;//5
	}

	/*1)get hashKey from k
	 *2)check bucket[hashKey]
	 *3)if bucket[hashKey].isList !=true return bucket[hashKey], set bucket[hashKey] to null
	 *4)if bucket[hashKey].isList == true => traverse linkedList until list[i].getKey == k
	 *5)return list[i]
	 *6)remove list[i]
	 *7)set lost[i] to null
	 *7)print time used to run		 
	 */
	@Override
	public MElement remove(int k) {
		long start=System.nanoTime();
		MElement node = new MElement(k,null);
		int hashKey=node.hashCode()%bucket.length;//1,2
		if(bucket[hashKey]!=null) {//CHECK BUCKET TO SEE IF ITS NULL PRE-EMPTIVELY
			if(bucket[hashKey].isLinkedList()) {//4
				node=((myLinkedList)bucket[hashKey]).remove(node);
			}
			else {//3
				node.setValue(bucket[hashKey].getValue());
				bucket[hashKey]=null;
			}
			entries--;
		}
		long end=System.nanoTime();//7
		//print time
		System.out.println("Time to run the remove method: "+(end-start)+"\n");
		return node;//5
	}
	
}
