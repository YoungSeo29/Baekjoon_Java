package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        // N개의 재료 입력받기
        for(int i=0; i<N ; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N-1;

        while (i < j) {
            if(A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

        bf.close();

    }
}
