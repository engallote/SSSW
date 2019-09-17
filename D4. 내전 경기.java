import java.util.*;

public class Main {
	static int N, len;
	static boolean flag;
	static HashMap<String, Integer> hs;
	static boolean[][] ss;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			hs = new HashMap<>();
			ss = new boolean[201][201];
			int idx = 0;
			flag = false;
			
			for(int i = 0; i < N; i++)
			{
				String name1 = sc.next();
				if(!hs.containsKey(name1)) hs.put(name1, idx++);
				String name2 = sc.next();
				if(!hs.containsKey(name2)) hs.put(name2, idx++);
				ss[hs.get(name1)][hs.get(name2)] = ss[hs.get(name2)][hs.get(name1)] = true;
			}
			len = idx;
			chk = new boolean[idx];
			ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
			solve(0, a, b);
			
			System.out.println("#" + test_case + " " + (flag ? "Yes" : "No"));
		}
	}
	private static void solve(int idx, ArrayList<Integer> a, ArrayList<Integer> b) {
		if(flag) return;
		if(idx >= len)
		{
			if(a.isEmpty() || b.isEmpty()) return;
			for(int i = 0; i < b.size(); i++)
				for(int j = i + 1; j < b.size(); j++)
					if(ss[b.get(i)][b.get(j)]) return;
			flag = true;
			return;
		}
		boolean af = true, bf = true;
		for(int next : a)
			if(ss[next][idx])
			{
				af = false;
				break;
			}
		if(af)
		{
			a.add(idx);
			solve(idx + 1, a, b);
			a.remove(a.size() - 1);
		}
		for(int next : b)
			if(ss[next][idx])
			{
				bf = false;
				break;
			}
		if(bf)
		{
			b.add(idx);
			solve(idx + 1, a, b);
			b.remove(b.size() - 1);
		}
	}
}