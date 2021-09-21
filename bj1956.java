import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1956 {

	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int[][] D = new int[V + 1][V + 1];

		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				D[i][j] = 9999;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			D[start][end] = weight;
		}

		// 플로이드 와샬 알고리즘 수행
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
				}
			}
		}

		int result = 9999;
		// 최소 사이클 중 최솟값을 구한다.
		for (int i = 1; i <= V; i++)
			result = Math.min(D[i][i], result);

		// 최솟값이 INF 라면 경로가 없다는 뜻이다.
		if (result == 9999) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
