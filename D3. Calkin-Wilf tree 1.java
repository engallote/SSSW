import java.util.*;

public class Solution{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		char[] ch = sc.next().toCharArray();
    		int a = 1, b = 1;
    		
    		for(char c : ch) {
    			if(c == 'L') b += a;
    			else a += b;
    		}
    		
    		System.out.println("#" + test_case + " " + a + " " + b);
    	}
    }
}