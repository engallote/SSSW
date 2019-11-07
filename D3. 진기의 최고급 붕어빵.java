import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	String res = "Possible";
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int K = sc.nextInt();
        	int[] arr = new int[11112];
        	int now = 0, cnt = 0;
        	
        	for(int i = 0; i < N; i++)
        		arr[sc.nextInt()]++;
        	
        	for(int i = 0; i <= 11111; i++)
        	{
        		if(cnt == N) break;
        		if(i > 0 && i % M == 0)
        			now += K;
        		if(arr[i] > 0)
        		{
        			if(now >= arr[i])
        				now -= arr[i];
        			else
        			{
        				res = "Impossible";
        				break;
        			}
        			cnt += arr[i];
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}