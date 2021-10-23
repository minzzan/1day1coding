import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889 {

	static long[] input;
	static long[] numbers;
	static long[][] arr;
	static int N;
	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;

		arr = new long[N][N];
		input = new long[N];
		numbers = new long[N]; // 순열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			input[i] = i;
		}

		permutation(0, 0);
		System.out.println(min);
	}

	static void permutation(int cnt, int flag) {
		if (cnt == N) {
//			System.out.println("순열" + Arrays.toString(numbers));
			min = Math.min(min, simulation(numbers));
//			System.out.println(min);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			numbers[cnt] = input[i];
			permutation(cnt + 1, flag | 1 << i);
		}
	}

	static int simulation(long[] input) {
		int[] S = new int[N / 2];
		int[] L = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			S[i] = (int) input[i];
		}
		for (int i = 0; i < N / 2; i++) {
			L[i] = (int) input[N / 2 + i];
		}

		int Ssum = hap(S);
		int Lsum = hap(L);

		return Math.abs(Ssum - Lsum);
	}

	static int hap(int[] input) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (i == j) {
					continue;
				}
				sum += arr[input[i]][input[j]];
			}
		}
		return sum;
	}
// 조합으로 다시 풀어보기,,
}
