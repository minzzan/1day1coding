import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070 {

	static int N, answer;
	static int[][] map;

	// →, ↘, ↓
	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 0, 0); // x,y,d
		System.out.println(answer);

	}

	static void dfs(int x, int y, int d) {
//		System.out.println("dfs 들어옴");
		if (x == N - 1 && y == N - 1 && map[y][x] != 1) {
			answer++;
			return;
		}

		int[] dir = direction(d);
		for (int i = dir[0]; i <= dir[1]; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= N || ny >= N) {
				continue;
			}

			if (map[ny][nx] == 1) {
				continue;
			}

			if (i == 1) { // 대각선일때 주변에 벽있는지 확인
				if (x != N - 1 && y != N - 1) {
					if (map[y + 1][x] == 1 || map[y][x + 1] == 1) {
						continue;
					}
				}
			}

////			확인용
//			System.out.println(x + " " + y);
//			System.out.println(nx + " " + ny + " " + i);
			dfs(nx, ny, i);
		}
	}

	static int[] direction(int d) { // 방향에 따른 체크범위
		if (d == 0) {
			return new int[] { 0, 1 }; // 가로 => 0~1(→, ↘)
		}
		if (d == 2) {
			return new int[] { 1, 2 }; // 세로 => 1~2(↘, ↓)
		} else {
			return new int[] { 0, 2 }; // 대각선 => 0~2(→, ↘, ↓)
		}
	}
}
