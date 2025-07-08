package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());  // 임의 DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());  // 부분 문자열 길이
        int answer = 0;  // 결과

        char A[] = new char[S];  // 문자열 데이터 담기
        checkArr = new int[4];  // 조건 배열
        myArr = new int[4];  // 현재 상태 배열 (각 문자 몇개 있는지)
        checkSecret = 0;

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<4 ; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());  // 조건 배열 하나씩 입력받기
            if(checkArr[i] == 0) checkSecret++;  // 0개 이상이면 된다 = 무조건 조건 만족했다는 뜻
        }

        // 처음 P개
        for(int i=0 ; i<P ; i++) {
            Add(A[i]);
        }

        if(checkSecret == 4) {
            answer++;
        }

        // 슬라이딩
        for(int i=P; i<S ; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) {
                answer++;
            }
        }

        System.out.println(answer);
        bf.close();



    }

    // 새로 들어온 문자 처리
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
        }
    }

    // 제거되는 문자 처리
    private static void Remove(char c) {
        switch (c){
            case 'A' :
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
