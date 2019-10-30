import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	long res = -1;
        	int D = sc.nextInt();
        	int H = sc.nextInt();
        	int M = sc.nextInt();
        	
        	if(D < 11 || (D == 11 && H < 11) || (D == 11 && H == 11 && M < 11))
        		System.out.println("#" + test_case + " " + res);
        	else if(D == 11 && H == 11 && M == 11)
        		System.out.println("#" + test_case + " 0");
        	else
        	{
        		long tmp = D - 11;
        		tmp *= (24 * 60);
        		tmp += (H - 11) * 60;
        		tmp += (M - 11);
        		res = tmp;
        		System.out.println("#" + test_case + " " + res);
        	}
        }
	}
}