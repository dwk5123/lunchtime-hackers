import java.util.Scanner;

public class NumberCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Print all of the prime/happy numbers between these two values
		int low = scanner.nextInt();
		int high = scanner.nextInt();
		
		boolean results = new boolean[high - low];
		for (int i = 0; i < results.length; i++) {
			results[i] = true;
		}
		
		//Calculate with Sieve of Eratosthenes
		for (int i = 2; i < Math.sqrt(high); i++) {
			for (int j = 0; j < results.length; j++) {
				if ((j+low) % i == 0) {
					//If they're evenly divisible, they don't be prime
					results[j] = false;
				}
			}
		}		
		
		for (int i = 0; i < results.length; i++) {
			int num = i + low;
			boolean happy = isHappy(num);
			boolean prime = results[i];
			String output = "";
			if (happy && prime) {
				output = " happy and prime."
			} else if (happy) {
				output = " happy and nonprime.";
			} else if (prime) {
				output = " sad and prime."
			} else {
				output = " sad and nonprime.";
			}
			System.out.println(num + " is " + output);
		}
		
		/*long startTime = System.currentTimeMillis();
		for (int i = 1; i < 10000000; i++) {
			//System.out.println(i + " is a " + (isHappy(i) ? " happy " : " sad ") + " number");
			isHappy(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Executed in: " + (endTime - startTime) + " milliseconds");
		*/
	}
	
	private static boolean isHappy(int a) {
		int test = happySquare(a);
		//The start of a sad number :'(
		while (	test != 4   && 
				test != 16  &&
				test != 37  &&
				test != 58  &&
				test != 89  &&
				test != 145 && 
				test != 42  && 
				test != 20 &&
				test != 1) {
			test = happySquare(test);
		}
		return (test == 1);
	}
	
	private static int happySquare(int a) {
		//System.out.println("Debug: " + a);
		if (a < 10) {
			//System.out.println(a);
			return (int) Math.pow(a, 2);
		} else {
			//Integer division
			return (int) Math.pow((a % 10), 2) + happySquare(a / 10);
		}
	}
}