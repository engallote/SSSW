import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int num = sc.nextInt();
			int f = num / 100;
			int s = num % 100;
			boolean ym = false, my = false;
			
			if(f <= 12 && f >= 1){//year first or month first?
				if(1 <= s && s <= 12){
					my = true;
					ym = true;
				}
				else my = true;
			}
			else{//year
				if(1 <= s && s <= 12) ym = true;
			}
			
			if(ym && my) System.out.println("#" + test_case + " AMBIGUOUS");
			else if(ym) System.out.println("#" + test_case + " YYMM");
			else if(my) System.out.println("#" + test_case + " MMYY");
			else System.out.println("#" + test_case + " NA");
		}
	}
}