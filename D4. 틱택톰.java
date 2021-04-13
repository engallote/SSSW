import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tesct_case = 1; tesct_case <= T; tesct_case++) {
    		char[][] map = new char[4][4];
    		int dot = 0;
    		for(int i = 0; i < 4; i++) {
    			map[i] = sc.next().toCharArray();
    			for(int j = 0; j < 4; j++)
    				if(map[i][j] == '.') ++dot;
    		}
    		
    		boolean X = false, O = false;
    		for(int i = 0; i < 4; i++) {
    			int rx = 0, ro = 0, rt = 0, cx = 0, co = 0, ct = 0;
    			for(int j = 0; j < 4; j++) {
    				//행 검사
    				if(map[i][j] == 'X') ++rx;
    				else if(map[i][j] == 'O') ++ro;
    				else if(map[i][j] == 'T') ++rt;
    				
    				//열 검사
    				if(map[j][i] == 'X') ++ cx;
    				else if(map[j][i] == 'O') ++co;
    				else if(map[j][i] == 'T') ++ct;
    			}
    			
    			if(rx == 4 || (rx == 3 && rt == 1) || cx == 4 || (cx == 3 && ct == 1)) X = true;
    			if(ro == 4 || (ro == 3 && rt == 1) || co == 4 || (co == 3 && ct == 1)) O = true;
    		}
    		
    		int dx1 = 0, dx2 = 0, do1 = 0, do2 = 0, dt1 = 0, dt2 = 0;
    		for(int i = 0; i < 4; i++) {
    			if(map[i][i] == 'X') ++dx1;
    			else if(map[i][i] == 'O') ++do1;
    			else if(map[i][i] == 'T') ++dt1;
    			
    			if(map[i][4 - i - 1] == 'X') ++dx2;
    			else if(map[i][4 - i - 1] == 'O') ++do2;
    			else if(map[i][4 - i - 1] == 'T') ++dt2;
    		}
    		
    		if(dx1 == 4 || dx2 == 4 || (dx1 == 3 && dt1 == 1) || (dx2 == 3 && dt2 == 1)) X = true;
    		if(do1 == 4 || do2 == 4 || (dt1 == 1 && do1 == 3) || (dt2 == 1 && do2 == 3)) O = true;
    		
    		System.out.print("#" + tesct_case + " ");
    		
    		if(X && O) System.out.println("Draw");
    		else if(X) System.out.println("X won");
    		else if(O) System.out.println("O won");
    		else if(dot == 0) System.out.println("Draw");
    		else System.out.println("Game has not completed");
    	}
    }
}