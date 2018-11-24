import java.util.Random;

import org.omg.CORBA.SystemException;
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
		
		//Value creation
		i=0;
		int[] valueHolder= new int[50];
		while (i<50) {
			valueHolder[i]=random.nextInt(1000);
			//System.out.println("New Value: "+valueHolder[i]);
			i++;
		}
		
		//Running put(k,v) 50 times per table
		i=0;
		System.out.println("////////////////////////////	put() Validation	////////////////////////////");
		while(i<50) {
			System.out.println("Chaining Put() Iteration #: "+(i+1));
			chainHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");
			
			System.out.println("Linear Put() Iteration #: "+(i+1));
			linearHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");

			
			System.out.println("Quadratic Put() Iteration #: "+(i+1));
			quadHash.put(keyHolder[i], valueHolder[i]);
			System.out.println("\n");

			i++;
		}
		
		/*
		//Running get(k,v) 50 times per table
		i=0;
		System.out.println("////////////////////////////	get() Validation	////////////////////////////");
		while(i<50) {
			System.out.println("Chaining get() Iteration #: "+(i+1));
			System.out.println("Chain value: "+chainHash.get(keyHolder[i]).toString());
			System.out.println("\n");
			
			System.out.println("Linear get() Iteration #: "+(i+1));
			System.out.println("Linear value: "+linearHash.get(keyHolder[i]).toString());
			System.out.println("\n");

			
			System.out.println("Quadratic get() Iteration #: "+(i+1));
			System.out.println("Quad value: "+quadHash.get(keyHolder[i]).toString());
			System.out.println("\n");

			i++;
		}
		
		*/
		
		/*
		//Running remove(k) 25 times per table
		i=0;
		System.out.println("////////////////////////////	remove() Validation		////////////////////////////");
		while(i<25) {
			System.out.println("Chaining remove() Iteration #: "+(i+1));
			System.out.println("Chain value: "+chainHash.remove(keyHolder[i]));
			System.out.println("\n");
			
			System.out.println("Linear remove() Iteration #: "+(i+1));
			System.out.println("Linear value: "+linearHash.remove(keyHolder[i]));
			System.out.println("\n");

			
			System.out.println("Quadratic remove() Iteration #: "+(i+1));
			System.out.println("Quad value: "+quadHash.remove(keyHolder[i]));
			System.out.println("\n");

			i++;
		}
		*/
		
		/*
		//Running get(k,v) 50 times per table
		i=0;
		System.out.println("////////////////////////////	get() Validation	////////////////////////////");
		while(i<50) {
			System.out.println("Chaining get() Iteration #: "+(i+1));
			System.out.println("Chain value: "+chainHash.get(keyHolder[i]).toString());
			System.out.println("\n");
			
			System.out.println("Linear get() Iteration #: "+(i+1));
			System.out.println("Linear value: "+linearHash.get(keyHolder[i]).toString());
			System.out.println("\n");

			
			System.out.println("Quadratic get() Iteration #: "+(i+1));
			System.out.println("Quad value: "+quadHash.get(keyHolder[i]).toString());
			System.out.println("\n");

			i++;
		}
		
		*/
		
		
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
		long start=0;
		long end=0;
		
		chainHash=new ChainingHash();
		linearHash=new LinearHash(100);
		quadHash=new QuadraticHash();
		
		//Key creation
		i=0;
		keyHolder = new int[150];
		while (i<150) {
			keyHolder[i]=random.nextInt(1000);
			//System.out.println("New Key: "+keyHolder[i]+"\n");
			i++;
		}
		
		//Value creation
		valueHolder= new int[150];
		while (i<150) {
			valueHolder[i]=random.nextInt(1000);
			//System.out.println("New Value: "+valueHolder[i]);
			i++;
		}
		
		int x=50;//ITERATIONS: 50, 75, 95, 100, 150
		
		System.out.println("\n////////////////////////////	put() Validation	(FOR "+x+" VALUES)	 ////////////////////////////");
		i=0;
		start=System.nanoTime();
		while(i<x) {
			chainHash.put(keyHolder[i], valueHolder[i]);
			i++;
		}
		end=System.nanoTime();
		System.out.println("\n///////		Time to run put "+x+" times for Chaining Hash: "+(end-start)+"		///////\n");
		
		i=0;
		start=System.nanoTime();
		while(i<x) {
			linearHash.put(keyHolder[i], valueHolder[i]);

			i++;
		}
		end=System.nanoTime();
		System.out.println("\n///////		Time to run put "+x+" times for Linear Hash: "+(end-start)+"		///////\n");
		
		
		i=0;
		start=System.nanoTime();
		while(i<x) {
			quadHash.put(keyHolder[i], valueHolder[i]);

			i++;
		}
		end=System.nanoTime();
		System.out.println("\n///////		Time to run put "+x+" times for Quad Hash: "+(end-start)+"		///////\n");
		
		System.out.println("////////////////////////////	put() Validation	(FOR "+x+" VALUES) (Quad 101)	////////////////////////////");
		quadHash=new QuadraticHash(101);
		i=0;
		start=System.nanoTime();
		while(i<x) {
			quadHash.put(keyHolder[i], valueHolder[i]);

			i++;
		}
		end=System.nanoTime();
		System.out.println("\n///////		Time to run put "+x+" times for Quad Hash: "+(end-start)+"		///////\n");
		
		/////////////////
		//	  STEP 6   //
		/////////////////
	}

}
