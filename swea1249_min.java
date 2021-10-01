import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class swea1249_min {
	static class node implements Comparable<node> {
		int x;
		int y;
		int d;

		public node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(node o) {
			return this.d < o.d ? -1 : 1;
		}
	}

	static int N;
	static int[][] map;
	static int[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			int ans = solve();
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static int solve() {

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		PriorityQueue<node> queue = new PriorityQueue<>();
		queue.add(new node(0, 0, map[0][0]));

		cost[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			node tmpnode = queue.poll();

			int x = tmpnode.x;
			int y = tmpnode.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx == -1 || ny == -1 || nx == N || ny == N) {
					continue;
				}

				if (cost[ny][nx] > cost[y][x] + map[ny][nx]) {
					cost[ny][nx] = cost[y][x] + map[ny][nx];
					queue.offer(new node(nx, ny, cost[ny][nx]));
				}
			}
		}

		return cost[N - 1][N - 1];

	}
}
