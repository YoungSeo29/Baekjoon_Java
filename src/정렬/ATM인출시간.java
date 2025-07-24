package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM인출시간 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        int[] S = new int[N];
        for(int i=0 ; i<N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for(int i=1 ; i<N ; i++) {
            int insert_point = i;
            int insert_value = A[i];
            for(int j=i-1; j>=0 ; j--) {
                if(A[j] < A[i]) {
                    insert_point = j+1;
                    break;
                }
                if(j==0) {
                    insert_point = 0;
                }
            }
            // insert_point 위치까지 값들 한칸씩 뒤로 밀어서 공간 확보
            for(int j=i ; j>insert_point; j--) {
                A[j] = A[j-1];
            }
            A[insert_point] = insert_value;  // 해당 위치에 삽입
        }

        // 합배열 만들기
        S[0] = A[0];
        for(int i=1 ; i<N ; i++) {
            S[i] = S[i-1] + A[i];
        }

        // 합배열 총합
        int sum = 0;
        for(int i=0 ; i<N ; i++) {
            sum = sum + S[i];
        }

        System.out.println(sum);

    }
}
