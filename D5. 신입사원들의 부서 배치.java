import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] arr, part;
	static int[] chk, chk2;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			N = sc.nextInt();
			arr = new ArrayList[N+1];
			part = new ArrayList[N+1];
			visit = new boolean[N+1];
			chk = new int[N+1];
			chk2 = new int[N+1];
			Arrays.fill(chk, -1);
			
			for(int i = 1; i <= N; i++)
			{
				arr[i] = new ArrayList<>();
				part[i] = new ArrayList<>();
			}
			
			for(int i = 1; i <= N; i++)
				for(int j = 0; j < N; j++)
					arr[i].add(sc.nextInt());
			
			for(int i = 1; i <= N; i++)
				for(int j = 0; j < N; j++)
					part[i].add(sc.nextInt());
			
			for(int i = 1; i <= N; i++)
			{
				Arrays.fill(visit, false);
				dfs(i);
			}
			System.out.println("#" + test_case);
			for(int i = 1; i <= N; i++)
				System.out.println(chk2[i]);
		}
	}
	private static boolean dfs(int idx) {
//		if(visit[idx]) return false;
//		visit[idx] = true;
		
		for(int next : arr[idx])
		{
			int idx2 = part[next].indexOf(idx);
			int idx3 = N + 1;
			if(chk[next] != -1) idx3 = part[next].indexOf(chk[next]);
			if(chk[next] == -1 || idx2 < idx3)
			{
//				System.out.println(idx + " - > " + next);
				int tmp = chk[next];
				chk[next] = idx;
				chk2[idx] = next;
				if(tmp != -1)
					dfs(tmp);
				return true;
			}
		}
		
		return false;
	}
}