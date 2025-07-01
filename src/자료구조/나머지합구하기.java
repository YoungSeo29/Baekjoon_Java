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

        int[] S = new int[N];
        stringTokenizer = new StringTokenizer(bf.readLine());
        S[0] = Integer.parseInt(stringTokenizer.nextToken());

        // 합 배열 입력받기
        for(int i=1 ; i<N ; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] C = new int[N];
        int answer = 0;
        // 합 배열 업데이트
        for(int i = 0 ; i<N ; i++) {
            int remainder = (S[i] % M);

            if(remainder == 0) answer ++;
            C[remainder]++;

        }

        for(int i=0 ; i<M ; i++){
            if(C[i] > 0) {
                answer = answer + ( C[i] * (C[i]-1) /2 );
            }
        }

        System.out.println(answer);
    }
}
