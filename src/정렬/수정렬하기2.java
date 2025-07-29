package 정렬;

import java.io.*;

public class 수정렬하기2 {

    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];

        for(int i=1 ; i<= N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 병합 정렬 수행
        merge_sort(1, N);

        for(int i=1 ; i<= N ; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    // s ~ e 구간을 정렬하는 재귀함수.
    // 구간을 반으로 나눈 뒤 (s~m, m+1~e), 두 구간 병합.
    public static void merge_sort(int s, int e) {

        // 원소가 1개 -> 정렬 필요 X, 바로 return
        if (e - s <1)
            return;

        // 구간을 반으로 쪼갬.
        int m = s + (e - s) / 2;  //5

        merge_sort(s, m);       // 왼쪽 구간 재귀 정렬
        merge_sort(m+1, e);  // 오른쪽 구간 재귀 정렬

        // A의 현재 정렬 범위를 tmp에 복사.
        for (int i=s ; i <= e ; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;

        // 두 그룹을 하나로 병합.
        // 더 작은 값을 A[k]에 저장하고, 그 그룹 포인터 전진.
        while(index1 <= m && index2 <= e) {  // 둘 다 비교 가능한 값이 남아있을 때 진행.
            if(tmp[index1] > tmp[index2]) {  // 작은 값을 A[k] 넣음.
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            A[k]= tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
