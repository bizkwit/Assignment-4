import java.util.Random;
public class driver {

	public static void main(String[] args) {
		Random random = new Random();
		
		// TODO Auto-generated method stub
		/////////////////
		//	  STEP 4   //
		/////////////////
		/*make one of each hashTable, each with capacity 100
		 *generate 50 random <key,value> pairs, and run put(k,v) on each pair. (store keys in an array)
		 *run get(k)on each of the 50 keys (from array)
		 *run remove(k) on the first 25 keys (from array)
		 *run get(k) on each of the 50 keys (from array)
		 *ensure table works
		 */
		ChainingHash chainHash=new ChainingHash();
		LinearHash linearHash=new LinearHash(100);
		QuadraticHash quadHash=new QuadraticHash();
		
		//Key creation
		int i=0;
		int[] keyHolder = new int[50];
		while (i<50) {
			keyHolder[i]=random.nextInt(1000);
			//System.out.println("New Key: "+keyHolder[i]+"\n");
			i++;
		}
		
		//MElement creation
		i=0;
		int[] valueHolder= new int[50];
		while (i<50) {
			valueHolder[i]=random.nextInt(1000);
			//System.out.println("New Value: "+valueHolder[i]);
			i++;
		}
		
		//Running put(k,v) 50 times per table
		
		i=0;
		while(i<50) {
			System.out.println("Chaining Iteration #: "+(i+1));
			chainHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");
			
			System.out.println("Linear Iteration #: "+(i+1));
			linearHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");

			
			System.out.println("Quadratic Iteration #: "+(i+1));
			quadHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");

			i++;
		}
		
		/////////////////
		//	  STEP 5   //
		/////////////////
		/*make one of each hashTable, each with capacity 100
		 *generate 150 <key,value> pairs
		 *document the time to run put for:
		 *									-50 values
		 *									-75 values
		 *									-95 values
		 *									-100 values
		 *									-150 values
		 *
		 */
		
		
		
				
		/////////////////
		//	  STEP 6   //
		/////////////////
	}

}
