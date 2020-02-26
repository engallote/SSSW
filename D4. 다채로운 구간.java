import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	int N = sc.nextInt();
        	int K = sc.nextInt();
        	long res = 0;
        	int[] arr = new int[N], chk = new int[K+1];
        	HashSet<Integer> hs = new HashSet<>();
        	int sidx = 1, eidx = -1, pre = -1;
        	
        	for(int i = 0; i < N; i++){
        		arr[i] = sc.nextInt();
        		hs.add(arr[i]);
        		if(hs.size() <= K && eidx == -1){
        			chk[arr[i]] += 1;
        			if(hs.size() == K) eidx = i;
        		}
        	}
        	
        	if(eidx != -1){//1~K까지 다 있다
        		res += N - eidx;
        		chk[arr[0]] -= 1;
        		
        		if(chk[arr[0]] == 0) 
        			pre = arr[0];
        	}
        	else{//뭔가가 없다
        		System.out.println("#" + test_case + " 0");
        		continue;
        	}
        	
        	while(sidx <= N - K){
        		while(eidx - sidx + 1 < K && eidx < N){
    				++eidx;
    				if(eidx < N) chk[arr[eidx]] += 1;
    			}
        		if(pre == -1){
        			res += N - eidx;
        			chk[arr[sidx]] -= 1;
        			
            		if(chk[arr[sidx]] == 0) pre = arr[sidx];
            		else pre = -1;
        		}
        		else{
        			while(eidx < N && arr[eidx] != pre){
        				++eidx;
        				if(eidx < N) chk[arr[eidx]] += 1;
        			}

        			if(chk[pre] == 0) break;
        			
        			res += N - eidx;
        			chk[arr[sidx]] -= 1;
        			
            		if(chk[arr[sidx]] == 0) pre = arr[sidx];
            		else pre = -1;
        		}
        		++sidx;
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}