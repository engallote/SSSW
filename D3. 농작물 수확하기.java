import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	int N = sc.nextInt();
        	int[][] arr = new int[N][N];
        	int res = 0;
        	for(int i = 0; i < N; i++)
        	{
        		char[] c = sc.next().toCharArray();
        		for(int j = 0; j < N; j++)
        			arr[i][j] = c[j] - '0';
        	}
        	
        	int center = N / 2, sy = 0, ey = N - 1;
        	
        	while(sy <= ey)
        	{
        		for(int i = sy; i <= ey; i++)
        		{
        			res += arr[center][i];
//        			arr[center][i] = 8;
        		}
        		
        		sy++;
        		ey--;
        		center--;
        	}
        	center = N / 2 + 1;
        	sy = 1;
        	ey = N - 2;
        	while(sy <= ey)
        	{
        		for(int i = sy; i <= ey; i++)
        		{
        			res += arr[center][i];
//        			arr[center][i] = 8;
        		}
        		sy++;
        		ey--;
        		center++;
        	}
        	
//        	for(int i = 0; i < N; i++)
//        	{
//        		for(int j = 0; j < N; j++)
//        			System.out.print(arr[i][j] + " ");
//        		System.out.println();
//        	}
        	System.out.println("#" + t + " " + res);
        }
    }
}