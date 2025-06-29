package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());  // 배열 크기
        int quizNum = Integer.parseInt(stringTokenizer.nextToken());  // 질문 갯수

        // N*N 크기의 배열 입력받기
        int A[][] = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1 ; j <= N ; j++){
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 구간합 구해놓기
        int D[][] = new int[N+1][N+1];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                D[i][j] = D[i][j-1] + D[i-1][j] -D[i-1][j-1] + A[i][j];
            }
        }

        for(int i = 0 ; i<quizNum ; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);

        }

    }
}
