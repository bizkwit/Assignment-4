import java.util.Random;
import java.io.*;

import org.omg.CORBA.SystemException;
public class driver {

	public static void main(String[] args) {
		Random random = new Random();
		BufferedWriter writer; //file writer
		
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
		
		
		//Running get(k,v) 50 times per table
		i=0;
		System.out.println("////////////////////////////	get() Validation	////////////////////////////");
		while(i<50) {
			System.out.println("Chaining get() Iteration #: "+(i+1));
			chainHash.get(keyHolder[i]).toString(); //CATCH NO SUCH ELEMENT
			System.out.println("\n");
			
			System.out.println("Linear get() Iteration #: "+(i+1));
			linearHash.get(keyHolder[i]).toString(); //CATCH NO SUCH ELEMENT
			System.out.println("\n");

			
			System.out.println("Quadratic get() Iteration #: "+(i+1));
			quadHash.get(keyHolder[i]).toString(); //CATCH NO SUCH ELEMENT
			System.out.println("\n");

			i++;
		}
		
		//Running remove(k) 25 times per table
		i=0;
		System.out.println("////////////////////////////	remove() Validation		////////////////////////////");
		while(i<25) {
			System.out.println("Chaining remove() Iteration #: "+(i+1));
			chainHash.remove(keyHolder[i]); //CATCH NO SUCH ELEMENT
			System.out.println("\n");
			
			System.out.println("Linear remove() Iteration #: "+(i+1));
			linearHash.remove(keyHolder[i]); //CTACH NO SUCH ELEMENT
			System.out.println("\n");

			
			System.out.println("Quadratic remove() Iteration #: "+(i+1));
			quadHash.remove(keyHolder[i]); //CATCH NO SUCH ELEMENT
			System.out.println("\n");

			i++;
		}

		//Running get(k,v) 50 times per table
		i=0;
		System.out.println("////////////////////////////	get() Validation	////////////////////////////");
		while(i<50) {
			System.out.println("Chaining get() Iteration #: "+(i+1));
			chainHash.get(keyHolder[i]); //CATCH NO SUCH ELEMENT
			System.out.println("\n");
			
			System.out.println("Linear get() Iteration #: "+(i+1));
			linearHash.get(keyHolder[i]); //CATCH NO SUCH ELEMENT
			System.out.println("\n");

			
			System.out.println("Quadratic get() Iteration #: "+(i+1));
			quadHash.get(keyHolder[i]);//CATCH NO SUCH ELEMENT
			System.out.println("\n");

			i++;
		}

		/////////////////
		//	  STEP 5   //////////////////ONLY NEED TO FINISH THE DOCUMENT AND THE ASSIGNMENT IS FINISHED!
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
			try {
				writer = new BufferedWriter(new FileWriter("Experiment_and_Interpret.txt"));
				while(x<=150){

					System.out.println("\n////////////////////////////	put() Validation	(FOR " + x + " VALUES)	Size 100\n");
					writer.write("\n////////////////////////////	put() Validation	(FOR " + x + " VALUES)	 Size 100\n");
					writer.newLine();
					i = 0;
					start = System.nanoTime();
					while (i < x) {
						chainHash.put(keyHolder[i], valueHolder[i]);
						System.out.println("\n");
						i++;
					}
					end = System.nanoTime();
					System.out.println("\n");

					System.out.println("\n///////		Time to run put " + x + " times for Chaining Hash: " + (end - start) + "\n");
					writer.write("\n///////		Time to run put " + x + " times for Chaining Hash: " + (end - start) + "\n");
					writer.newLine();
					i = 0;
					start = System.nanoTime();
					while (i < x) {
						linearHash.put(keyHolder[i], valueHolder[i]);
						System.out.println("\n");
						i++;
					}
					end = System.nanoTime();
					System.out.println("\n");

					System.out.println("\n///////		Time to run put " + x + " times for Linear Hash: " + (end - start) + "\n");
					writer.write("\n///////		Time to run put " + x + " times for Linear Hash: " + (end - start) + "\n");
					writer.newLine();
					i = 0;
					start = System.nanoTime();
					while (i < x) {
						quadHash.put(keyHolder[i], valueHolder[i]);
						System.out.println("\n");
						i++;
					}
					end = System.nanoTime();
					System.out.println("\n");

					System.out.println("\n///////		Time to run put " + x + " times for Quad Hash: " + (end - start) + "\n");
					writer.write("\n///////		Time to run put " + x + " times for Quad Hash: " + (end - start) + "\n");
					writer.newLine();
					writer.newLine();
					System.out.println("\n");

					System.out.println("////////////////////////////	put() Validation	(FOR " + x + " VALUES) (Quad 101)\n");
					writer.write("////////////////////////////	put() Validation	(FOR " + x + " VALUES) (Quad 101)\n");
					writer.newLine();
					quadHash = new QuadraticHash(101);
					i = 0;
					start = System.nanoTime();
					while (i < x) {
						quadHash.put(keyHolder[i], valueHolder[i]);
						System.out.println("\n");
						i++;
					}
					end = System.nanoTime();
					System.out.println("\n///////		Time to run put " + x + " times for Quad Hash: (size of 101) " + (end - start) + "		///////\n");
					writer.write("\n///////		Time to run put " + x + " times for Quad Hash: (size of 101) " + (end - start) + "		///////\n");
					writer.newLine();
					writer.newLine();
					writer.newLine();

					writer.flush();
					x+=5;
				}
				writer.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}

		
		/////////////////
		//	  STEP 6   //
		/////////////////
		System.out.println("\n////////////////////////////	DYNAMIC RESIZING VALIDATION	 ////////////////////////////");

		linearHash= new LinearHash();
		i=0;
		start=System.nanoTime();
		while (i<10000){
			linearHash.put(random.nextInt(100000),random.nextInt(100000));
			i++;
		}
		end=System.nanoTime();
		System.out.println("\nTime elapsed for 10,000 put statements with dynamic resizing: "+(end-start)+"\n");

		start=System.nanoTime();
		linearHash.put(random.nextInt(100000),random.nextInt(100000));
		end=System.nanoTime();
		System.out.println("\nTime needed for additional put(): "+(end-start)+"\n");

		start=System.nanoTime();
		linearHash.get(random.nextInt(100000));
		end=System.nanoTime();
		System.out.println("\nTime needed for additional get(): "+(end-start)+"\n");
	}

}
