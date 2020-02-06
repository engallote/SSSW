import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			arr = new int[N];
			Random rd = new Random();
			for(int i = 0; i < N; i++){
//				arr[i] = rd.nextInt(100);
				arr[i] = sc.nextInt();
//				System.out.print(arr[i] + " ");
			}
//			System.out.println();
			if(N == 1){
				System.out.println("#" + test_case + " 1");
				continue;
			}
			
			int res = find();
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static int find() {
		int cnt = 1;
		boolean plus = false, minus = false, same = false;
		if(arr[0] == arr[1]) same = true;
		else if(arr[0] < arr[1]) plus = true;
		else minus = true;
		
		for(int i = 1; i < N; i++){
			if(arr[i] == arr[i-1]) same = true;
			else if(arr[i] > arr[i-1]){
				if(!minus && (plus || same)){
					plus = true;
					same = false;
				}
				else{
					same = false;
					plus = false;
					minus = false;
					++cnt;
					if(i + 1 < N){
						if(arr[i] < arr[i+1]) plus = true;
						else if(arr[i] > arr[i+1]) minus = true;
						else same = true;
					}
				}
			}
			else{
				if(!plus && (minus || same)){
					minus = true;
					same = false;
				}
				else{
					same = false;
					minus = false;
					plus = false;
					++cnt;
					if(i + 1 < N){
						if(arr[i] < arr[i+1]) plus = true;
						else if(arr[i] > arr[i+1]) minus = true;
						else same = true;
					}
				}
			}
		}
		
		return cnt;
	}
}