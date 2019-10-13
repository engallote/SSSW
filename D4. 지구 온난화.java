import java.util.*;

public class Main {
	static int N, M, wLen, cLen, res;
	static char[] charSet;
	static boolean[] chk, alp;
	static String[] wordSet;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	res = 0;
        	alp = new boolean[26];
        	HashSet<Character> hs = new HashSet<>(), tmp = new HashSet<>();
        	wordSet = new String[N];
        	wLen = 0;
        	cLen = 0;
        	for(int i = 0; i < N; i++)
        	{
        		tmp.clear();
        		String str = sc.next();
        		char[] c = str.toCharArray();
        		for(int j = 0; j < c.length; j++)
        		{
        			hs.add(c[j]);
        			tmp.add(c[j]);
        		}
        			
        		if(tmp.size() <= M)
        			wordSet[wLen++] = str;
        	}
        	
        	if(hs.size() <= M)
        		res = N;
        	else
        	{
        		charSet = new char[hs.size()];
        		for(char c : hs)
        			charSet[cLen++] = c;
        		chk = new boolean[cLen];
        		solve(0, 0);//idx, cnt
        	}
        	System.out.println("#" + test_case + " " + res);      	
        }
    }
	private static void solve(int idx, int cnt) {
		if(cnt == M)
		{
			int count = 0;
			boolean flag = true;
			for(int i = 0; i < wLen; i++)
			{
				flag = true;
				for(int j = 0; j < wordSet[i].length(); j++)
					if(!alp[wordSet[i].charAt(j) - 'a'])
					{
						flag = false;
						break;
					}
				if(flag)
					count++;
			}
			res = Math.max(res, count);
			return;
		}
		if(idx == cLen) return;
		chk[idx] = true;
		alp[charSet[idx] - 'a'] = true;
		solve(idx + 1, cnt + 1);
		chk[idx] = false;
		alp[charSet[idx] - 'a'] = false;
		solve(idx + 1, cnt);
	}
}