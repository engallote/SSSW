import java.util.Scanner;

public class Main {
	static int N, M;
	static long res;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	N = sc.nextInt();
        	M = sc.nextInt();
        	long[][] arr = new long[N][N];
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        		{
        			arr[i][j] = sc.nextLong();
        			if(j > 0)
        				arr[i][j] += arr[i][j-1];
        		}
        	
        	int row = 0, col = M-1;
        	long sum = 0;
        	while(row <= N - M)
        	{
        		for(int i = col; i < N; i++)
        		{
        			sum = 0;
        			if(i == col)
        			{
        				for(int j = row; j < row + M; j++)
            				sum += arr[j][i];
        			}
        			else
        				for(int j = row; j < row + M; j++)
            				sum += (arr[j][i] - arr[j][i-M]);
        			if(res < sum) res = sum;
        		}
        		
        		row++;
        	}
            System.out.println("#" + test_case + " " + res);
        }
    }
}