import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyFours {

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
		for (int j = 0; j < strings.length; j++) {
			int x = Integer.parseInt(strings[j]);
			int a = 0;
			int b = 0;
			boolean found = false;
			Integer reminder = -1;
			int list[] = new int[x];
			list[0] = 0;
			int temp = 4 % x;
			list[4 % x] = 1;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 2; i <= x + 2; i++) {
				reminder = (temp * 10 + 4) % x;
				if (list[reminder] != 0) {
					a = i;
					b = list[reminder];
					break;
				}else{
					list[reminder] = i;
				}
				if (!found && map.get(reminder) != null) {
					a = map.get(reminder);
					b = i;
					found = true;
				} else {
					map.put(reminder, i);
				}
				// System.out.println(reminder);
			}
			if (a == 1 && reminder != 0) {
				b = b - 1;
			} else if (a > 1 && reminder != 0) {
				a = a - 1;
				b = b - 1;
			}
			System.out.println("a: " + a + " b: " + b + " y: " + (2 * a + b));
			System.out.println((2 * a + b));
		}

	}

	private static int reminder(int length, int n) {
		int num = 0;
		for (int i = 1; i <= length; i++) {
			num = addNextDigit(num);
			if (num >= n) {
				num = num % n;
			}

		}
		return num;
	}

	private static int addNextDigit(Integer num) {
		return Integer.parseInt(num.toString() + "4");
	}

}
