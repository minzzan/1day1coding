import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine()); // 해빈이가 가진 의상의 수

			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String name = st.nextToken();
				String category = st.nextToken();
				map.put(category, map.getOrDefault(category, 0) + 1);
			}

			int ans = 1;
			for (int val : map.values())
				ans *= val + 1;
			System.out.println(ans - 1);

		}

	}

}
