import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj18352 {

	static int N, M, K, X;
	static int[] dist;
	static int answer = 0;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시개수
		M = Integer.parseInt(st.nextToken()); // 도로개수
		K = Integer.parseInt(st.nextToken()); // 거리정보
		X = Integer.parseInt(st.nextToken()); // 출발도시

		dist = new int[N + 1];

		list = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}

		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dijkstra();

		int a = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				a++;
			}
		}
		if (a == 0) {
			System.out.println(-1);
			return;
		}
	}

	static void dijkstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		dist[X] = 0;
		pq.offer(X);

		while (!pq.isEmpty()) {
			int temp = pq.poll();

			for (int i : list[temp]) {
				if (dist[i] > dist[temp] + 1) {
					dist[i] = dist[temp] + 1;
					pq.offer(i);
				}
			}
		}

	}

}
