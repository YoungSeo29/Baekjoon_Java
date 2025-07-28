package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        // 배열 입력받기
        for(int i=0 ; i<N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);

        System.out.println(A[K-1]);  // K번째 수 출력
    }

    public static void quickSort(int[] A, int S, int E, int K) {  // 재귀
        if(S < E) {
            int pivot = partition(A,S,E);
            if(pivot == K)  // 찾았으니 바로 return
                return;
            else if (K < pivot)  // 왼쪽 그룹만 정렬 수행
                quickSort(A, S, pivot-1, K);
            else  // 오른쪽 그룹만 정렬 수행
                quickSort(A, pivot + 1, E, K);
        }
    }

    // pivot 기준 배열을 나누고, 피벗 들어갈 위치 반환.
    public static int partition(int[] A, int S, int E) {
        if(S + 1 == E) {  // 이웃한 애들
            if(A[S] > A[E]) swap(A,S,E);
            return E;
        }

        int M = (S+E)/2;
        swap(A,S,M);  // 중앙값 & 맨 앞값 위치 바꾸기
        int pivot = A[S];  // 그게 pivot
        int i = S + 1;
        int j = E;

        while(i <= j) {
            while(j >= S && pivot < A[j]) {  // pivot보다 작은 수가 나올 때까지 j--
                j--;
            }
            while(i <= E && pivot > A[i]) {  // pivot보다 큰 수가 나올 때까지 i++
                i++;
            }

            if(i <= j) {
                swap(A, i++, j--);
            }
        }

        // 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}

