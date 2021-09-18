import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14502 {
	static class node {
		int x;
		int y;
		int num;

		public node(int y, int x, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		public node(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "node [x=" + x + ", y=" + y + "]";
		}

	}

	// 조합때 사용되는 애들
	static node[] numbers;
	static LinkedList<node> input;

	// BFS에서 사용되는 애들
	static int N, M;
	static int[][] map;
	static LinkedList<node> list;

	// 완전탐색 (상하좌우)
	static int[] deltax = { 0, 0, -1, 1 };
	static int[] deltay = { -1, 1, 0, 0 };

	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		numbers = new node[3];
		input = new LinkedList<>();
		list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				list.add(new node(i, j, num));
				if (num == 0) {
					input.add(new node(i, j));
				}
			}
		}

		combination(0, 0);

		System.out.println(result);

	}

	static void BFS(node[] numbers) {
		// map 복사해서 쓸것임
		int[][] tempmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempmap[i][j] = map[i][j];
			}
		}

		// 조합으로 만들어진 세 좌표들에 벽을 세워줌
		for (int i = 0; i < 3; i++) {
			node temp = numbers[i];
			tempmap[temp.y][temp.x] = 1;
		}

		// 바이러스를 넣을 큐
		Queue<node> queue = new LinkedList<>();
		// 바이러스라면 큐에 넣음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					queue.add(new node(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			node temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + deltax[i];
				int ny = temp.y + deltay[i];

				if (nx <= -1 || ny <= -1 || nx >= M || ny >= N) {
					continue;
				}

				if (tempmap[ny][nx] == 0) {
					tempmap[ny][nx] = 2;
					queue.add(new node(ny, nx));
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempmap[i][j] == 0) {
					cnt++;
				}
			}
		}

		result = Math.max(cnt, result);

	}

	static void combination(int cnt, int start) {
		if (cnt == 3) {
			BFS(numbers);
			return;
		}
		for (int i = start; i < input.size(); i++) {
			numbers[cnt] = input.get(i);
			combination(cnt + 1, i + 1);
		}
	}
}
