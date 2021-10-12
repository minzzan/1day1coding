import java.util.Scanner;

public class bj1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] prime = new boolean[N + 1];

		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			// prime[i]가 소수라면
			if (!prime[i]) {
				// prime[j] 소수가 아닌 표시
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
			}
		}

		// 소수 출력
		for (int i = M; i <= N; i++) {
			if (!prime[i])
				System.out.println(i);
		}

	}

}
