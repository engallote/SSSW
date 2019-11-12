import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	double D = sc.nextDouble();
        	double A = sc.nextDouble();
        	double B = sc.nextDouble();
        	double F = sc.nextDouble();
        	
        	double res = F * (D / (A + B));
        	System.out.println("#" + test_case + " " + res);
        }
    }
}