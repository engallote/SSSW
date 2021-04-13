import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
    	for(int tesct_case = 1; tesct_case <= T; tesct_case++) {
    		int N = sc.nextInt();
    		char[][] map = new char[N][N];
    		boolean res = false;
    		
    		for(int i = 0; i < N; i++)
    			map[i] = sc.next().toCharArray();
    		
    		loop:for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				if(map[i][j] == 'o') {
    					for(int d = 0; d < 8; d++) {
    						for(int k = 1; k < 5; k++) {
    							int nx = i + dx[d] * k, ny = j + dy[d] * k;
        						if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '.') break;
        						if(k == 4) {
        							res = true;
        							break loop;
        						}
    						}
    					}
    				}
    		
    		System.out.println("#" + tesct_case + " " + (res ? "YES" : "NO"));
    	}
    }
}