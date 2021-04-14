import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		char[][] map = new char[N][M];
    		int[][] chk = new int[N][M];
    		Queue<Pair> water = new LinkedList<Pair>();
    		
    		for(int i = 0; i < N; i++) {
    			map[i] = sc.next().toCharArray();
    			Arrays.fill(chk[i], 100000000);
    			for(int j = 0; j < M; j++)
    				if(map[i][j] == 'W') {
    					water.offer(new Pair(i, j));
    					chk[i][j] = 0;
    				}
    		}
    		
    		int size, res = 0;
    		while(!water.isEmpty()) {
    			size = water.size();
    			while(--size >= 0) {
    				Pair p = water.poll();
    				
    				for(int i = 0; i < 4; i++) {
    					int nx = p.x + dx[i], ny = p.y + dy[i];
    					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] <= chk[p.x][p.y] + 1) continue;
    					chk[nx][ny] = chk[p.x][p.y] + 1;
    					water.offer(new Pair(nx, ny));
    				}
    			}
    		}
    		
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < M; j++)
    				res += chk[i][j];
    		
    		System.out.println("#" + test_case + " " + res);
    	}
    }
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}