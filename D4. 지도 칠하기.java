import java.util.*;

public class Main {
	static int N, res;
	static int[] color;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = Integer.MAX_VALUE;
        	N = sc.nextInt();
        	color = new int[N + 2];
        	arr = new ArrayList[N + 1];
        	
        	for(int i = 1; i <= N; i++)
        		color[i] = sc.nextInt();
        	
        	for(int i = 1; i <= N; i++)
        	{
        		arr[i] = new ArrayList<>();
        		for(int j = 1; j <= N; j++)
        		{
        			int num = sc.nextInt();
        			if(num == 1)
        				arr[i].add(j);
        		}
        	}
        	
        	solve(1, color[1], 0);
        	System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int c, int cnt) {
		if(idx > N)
		{
			for(int i = 1; i <= N; i++)
			{
				int c2 = color[i];
				for(int next : arr[i])
					if(c2 == color[next]) return;
			}
//			for(int i = 1; i <= N; i++)
//				System.out.print(color[i] + " ");
//			System.out.println("=========");
			res = Math.min(res, cnt);
			return;
		}
		
		int[] tmp = new int[5];
		tmp[c]++;
		for(int next : arr[idx])
			tmp[color[next]]++;
		
		int tmpColor = c;
		for(int i = 1; i <= 4; i++)
			if(tmp[i] == 0)
			{
				color[idx] = i;
				solve(idx + 1, color[idx + 1], cnt + 1);
				color[idx] = tmpColor;
			}
		solve(idx + 1, color[idx+1], cnt);
	}
}