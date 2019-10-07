import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	static ArrayList<Pair>[] hall;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	hall = new ArrayList[11];
        	arr = new int[N][N];
        	Queue<Pair> start = new LinkedList<>();
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            	{
            		arr[i][j] = sc.nextInt();
            		if(arr[i][j] >= 6)//¿úÈ¦
            		{
            			if(hall[arr[i][j]] == null) hall[arr[i][j]] = new ArrayList<>();
            			hall[arr[i][j]].add(new Pair(i, j));
            		}
            		else if(arr[i][j] == 0) start.add(new Pair(i, j));
            	}
            res = 0;
            while(!start.isEmpty())
            {
            	Pair p = start.poll();
            	
            	for(int i = 0; i < 4; i++)
            		res = Math.max(res, game(p.x, p.y, i));
            	
            }
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static int game(int sx, int sy, int t) {
		int sum = 0, d = t;
		int x = sx, y = sy;
//		System.out.println("start!!!");
		while(true)
		{
			x += dx[d];
			y += dy[d];
//			System.out.println(x + " " + y);
			if(x < 0 || y < 0 || x >= N || y >= N)//º®¿¡ ºÎµúÈû
			{
				d = (d + 2) % 4;
				sum++;
			}
			else if(arr[x][y] == -1 || (x == sx && y == sy)) break;
			else if(arr[x][y] >= 6 && arr[x][y] <= 10)//¿úÈ¦
			{
				int num = arr[x][y];
				if(hall[num].get(0).x == x && hall[num].get(0).y == y)
				{
					x = hall[num].get(1).x;
					y = hall[num].get(1).y;
				}
				else
				{
					x = hall[num].get(0).x;
					y = hall[num].get(0).y;
				}
			}
			else if(arr[x][y] >= 1 && arr[x][y] <= 5)//ºí·Ï
			{
				sum++;
				switch(arr[x][y]){
				case 1:
					if(d == 0)//ÁøÇà¹æÇâÀÌ ¾Æ·¡
						d++;
					else if(d == 1)//¿À¸¥ÂÊ
						d = 3;
					else if(d == 2)//À§ÂÊ
						d = 0;
					else d = 2;//¿ÞÂÊ
					break;
				case 2:
					if(d == 0) d = 2;
					else if(d == 1) d = 3;
					else if(d == 2) d = 1;
					else d = 0;
					break;
				case 3:
					if(d == 0) d = 2;
					else if(d == 1) d = 0;
					else if(d == 2) d = 3;
					else d = 1;
					break;
				case 4:
					if(d == 0) d = 3;
					else if(d == 1) d = 2;
					else if(d == 2) d = 0;
					else d = 1;
					break;
				case 5:
					d = (d + 2) % 4;
					break;
				}
			}
		}
		return sum;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}