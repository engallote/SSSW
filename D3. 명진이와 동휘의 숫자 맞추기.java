import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	int N = sc.nextInt();
        	int[] chk = new int[10];
        	int res = 0, max = Integer.MIN_VALUE;
        	
        	while(--N >= 0){
        		q.clear();
        		for(int i = 0; i < 4; i++) q.offer(sc.nextInt());
        		
        		String str = sc.next();
        		
        		if(str.equals("YES")){
        			while(!q.isEmpty()) 
        				chk[q.poll()]+=1;
        		}
        		else{
        			while(!q.isEmpty()) 
        				chk[q.poll()] -=1;
        		}
        	}
        	
        	for(int i = 0; i < 10; i++)
        		if(max < chk[i]){
        			res = i;
        			max = chk[i];
        		}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}