import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		int c1 = sc.nextInt();//cow
    		int c2 = sc.nextInt();//horse
    		int[] cow = new int[N];
    		
    		for(int i = 0; i < N; i++) 
    			cow[i] = sc.nextInt();
    		
    		Arrays.sort(cow);
    		
    		int res = Integer.MAX_VALUE, cnt = 0;
    		for(int i = 0; i < M; i++) {
    			int horse = sc.nextInt();
    			int l = 0, r = N - 1, mid = 0, idx = -1;
        		while(l <= r) {
        			mid = (l + r) / 2;
        			
        			if(cow[mid] == horse) {
        				idx = mid;
        				break;
        			}
        			else if(cow[mid] > horse) r = mid - 1;
        			else l = mid + 1;
        		}
        		
        		if(cow[mid] < horse) idx = mid + 1;
        		else idx = mid;
        		
        		if(0 <= idx && idx < N && res > Math.abs(cow[idx] - horse)) {
        			res = Math.abs(cow[idx] - horse);
        			cnt = 1;
        		}
        		else if(0 <= idx && idx < N && res == Math.abs(cow[idx] - horse)) ++cnt;
        		
        		if(idx - 1 < 0) continue;
        		if(res > Math.abs(cow[idx - 1] - horse)) {
        			res = Math.abs(cow[idx - 1] - horse);
        			cnt = 1;
        		}
        		else if(res == Math.abs(cow[idx - 1] - horse)) ++cnt;
    		}
    		
    		res += Math.abs(c1 - c2);
    		System.out.println("#" + test_case + " " + res + " " + cnt);
    	}
    }
}