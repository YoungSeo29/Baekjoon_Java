package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내림차순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int[] A = new int[str.length()];

        for(int i=0 ; i< str.length() ; i++) {
            A[i] = str.charAt(i) - '0';  // 문자를 숫자로 변환해서 배열에 넣기
        }

        // 선택 정렬 (내림차순)
        for(int i=0 ; i< A.length ; i++) {
            int Max = i;
            for(int j=i+1 ; j<A.length ; j++) {
                if(A[j] > A[Max])
                    Max = j;
            }
            if(A[i] < A[Max]) {  // swap
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for(int i=0 ; i<A.length ; i++) {
            System.out.println(A[i]);
        }
    }
}
