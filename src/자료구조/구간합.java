package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());  // 데이터 갯수
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());  // 질문 갯수

        long[] S = new long[suNo + 1];

        // 구간합 구해놓기
        stringTokenizer = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=suNo ; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 질문 갯수만큼 반복
        for(int q=0 ; q<quizNo ; q++){
            stringTokenizer = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j]-S[i-1]);  // 구간합 출력
        }
    }
}
