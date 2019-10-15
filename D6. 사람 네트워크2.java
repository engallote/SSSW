import java.util.*;

public class Main {
	static int N, res;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	res = Integer.MAX_VALUE;
        	arr = new ArrayList[N+1];
        	for(int i = 1; i <= N; i++)
        		arr[i] = new ArrayList<>();
        	for(int i = 1; i <= N; i++)
        	{
        		for(int j = 1; j <= N; j++)
        		{
        			int num = sc.nextInt();
        			if(num == 1)
        				arr[i].add(j);
        		}
        	}
        	
        	int[] num = new int[N+1];
        	for(int i = 1; i <= N; i++)
        	{
        		Arrays.fill(num, Integer.MAX_VALUE);
        		Queue<Pair> q = new LinkedList<>();
        		q.add(new Pair(i, 0));
        		num[i] = 0;
        		while(!q.isEmpty())
        		{
        			Pair p = q.poll();
        			
        			for(int next : arr[p.x])
        				if(num[next] > p.cnt + 1)
        				{
        					num[next] = p.cnt + 1;
        					q.add(new Pair(next, p.cnt + 1));
        				}
        		}
        		int sum = 0;
        		for(int k = 1; k <= N; k++)
        			sum += num[k];
        		if(sum < res)
        			res = sum;
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}
class Pair{
	int x, cnt;
	Pair(int x, int cnt)
	{
		this.x = x;
		this.cnt = cnt;
	}
}