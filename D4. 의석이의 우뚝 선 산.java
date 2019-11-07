import java.util.*;

public class Main {
	static int N;
	static long res, tmp;
	static int[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	arr = new int[N];
        	res = 0;
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	for(int i = 1; i < N - 1; i++)
        	{
        		tmp = 0;
        		int cnt = 0, cnt2 = 0, pre = arr[i];
        		for(int j = i - 1; j >= 0; j--)
        		{
        			if(pre > arr[j])
        			{
        				cnt++;
        				pre = arr[j];
        			}
        			else break;
        		}
        		pre = arr[i];
        		for(int k = i + 1; k < N; k++)
        		{
        			if(pre > arr[k])
        			{
        				pre = arr[k];
        				cnt2++;
        			}
        			else break;
        		}
        		res += (cnt * cnt2);
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}