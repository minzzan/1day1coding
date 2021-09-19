
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static LinkedList<node> list;
	static node SG;

	static class node {
		int x;
		int y;
		int tag;
		boolean visit;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine()); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine()); // 편의점 개수
			list = new LinkedList<>();

			StringTokenizer st = null;
			// 승근이네 따로저장
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			SG = new node(x, y);

			// 편의점+펜타포트 저장
			for (int i = 1; i < N + 2; i++) {
				st = new StringTokenizer(in.readLine());
				int xx = Integer.parseInt(st.nextToken());
				int yy = Integer.parseInt(st.nextToken());
				list.add(new node(xx, yy));
			}
			list.getLast().tag = 1;

			BFS();
		}

	}

	static void BFS() {
		Queue<node> queue = new LinkedList<>();
		queue.add(SG);
		boolean answer = false; // 도착 했는가 안했는가

		while (!queue.isEmpty()) {
			node cur = queue.poll();

			int n = list.size();
			for (int i = 0; i < n; i++) {
				if (!list.get(i).visit) {
					if (distance(cur.x, cur.y, list.get(i).x, list.get(i).y) <= 20 * 50) {
						if (list.get(i).tag == 1) {
							answer = true;
							break;
						} else if (list.get(i).tag == 0) {
							list.get(i).visit = true;
							queue.add(list.get(i));
						}
					}
				}
			}
		}

		System.out.println(answer ? "happy" : "sad");
	}

}
