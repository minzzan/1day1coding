import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 컴퓨터의 수
		int M = Integer.parseInt(in.readLine()); // 선의 수

		int[][] map = new int[N + 1][N + 1];
		int[] minEdge = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // a부터
			int b = Integer.parseInt(st.nextToken()); // b까지
			int c = Integer.parseInt(st.nextToken()); // 비용

			map[a][b] = map[b][a] = c;
		}

		for (int i = 1; i <= N; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result = 0; // 최소신장트리 비용
		minEdge[1] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅

		for (int i = 1; i <= N; i++) {
			// 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1; // 최소간선비용의 정점번호
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true; // 신장트리에 포함시킴
			result += min; // 간선비용 누적

			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && map[minVertex][j] != 0 && minEdge[j] > map[minVertex][j]) {
					minEdge[j] = map[minVertex][j];
				}
			}
		}

		System.out.println(result);
	}
}
