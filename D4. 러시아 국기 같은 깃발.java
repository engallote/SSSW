import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int res = 0;
        	char[][] arr = new char[N][M];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.next().toCharArray();
        	
        	if(N == 3)
        	{
        		for(int i = 0; i < M; i++)
        			if(arr[0][i] != 'W')
        				res++;
        		for(int i = 0; i < M; i++)
        			if(arr[1][i] != 'B')
        				res++;
        		for(int i = 0; i < M; i++)
        			if(arr[2][i] != 'R')
        				res++;
        	}
        	else
        	{
        		int l = 1, r = N - 2, cnt;
        		res = Integer.MAX_VALUE;
        		while(l <= r)
        		{
//        			System.out.println(l + " " + r);
        			cnt = 0;
        			for(int i = 0; i < l; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != 'W')
        						cnt++;
        			for(int i = l; i <= r; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != 'B')
        						cnt++;
        			for(int i = r + 1; i < N; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != 'R')
        						cnt++;
        			if(res > cnt)
        				res = cnt;
        			l++;
        			if(l > r)
        			{
        				l = 1;
        				r--;
        			}
        		}
        		
        	}
        	System.out.println("#" + t + " " + res);
        }
    }
}