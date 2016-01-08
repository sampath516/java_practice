import java.util.Scanner;

public class Fours {

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
		int N;
		int a = 0, b = 0, i;
		for (int j = 0; j < strings.length; j++) {

			N = Integer.parseInt(strings[j]);
			assert (1 <= N);
			assert (N <= 100000);
			if (N == 1 || N == 2 || N == 4) {
				System.out.println(2);
				continue;
			}
			int A[] = new int[N];
			A[0] = 0;
			for (i = 1; i < N; i++)
				A[i] = -1;
			A[4 % N] = 1;
			int temp = 4 % N;
			for (i = 2; i <= N + 2; i++) {
				if (A[(temp * 10 + 4) % N] != -1) {
					a = i;
					b = A[(temp * 10 + 4) % N];
					break;
				} else {
					A[(temp * 10 + 4) % N] = i;
					temp = (temp * 10 + 4) % N;
				}
			}
			System.out.println(2 * a - b);

		}
		return;

	}

}
