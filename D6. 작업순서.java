import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int V = sc.nextInt();
        	int E = sc.nextInt();
        	int[] indgree = new int[V+1];
        	ArrayList<Integer>[] arr = new ArrayList[V+1];
        	for(int i = 0; i <= V; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 0; i < E; i++)
        	{
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		arr[a].add(b);
        		indgree[b]++;
        	}
        	Queue<Integer> q = new LinkedList<>();
        	for(int i = 1; i <= V; i++)
        		if(indgree[i] == 0)
        			q.add(i);
        	
        	String res = "";
        	while(!q.isEmpty())
        	{
        		int x = q.poll();
        		res += x + " ";
        		for(int next : arr[x])
        		{
        			indgree[next] -= 1;
        			if(indgree[next] == 0)
        				q.offer(next);
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}