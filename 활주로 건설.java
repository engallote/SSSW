import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	res = 0;
        	arr = new int[N][N];
        	int[][] ver = new int[N][N], hor = new int[N][N];
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        		{
        			arr[i][j] = sc.nextInt();
        			if(j > 0) ver[i][j] = arr[i][j] - arr[i][j-1];
        			if(i > 0) hor[i][j] = arr[i][j] - arr[i-1][j];
        		}
        	
//        	for(int i = 0; i < N; i++)
//        	{
//        		for(int j = 0; j < N; j++)
//        			System.out.print(hor[i][j]+ " ");
//        		System.out.println();
//        	}
        	
        	boolean[] chk = new boolean[N];
        	int cnt = 0;
        	boolean flag = false;;
        	//°¡·Î °Ë»ç
        	for(int i = 0; i < N; i++)
        	{
        		flag = true;
        		Arrays.fill(chk, false);
        		for(int j = 0; j < N; j++)
        		{
        			if(chk[j] || ver[i][j] == 0) continue;
        			if(Math.abs(ver[i][j]) >= 2)
        			{
        				flag = false;
        				break;
        			}
        			cnt = 0;
        			if(ver[i][j] == 1)//³·->³ô
        			{
        				if(ver[i][j-1] != 0 || chk[j-1])
        				{
        					flag = false;
        					break;
        				}
        				ver[i][j] = 0;
        				ver[i][j-1] = 0;
        				for(int k = j-1; k >= 0; k--)
        				{
        					if(chk[k] || ver[i][k] != 0) break;
        					cnt++;
        				}
        				if(cnt >= M)
        				{
        					for(int k = j-1; k >= j - M; k--)
        						chk[k] = true;
        				}
        				else
        				{
        					flag = false;
        					break;
        				}
        			}
        			else//³ô->³·
        			{
        				ver[i][j] = 0;
        				for(int k = j; k < N; k++)
        				{
        					if(chk[k] || ver[i][k] != 0) break;
        					cnt++;
        				}
        				if(cnt >= M)
        				{
        					for(int k = j; k < j + M; k++)
        						chk[k] = true;
        				}
        				else
        				{
        					flag = false;
        					break;
        				}
        			}
        		}
        		if(flag) 
        		{
//        			System.out.println(" ver : " + i);
        			res++;
        		}
        	}
        	
        	//¼¼·Î °Ë»ç
        	for(int j = 0; j < N; j++)
        	{
        		flag = true;
//        		System.out.println("start : " + j);
        		Arrays.fill(chk, false);
        		for(int i = 0; i < N; i++)
        		{
        			if(chk[i] || hor[i][j] == 0) continue;
        			if(Math.abs(hor[i][j]) >= 2)
        			{
        				flag = false;
        				break;
        			}
        			cnt = 0;
        			if(hor[i][j] == 1)//³·->³ô
        			{
        				if(hor[i-1][j] != 0 || chk[i-1])
        				{
        					flag = false;
        					break;
        				}
        				hor[i][j] = 0;
        				hor[i-1][j] = 0;
        				for(int k = i - 1; k >= 0; k--)
        				{
        					if(chk[k] || hor[k][j] != 0) break;
        					cnt++;
        				}
//        				System.out.println((i-1) + " " + (i-M) + " : " + cnt);
        				if(cnt >= M)
        				{
        					for(int k = i - 1; k >= i - M; k--)
        						chk[k] = true;
        				}
        				else
        				{
        					flag = false;
        					break;
        				}
        			}
        			else//³ô->³·
        			{
        				hor[i][j] = 0;
        				for(int k = i; k < N; k++)
        				{
        					if(chk[k] || hor[k][j] != 0) break;
        					cnt++;
        				}
//        				System.out.println(i + " " + (i + M - 1));
        				if(cnt >= M)
        				{
        					for(int k = i; k < i + M; k++)
        						chk[k] = true;
        				}
        				else
        				{
        					flag = false;
        					break;
        				}
        			}
        		}
        		if(flag)
        		{
//        			System.out.println("hor : " + j);
        			res++;
        		}
        	}
            
            System.out.println("#" + test_case + " " + res);
        }
	}
}