import java.util.Scanner;

public class Main {

    static long findMaxAlternatingSum(int[] arr, int K) {
        int n = arr.length;
        if (n < K) {
            return -1;
        }
        long currs = 0;
        for (int i = 0; i < K; i++) {
            currs += arr[i];
        }
        if (K == 1) {
            return currs;
        }
        boolean[] vali0 = new boolean[n - 1];
        boolean[] vali1 = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            vali0[i] = (arr[i] > arr[i + 1]);
            vali1[i] = (arr[i] < arr[i + 1]);
        }
        int[] d0 = new int[n - 1];
        int[] d1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                d0[i] = vali0[i] ? 1 : 0;
                d1[i] = vali1[i] ? 1 : 0;
            } else {
                d0[i] = vali1[i] ? 1 : 0;
                d1[i] = vali0[i] ? 1 : 0;
            }
        }
        int[] pre0 = new int[n - 1];
        int[] pre1 = new int[n - 1];
        if (n - 1 > 0) {
            pre0[0] = d0[0];
            pre1[0] = d1[0];
            for (int i = 1; i < n - 1; i++) {
                pre0[i] = pre0[i - 1] + d0[i];
                pre1[i] = pre1[i - 1] + d1[i];
            }
        }
        long ms = Long.MIN_VALUE;
        boolean gotit = false;
        for (int s = 0; s <= n - K; s++) {
            if (K > 1) {
                int l = s;
                int r = s + K - 2;
                int tot;
                if (s % 2 == 0) {
                    tot = getSum(pre0, l, r);
                } else {
                    tot = getSum(pre1, l, r);
                }
                if (tot == K - 1) {
                    gotit = true;
                    if (currs > ms) {
                        ms = currs;
                    }
                }
            }
            if (s < n - K) {
                currs = currs - arr[s] + arr[s + K];
            }
        }
        if (gotit) {
            return (int) ms;
        } else {
            return -1;
        }
    }

    private static int getSum(int[] pre, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == 0) {
            return pre[r];
        } else {
            return pre[r] - pre[l - 1];
        }
    }
}
