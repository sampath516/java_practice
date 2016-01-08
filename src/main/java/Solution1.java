import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution1 {

	public static void main(String[] args) {
		String[] strings = null;
		try (Scanner scanner = new Scanner(System.in);) {
			int noOfTestCases = scanner.nextInt();
			scanner.nextLine();
			int i = 0;
			strings = new String[noOfTestCases];
			while (scanner.hasNext() && i < noOfTestCases) {
				strings[i++] = scanner.next();
				if (i < noOfTestCases) {
					scanner.nextLine();
				}

			}
		}
		Pattern pattern = Pattern.compile("4+0*");
		for (int j = 0; j < strings.length; j++) {
			BigInteger x = new BigInteger(strings[j]);
			BigInteger one = new BigInteger("1");
			                                  
			BigInteger limit = new BigInteger("10000000");
			for (BigInteger k = one; k.compareTo(limit) < 0; k = k.add(one)) {
				String target = x.multiply(k).toString();
				if (pattern.matcher(target).matches()) {
					Result res = extractAandB_v1(target);
					int y = 2 * res.getA() + res.getB();
					System.out.println(x+" "+target+" "+y);
					break;
				}
			}

		}
	}

	private static Result extractAandB(String str) {

		Result res = new Result();
		char[] chars = str.toCharArray();
		int n4 = 0;
		int n0 = 0;
		for (char c : chars) {
			if (c != '4') {
				break;
			}
			n4++;
		}
		n0 = chars.length - n4;
		res.setA(n4);
		res.setB(n0);
		return res;
	}
	
	private static Result extractAandB_v1(String str) {

		Result res = new Result();
		int n4 = str.split("0")[0].length();
		int n0 = str.length() - n4;
		res.setA(n4);
		res.setB(n0);
		return res;
	}

	private static class Result {

		private int a;
		private int b;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
	}

}
