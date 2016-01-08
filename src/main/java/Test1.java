import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Test1 {

	public static void main(String[] args) {
//		System.out.println(Long.MAX_VALUE);
//		Long.parseLong("40000000000000000000");
		
		for(int i=1;i<=1000;i++){
		
		List<BigInteger> numbers =numbersWithLength(i);
		List<List<BigInteger>> numbersByLength = new ArrayList<List<BigInteger>>();
		numbersByLength.add(numbers);
		for(BigInteger num:numbers){
			System.out.print(num+" ");
		}
		System.out.println();
	}


	}
	
	
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
