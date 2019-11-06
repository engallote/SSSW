import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int[][] arr = new int[N][N];
        	boolean[][] chk = new boolean[N][N];
        	Vector<Integer> v = new Vector<>();
        	int res = 0;
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextInt();
        	
        	for(int j = 0; j < N; j++)
        	{
        		v.clear();
        		for(int i = 0; i < N; i++)
        		{	
        			if(!chk[i][j] && arr[i][j] == 1)
        			{
        				chk[i][j] = true;
        				for(int k = i + 1; k < N; k++)
        					if(arr[k][j] == 2)
        					{
        						for(int a = i + 1; a <= k; a++)
        							chk[a][j] = true;
        						res += 1;
        						break;
        					}
        			}
        		}	
        		
        		
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}