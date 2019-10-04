import java.util.*;

public class Main {
	static int N, M;
	static boolean end;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
            M = sc.nextInt();
            arr = new ArrayList[N+1];
            visit = new boolean[N+1];
            for(int i = 1; i <= N; i++)
            	arr[i] = new ArrayList<>();
            
            for(int i = 0; i < M; i++)
            {
            	int a = sc.nextInt();
            	int b = sc.nextInt();
            	arr[a].add(b);
            	arr[b].add(a);
            }
            int res = 0;
            for(int i = 1; i <= N; i++)
            	if(!visit[i])
            	{
            		res++;
            		visit[i] = true;
            		Queue<Integer> q = new LinkedList<>();
            		q.add(i);
            		
            		while(!q.isEmpty())
            		{
            			int x = q.poll();
            			
            			for(int p : arr[x])
            				if(!visit[p])
            				{
            					visit[p] = true;
            					q.add(p);
            				}
            		}
            	}
            System.out.println("#" + test_case + " " + res);
        }
	}
}