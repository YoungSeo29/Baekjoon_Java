package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        long[] A = new long[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        // 배열 입력받기
        for(int i=0 ; i<N ; i++){
            A[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        // 정렬
        Arrays.sort(A);

        for(int k = 0; k < N; k++){
            // 변수들 초기화
            long find = A[k];
            int i=0;
            int j=N-1;

            while (i<j) {
                if(A[i] + A[j] == find) {
                    // 본인이 포함되지 않았는지 확인
                    if(i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(count);
        bf.close();

    }
}
