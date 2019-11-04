import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        double A, B, C, D;
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	A = sc.nextDouble();
        	B = sc.nextDouble();
        	C = sc.nextDouble();
        	D = sc.nextDouble();
        	
        	double alice = A / B;
        	double bob = C / D;
        	
        	if(alice > bob)
        		System.out.println("#" + test_case + " ALICE");
        	if(alice < bob)
        		System.out.println("#" + test_case + " BOB");
        	else if(alice == bob)
        		System.out.println("#" + test_case + " DRAW");
        	
        }
	}
}