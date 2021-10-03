import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4485 {
	static class node implements Comparable<node> {
		int x;
		int y;
		int rupee;

		public node(int x, int y, int rupee) {
			super();
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(node n) {
			return this.rupee < n.rupee ? -1 : 1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 상하좌우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int tc = 0;

		while (true) {
			tc++;
			int N = Integer.parseInt(in.readLine());
			if (N == 0) {
				break;
			}

			int[][] map = new int[N][N];
			int[][] cost = new int[N][N];

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			PriorityQueue<node> queue = new PriorityQueue<>();

			cost[0][0] = map[0][0];

			queue.add(new node(0, 0, map[0][0]));

			while (!queue.isEmpty()) {
				// a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
				node tmpnode = queue.poll();
				int tempx = tmpnode.x;
				int tempy = tmpnode.y;

				// b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
				for (int i = 0; i < 4; i++) {
					int x = tempx + dx[i];
					int y = tempy + dy[i];

					if (x == -1 || y == -1 || x == N || y == N) {
						continue;
					}

					if (cost[y][x] > cost[tempy][tempx] + map[y][x]) { // 기존의 가중치보다 작은 경우
						cost[y][x] = cost[tempy][tempx] + map[y][x]; // 가중치를 교환
						queue.offer(new node(x, y, cost[y][x])); // 큐에 추가
					}
				}
			}
			sb.append("Problem " + tc + ": " + cost[N - 1][N - 1] + "\n");
		}
		System.out.println(sb);
	}
}
