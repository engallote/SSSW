import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, max, res;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[] chk;
	static boolean[][] check, visit;
	static Vector<Pair> v;
	public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N][N];
        	check = new boolean[N][N];
        	StringTokenizer st;
        	for(int i = 0; i < N; i++)
        	{
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++)
        			arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        	v = new Vector<>();
        	
        	for(int i = 0; i < N; i++)
        	{
        		for(int j = 0; j < N; j++)
        		{
        			int sum = 0;
        			for(int k = 0; k < 4; k++)
        			{
        				int nx = i + dx[k], ny = j + dy[k];
        				while(nx >= 0 && nx < N && ny >= 0 && ny < N)
        				{
        					sum += arr[nx][ny];
        					nx += dx[k];
        					ny += dy[k];
        				}
        			}
        			v.add(new Pair(i, j, sum));
        		}
        	}
        	v.sort(null);
        	if(v.size() > 66)
        		while(v.size() > 66)
        			v.remove(v.size()-1);
        	chk = new boolean[v.size()];
//        	for(Pair p : v)
//        		System.out.println("> " + p.x + " " + p.y + " " + p.sum);
        	Vector<Pair> pp = new Vector<>();
        	solve(0, pp);
        	bw.write("#" + test_case + " " + res + "\n");
        }
        bw.flush();
    }
	private static void solve(int num, Vector<Pair> pp) {
		if(num == 2)
		{
			visit = new boolean[N][N];
			int sum = 0;
			for(int i = 0; i < 2; i++)
			{
				Pair p = pp.get(i);
//				System.out.println(p.x + " " + p.y + " " + p.sum);
				sum += p.sum;
				for(int j = 0; j < 4; j++)
				{
					int nx = p.x + dx[j], ny = p.y + dy[j];
					while(nx >= 0 && nx < N && ny >= 0 && ny < N)
					{
						if(visit[nx][ny] || check[nx][ny])
						{
							sum -= arr[nx][ny];
//							System.out.println(nx + " " + ny + " -" + arr[nx][ny]);
						}
						visit[nx][ny] = true;
						nx += dx[j];
						ny += dy[j];
					}
				}
			}
//			System.out.println("-------------");
//			System.out.println(">>> " + sum);
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = 0; i < v.size(); i++)
		{
			if(!chk[i])
			{
				chk[i] = true;
				pp.addElement(v.get(i));
				check[v.get(i).x][v.get(i).y] = true;
				solve(num + 1, pp);
				pp.remove(pp.size()-1);
				check[v.get(i).x][v.get(i).y] = false;
				chk[i] = false;
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, sum;
	Pair(int x, int y, int sum)
	{
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
	@Override
	public int compareTo(Pair o) {
		return o.sum > this.sum ? 1 : -1;
	}
}