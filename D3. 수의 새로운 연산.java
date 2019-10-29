import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[][] arr = new int[300][300];
        Pair[] where = new Pair[1000001];
        int y = 1, cnt = 1;
        while(y < 300)
        {
        	int nx = 1, ny = y;
        	while(nx <= y && ny >= 1)
        	{
//        		if(nx <= 4)
//        			System.out.println(nx + " " + ny + " : " + cnt);
        		where[cnt] = new Pair(nx, ny);
        		arr[nx][ny] = cnt;
        		cnt++;
        		nx++;
        		ny--;
        	}
        	y++;
        }
        
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int res = 0;
        	int x1 = where[N].x, x2 = where[M].x, y1 = where[N].y, y2 = where[M].y;
//        	System.out.println(x1 + " " + y1 + " , " + x2 + " " + y2);
        	res = arr[x1 + x2][y1 + y2];
        	System.out.println("#" + test_case + " " + res);
        }
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