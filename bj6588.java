import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj6588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = true; // 소수를 false로 함
		isPrime[1] = true;
		// 처음엔 다 prime(false)으로 세팅
		// 배수는 prime이 아니므로 true
		for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
			for (int j = 2; i * j < 1000001; j++) {
				isPrime[i * j] = true; // 소수가 아님
			}
		}

		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) {
				break;
			}
			boolean ans = false;
			for (int i = 2; i <= n / 2; i++) {
				if (!isPrime[i] && !isPrime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					ans = true;
					break;
				}
			}
			if (ans == false) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
