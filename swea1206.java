import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());

			int[] arr = new int[N + 2];
			int ans = 0;

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 2; i < N; i++) {
				int[] temp = new int[4];
				temp[0] = arr[i] - arr[i - 2];
				temp[1] = arr[i] - arr[i - 1];
				temp[2] = arr[i] - arr[i + 1];
				temp[3] = arr[i] - arr[i + 2];

				Arrays.sort(temp);

				if (temp[0] > 0) {
					ans += temp[0];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

	}

}
