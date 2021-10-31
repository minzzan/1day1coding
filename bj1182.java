import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1182 {
	static int N, S, ans;
	static int[] input, numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N];
		input = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		Subset(0);

		if (S == 0) {
			ans--;
		}

		System.out.println(ans);

	}

	static void Subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum = sum + input[i];
				}
			}
			if (sum == S) {
				ans++;
			}
			return;
		}

		isSelected[cnt] = true;
		Subset(cnt + 1);
		isSelected[cnt] = false;
		Subset(cnt + 1);
	}
}
