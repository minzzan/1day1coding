import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int H = Integer.parseInt(st.nextToken()); // 호텔의 층 수 (높이)
			int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수 (가로)
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지

			int cnt = 0; // 반복문 도는 횟수
			for (int i = 1; i <= W; i++) { // 높이순으로 우선순위
				for (int j = 1; j <= H; j++) {
					cnt++;
					if (cnt == N) {
						System.out.print(j);
						if (i < 10) {
							System.out.print(0);
						}
						System.out.print(i);
					}
				}
			}
		}
	}
}
