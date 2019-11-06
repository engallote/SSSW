import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	int C = sc.nextInt();
        	
        	res = Math.max(C / A + (C % A) / B, C / B + (C % B) / A);
        	res = Math.max(res, Math.min(C / (A + B) + (C % (A + B)) / A, C / (A + B) + (C % (A + B)) / B));
        	System.out.println("#" + test_case + " " + res);
        }
    }
}