import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(tc <= 10)
        {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	int l = 0, r = 0, m, res = 0;
        	for(int i = 0; i < N; i++)
        	{
        		if(i - 2 < 0 || i + 2 >= N) continue;
        		l = Math.max(arr[i-1], arr[i-2]);
        		r = Math.max(arr[i+1], arr[i+2]);
        		m = Math.max(l, r);
        		if(arr[i] > m)
        		{
        			res += arr[i] - m;
        		}
        	}
        	
        	System.out.println("#" + tc + " " + res);
        	tc++;
        }
    }
}