import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	boolean[] chk = new boolean[10000];
        	
        	for(int i = 0; i < N; i++)
        	{
        		arr[i] = sc.nextInt();
        		chk[arr[i]] = true;
        	}
        	boolean flag = false;
        	int min = Integer.MAX_VALUE, res = min;
        	for(int i = 0; i < 10; i++)
        		if(!chk[i] && res > i)
        		{
        			flag = true;
        			res = i;
        			break;
        		}
        	if(flag)
        	{
        		System.out.println("#" + test_case + " " + res);
        		continue;
        	}
        	res = Integer.MAX_VALUE;
        	int start = 1, end = 10;
        	for(int i = 1; i < N; i++)
        	{
        		start *= 10;
        		end *= 10;
        		min = Integer.MAX_VALUE;
        		for(int j = 0; j < N - i; j++)
        		{
        			int num = 0;
        			for(int k = j; k <= j + i; k++)
        			{
        				num += arr[k];
        				if(k != j + i)
        					num *= 10;
        			}
//        			System.out.println(num);
        			chk[num] = true;
        		}
        		for(int a = start; a < end; a++)
            		if(!chk[a])
            		{
            			min = a;
            			break;
            		}
        		if(min < res)
        		{
            		res = min;
            		break;
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}