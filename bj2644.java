import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2644 {
	static int n;
	static int answer = -1;
	static boolean[][] adj;
	static boolean[] visited;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(in.readLine());

		adj = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x][y] = adj[y][x] = true; // 관계 그래프 만듦
		}

		DFS(a1, a2, 0);

		System.out.println(answer);
	}

	static void DFS(int start, int end, int cnt) {
		visited[start] = true; // 방문한 사람 체크

		if (start == end) { // 답을 찾음
			answer = cnt;
			flag = true; // 답을 찾음
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!adj[start][i]) { // 관계가 없는경우 지나감
				continue;
			}
			if (adj[start][i] && visited[i]) { // 관계가 있지만 방문했던 경우 패스
				continue;
			}

			DFS(i, end, cnt + 1); // 위의 조건에 해당되지 않는다면 관계있으므로 그친구를 DFS 탐색, cnt증가
			if (flag) { // 만약 정답을 찾았으면
				break; // 반복문 탈출~
			}
		}
		return;

	}
}
