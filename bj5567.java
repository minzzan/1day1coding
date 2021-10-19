import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj5567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());

		LinkedList<Integer>[] list = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		StringTokenizer st = null;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		boolean[] invited = new boolean[n + 1];
		if (list[1].isEmpty()) {
			System.out.println(0);
			return;
		}
		invited[1] = true;
		for (int i : list[1]) {
			invited[i] = true;
			for (int j : list[i]) {
				if (!invited[j]) {
					invited[j] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (invited[i]) {
				cnt++;
			}
		}

		System.out.println(cnt - 1);
	}
}
