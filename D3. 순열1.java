import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	int N = sc.nextInt();
        	int[] arr = new int[N+1];
        	for(int i = 0; i < N; i++)
        		++arr[sc.nextInt()];
        	
        	boolean flag = true;
        	for(int i = 1; i <= N; i++)
        		if(arr[i] != 1){
        			flag = false;
        			break;
        		}
        	
        	System.out.print("#" + test_case + " ");
        	if(flag) System.out.println("Yes");
        	else System.out.println("No");
        }
    }
}