package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        stringTokenizer = new StringTokenizer(bf.readLine());
        S[0] = Long.parseLong(stringTokenizer.nextToken());

        // 합 배열 입력받기
        for(int i=1 ; i<N ; i++){
            S[i] = S[i-1] + Long.parseLong(stringTokenizer.nextToken());
        }

        // 합 배열 업데이트
        for(int i = 0 ; i<N ; i++) {
            int remainder = (int) (S[i] % M);

            if(remainder == 0) answer ++;
            C[remainder]++;

        }

        for(int i=0 ; i<M ; i++){
            if(C[i] > 1) {
                answer = answer + ( C[i] * (C[i]-1) /2 );
            }
        }

        System.out.println(answer);
    }
}
