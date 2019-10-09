import java.util.*;

public class Main {
	static int N, res;
	static Pair[][][] arr = new Pair[11][11][2];
	static int[] a, b;
	static int[] dx = {0, -1, 0, 1, 0}, dy = {0, 0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	res = 0;
        	int M = sc.nextInt();
        	a = new int[N];
        	b = new int[N];
        	
        	for(int i = 0; i < N; i++)
        		a[i] = sc.nextInt();
        	
        	for(int i = 0; i < N; i++)
        		b[i] = sc.nextInt();
        	
        	for(int i = 1; i <= 10; i++)
        		for(int j = 1; j <= 10; j++)
        			Arrays.fill(arr[i][j], new Pair(-1, 0));
        	
        	for(int t = 0; t < M; t++)
        	{
        		int y = sc.nextInt();
        		int x = sc.nextInt();
        		int c = sc.nextInt();
        		int p = sc.nextInt();
        		
        		int xx = x, y1 = y - c, y2 = y + c;
        		while(y1 <= y2)
        		{
        			int s = y1 < 1 ? 1 : y1 , e = y2 > 10 ? 10 : y2;
        			for(int i = s; i <= e; i++)
        			{
        				if(arr[xx][i][1].num < p)
        				{
        					if(arr[xx][i][0].num < p)
            				{
            					arr[xx][i][1] = arr[xx][i][0];
            					arr[xx][i][0] = new Pair(t, p);
            				}
            				else
            					arr[xx][i][1] = new Pair(t, p);
        				}
        			}
        			xx--;
        			if(xx == 0) break;
        			y1++;
        			y2--;
        		}
        		xx = x + 1;
        		y1 = y - c + 1; 
        		y2 = y + c - 1;
        		while(y1 <= y2)
        		{
        			if(xx > 10) break;
        			int s = y1 < 1 ? 1 : y1, e = y2 > 10 ? 10 : y2;
        			for(int i = s; i <= e; i++)
        			{
        				if(arr[xx][i][1].num < p)
        				{
        					if(arr[xx][i][0].num < p)
            				{
            					arr[xx][i][1] = arr[xx][i][0];
            					arr[xx][i][0] = new Pair(t, p);
            				}
            				else
            					arr[xx][i][1] = new Pair(t, p);
        				}
        			}
        			xx++;
        			y1++;
        			y2--;
        		}
        	}
        	
        	int ax = 1, ay = 1, bx = 10, by = 10;
    		res += arr[bx][by][0].num;
    		res += arr[ax][ay][0].num;
        	int max = 0;
        	for(int t = 0; t < N; t++)
        	{
        		ax += dx[a[t]];
        		ay += dy[a[t]];
        		bx += dx[b[t]];
        		by += dy[b[t]];
        		max = 0;
        		if(arr[ax][ay][0].cnt == arr[bx][by][0].cnt)
            	{
            		if(arr[ax][ay][1].cnt == -1 && arr[bx][by][1].cnt == -1)
            			 max = arr[ax][ay][0].num;
            		else if(arr[ax][ay][1].cnt == -1 && arr[bx][by][1].cnt != -1)
            			max = arr[bx][by][1].num + arr[ax][ay][0].num;
            		else if(arr[ax][ay][1].cnt != -1 && arr[bx][by][1].cnt == -1)
            			max = arr[ax][ay][1].num + arr[bx][by][0].num;
            		else
            			max = Math.max(arr[ax][ay][0].num+arr[bx][by][1].num, arr[ax][ay][1].num+arr[bx][by][0].num);
            	}
        		else
        			max = arr[ax][ay][0].num + arr[bx][by][0].num;
        		
        		res += max;
        	}
        	System.out.println("#" + test_case + " " + res);
        }
	}
}
class Pair implements Comparable<Pair>{
	int cnt, num;
	Pair(int cnt, int num)
	{
		this.cnt = cnt;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? 1 : -1;
	}
}