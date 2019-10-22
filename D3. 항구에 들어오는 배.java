import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int N = sc.nextInt();
        	
        	int[] arr = new int[N];
        	boolean[] chk = new boolean[N];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	chk[0] = true;
        	int start = 1;
        	while(true)
        	{
        		res++;
        		int sub = 0, pre = 1;
        		for(int i = start; i < N; i++)
            	{
            		if(pre == 1)
            		{
            			chk[i] = true;
            			sub = arr[i] - pre;
            			pre = arr[i];
            		}
            		else
            		{
            			if(arr[i] - pre == sub)
            			{
            				chk[i] = true;
            				pre = arr[i];
            			}
            		}
            	}
        		boolean flag = true;
        		for(int i = 1; i < N; i++)
        			if(!chk[i])
        			{
        				start = i;
        				flag = false;
        				break;
        			}
        		if(flag) break;
        	}
        	
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}