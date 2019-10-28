import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int M = sc.nextInt();
        	int N = sc.nextInt();
        	int[][] arr = new int[N][M];
        	boolean[][] chk = new boolean[N][M];
        	int res = 0;
        	
        	for(int i = 0; i < N; i++)
        	{
        		for(int j = 0; j < M; j++)
        		{
        			if(!chk[i][j])
        			{
        				arr[i][j] = 1;
        				chk[i][j] = true;
        				res++;
        				if(i + 2 < N)
        					chk[i+2][j] = true;
        				if(j + 2 < M)
        					chk[i][j+2] = true;
        			}
        		}
        	}
        	
//        	for(int i = 0; i < N; i++)
//        	{
//        		for(int j = 0; j < M; j++)
//        			System.out.print(arr[i][j] + " ");
//        		System.out.println();
//        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}