import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int start = sc.nextInt();
        	ArrayList<Integer>[] arr = new ArrayList[101];
        	int[] depth = new int[101];
        	Arrays.fill(depth, -1);
        	for(int i = 0; i <= 100; i++)
        		arr[i] = new ArrayList<>();
        	Queue<Integer> q = new LinkedList<>();
        	q.add(start);
        	depth[start] = 0;
        	for(int i = 0; i < N / 2; i++)
        	{
        		int from = sc.nextInt();
        		int to = sc.nextInt();
        		if(arr[from].contains(to)) continue;
        		arr[from].add(to);
        	}
        	
        	while(!q.isEmpty())
        	{
        		int x = q.poll();
        		for(int next : arr[x])
        		{
        			if(depth[next] == -1)
        			{
        				depth[next] = depth[x] + 1;
        				q.add(next);
        			}
        		}
        	}
        	int res = 0, max = 0;
        	for(int i = 100; i >= 0; i--)
        	{
        		if(max < depth[i])
        		{
        			max = depth[i];
        			res = i;
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}