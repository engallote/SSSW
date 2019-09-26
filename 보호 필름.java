import java.util.*;
 
public class Main {
    static int N, M, K, res;
    static int[][] arr, tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int test_case = 1; test_case <= tc; test_case++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            res = Integer.MAX_VALUE;
            arr = new int[N][M];
            tmp = new int[N][M];
             
            for(int i = 0; i < N; i++)
                for(int j = 0; j < M; j++)
                {
                    arr[i][j] = sc.nextInt();
                    tmp[i][j] = arr[i][j];
                }
             
            if(ok(arr))
            {
                System.out.println("#" + test_case + " 0");
                continue;
            }
             
            solve(0, 0);
             
            System.out.println("#" + test_case + " " + res);
        }
    }
    private static void solve(int idx, int cnt) {
        if(ok(tmp))
        {
            res = Math.min(res, cnt);
            return;
        }
        if(idx == N) return;
         
        solve(idx + 1, cnt);
         
        Arrays.fill(tmp[idx], 0);
        solve(idx + 1, cnt + 1);
        Arrays.fill(tmp[idx], 1);
        solve(idx + 1, cnt + 1);
        for(int i = 0; i < M; i++)
            tmp[idx][i] = arr[idx][i];
    }
    private static boolean ok(int[][] map) {
        boolean flag = false;
        for(int j = 0; j < M; j++)
        {
            flag = false;
            int cnt = 0, pre = -1;
            for(int i = 0; i < N; i++)
            {
                if(pre == map[i][j])
                    cnt++;
                else
                {
                    if(cnt >= K)
                    {
                        flag = true;
                        break;
                    }
                    cnt = 1;
                    pre = map[i][j];
                }
            }
            if(cnt >= K) flag = true;
            if(!flag) return false;
        }
        return true;
    }
}
