import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15651 {
	static int[] numbers;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		permutation(0, 0);
		System.out.println(sb);
	}

	static void permutation(int cnt, int flag) {
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			numbers[cnt] = i;
			permutation(cnt + 1, flag | 1 << i);
		}
	}
}
