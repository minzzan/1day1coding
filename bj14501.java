import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[][] arr = new int[16][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		dp[0 + arr[0][0]] = arr[0][1];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i]);
			if (i + arr[i][0] <= N) {
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
			}
		}

		System.out.println(Math.max(dp[N - 1], dp[N]));
	}
}
