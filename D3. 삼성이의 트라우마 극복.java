import java.util.*;

public class Main {
	static int N, res;
	static boolean[] chk;
	static int[] arr;
	static int[] score;
	static ArrayList<Character>[] name;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        arr = new int[26];
        arr['S'-'A'] = 2;
        arr[0] = arr['M'-'A'] = arr['U'-'A'] = arr['N'-'A'] = arr['G'-'A'] = 1;
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = Integer.MAX_VALUE;
        	N = sc.nextInt();
        	score = new int[N];
        	name = new ArrayList[N];
        	chk = new boolean[N];
        	for(int i = 0; i < N; i++)
        	{
        		name[i] = new ArrayList<>();
        		int L = sc.nextInt();
        		for(int j = 0; j < L; j++)
        			name[i].add(sc.next().charAt(0));
        		score[i] = sc.nextInt();
        	}
        	
        	solve(0, 0);//¸éÁ¢°ü idx
        	if(res == Integer.MAX_VALUE) res = -1;
        	System.out.println("#" + test_case + " " + res);
        }
    }
	private static void solve(int idx, int sum) {
		if(idx == N)
		{
			HashMap<Character, Integer> hs = new HashMap<>();
			for(int i = 0; i < N; i++)
				if(chk[i])
				{
					for(char c : name[i])
					{
						if(hs.containsKey(c))
						{
							int value = hs.get(c) + 1;
							hs.remove(c);
							hs.put(c, value);
						}
						else
							hs.put(c, 1);
					}
				}
			boolean find = true;
			int[] tmp = new int[26];
			Iterator<Character> it = hs.keySet().iterator();
			while(it.hasNext()){
				char key = it.next();
				int value = hs.get(key);
				tmp[key-'A'] = value;
			}
			
			for(int i = 0; i < 26; i++)
				if(arr[i] != 0 && arr[i] > tmp[i])
				{
					find = false;
					break;
				}
			if(find)
				res = Math.min(res, sum);
			return;
		}
		
		chk[idx] = true;
		solve(idx + 1, sum + score[idx]);
		chk[idx] = false;
		solve(idx + 1, sum);
	}
}