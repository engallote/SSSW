import java.util.*;

public class Solution{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	HashMap<Character, Integer> hm = new HashMap<>();
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		char[] ch = sc.next().toCharArray();
    		hm.clear();
    		
    		for(int i = 0; i < ch.length; i++) {
    			if(hm.containsKey(ch[i])) hm.replace(ch[i], hm.get(ch[i]) + 1);
    			else hm.put(ch[i], 1);
    		}
    		
    		System.out.print("#" + test_case + " ");
    		if(hm.size() == 2) {
    			boolean flag = true;
    			Iterator<Character> it = hm.keySet().iterator();
    			while(it.hasNext()) {
    				char key = it.next();
    				int value = hm.get(key);
    				
    				if(value != 2) {
    					flag = false;
    					break;
    				}
    			}
    			
    			if(flag) System.out.println("Yes");
    			else System.out.println("No");
    		}
    		else System.out.println("No");
    	}
	}
}