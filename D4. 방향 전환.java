import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        int[][][] chk = new int[201][201][2];
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;
             
             
            for(int i = 0; i <= 200; i++)
                for(int j = 0; j <= 200; j++)
                    Arrays.fill(chk[i][j], 100000000);
             
            Queue<Pair> q = new LinkedList<Pair>();
            q.offer(new Pair(x1, y1, 0));
            q.offer(new Pair(x1, y1, 1));
            chk[x1][y1][0] = chk[x1][y1][1] = 0;
             
            int size = 0, res = -1;
            while(!q.isEmpty())
            {
                size = q.size();
                 
                while(size > 0)
                {
                    size--;
                    Pair p = q.poll();
//                  System.out.println(p.x + " " + p.y + " " + p.d);
                    if(p.x == x2 && p.y == y2) 
                    {
                        continue;
//                      res = time;
//                      q.clear();
//                      break;
                    }
                     
                    for(int i = 0; i < 4; i++)
                    {
                        if(p.d == 0 && i >= 2)//가로->세로
                        {
                            int nx = p.x + dx[i], ny = p.y + dy[i];
                            if(nx < 0 || ny < 0 || nx > 200 || ny > 200 || chk[nx][ny][1] <= chk[p.x][p.y][p.d] + 1)
                                continue;
                            chk[nx][ny][1] = chk[p.x][p.y][p.d] + 1;
                            q.offer(new Pair(nx, ny, 1));
                        }
                        else if(p.d == 1 && i < 2)//세로->가로
                        {
                            int nx = p.x + dx[i], ny = p.y + dy[i];
                            if(nx < 0 || ny < 0 || nx > 200 || ny > 200 || chk[nx][ny][0] <= chk[p.x][p.y][p.d] + 1)
                                continue;
                            chk[nx][ny][0] = chk[p.x][p.y][p.d] + 1;
                            q.offer(new Pair(nx, ny, 0));
                        }
                    }
                }
//              if(res != -1) break;
            }
             
            System.out.println("#" + test_case + " " + Math.min(chk[x2][y2][0], chk[x2][y2][1]));
        }
    }
}
class Pair{
    int x, y, d;
    Pair(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
