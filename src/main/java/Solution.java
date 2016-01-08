import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {
			int noOfTestCases = scanner.nextInt();
			scanner.nextLine();
			int i = 0;
			String[] strings = new String[noOfTestCases];
			while (scanner.hasNext() && i < noOfTestCases) {
				strings[i++] = scanner.next();
				if (i < noOfTestCases) {
					scanner.nextLine();
				}

			}
//		int noOfTestCases = 1000;
//		String[] strings = new String[noOfTestCases];
//		int f=0;
//		for(Integer a=100000;a>99000;a--){
//			strings[f++] =a.toString();
//		}
		List<List<BigInteger>> numbersByLength = new ArrayList<List<BigInteger>>();
		for(int s=1;s<=2000;s++){			
			List<BigInteger> numbers =numbersWithLength(s);
			numbersByLength.add(numbers);
		}
		
			for (int j = 0; j < strings.length; j++) {
				BigInteger x = new BigInteger(strings[j]);
				for (int k = strings[j].length(); k < 2000; k++) {
					int m=1;
					List<BigInteger> numbers = numbersByLength.get(k-1);
					for(BigInteger num:numbers){						
						if(num.mod(x).equals(BigInteger.ZERO)){
							long y = 2*m+ (k-m);
							//System.out.println("k: "+k+" m: "+m+" X: "+x+" "+"Target"+num+" y: "+y);
							//System.out.println(y);
							System.out.println(" X: "+x+" "+"Target"+num);
							k = Integer.MAX_VALUE-1;
							break;
						}
						m++;
					}
				}

			}}
			
		}
	
		
//		for(int i=1;i<=10;i++){
//			
//			List<Long> numbers =numbersWithLength(i);
//			for(Long num:numbers){
//				System.out.print(num+" ");
//			}
//			System.out.println();
//		}
	

	private static List<BigInteger> numbersWithLength(int length) {
		List<BigInteger> numbers = new ArrayList<BigInteger>();
		for (int i = 1, j = length - 1; i <= length; i++, j--) {
			StringBuilder number = new StringBuilder();
			for (int k = 0; k < i; k++) {
				number = number.append("4");
			}
			for (int m = 0; m < j; m++) {
				number = number.append("0");
			}
			numbers.add(new BigInteger(number.toString()));
		}
		return numbers;
	}
}
