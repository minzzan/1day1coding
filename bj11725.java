import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		ArrayList<Integer>[] tree = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		boolean visited[] = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;

		int[] ans = new int[N + 1];

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i : tree[temp]) {
				if (!visited[i]) {
					visited[i] = true;
					ans[i] = temp;
					queue.add(i);
				}
			}
		}

		for (int i = 2; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}
}
