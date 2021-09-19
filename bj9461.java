import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); // 테스트케이스 개수

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(in.readLine());

			long[] D = new long[N + 1];
			D[0] = 1;
			D[1] = 1;
			if (N == 1) {
				System.out.println(D[0]);
				continue;
			}
			D[2] = 1;
			for (int i = 3; i <= N; i++) {
				D[i] = D[i - 3] + D[i - 2];
			}
			System.out.println(D[N - 1]);
		}
	}
}