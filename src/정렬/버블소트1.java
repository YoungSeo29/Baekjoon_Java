package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        mData[] A = new mData[N];

        // 배열에 넣기
        for(int i=0 ; i<N ; i++) {
            A[i] = new mData(Integer.parseInt(bf.readLine()), i);
        }

        // 정렬하기
        Arrays.sort(A);

        int Max = 0;

        // 정렬 후 왼쪽으로 얼마나 이동했는지.
        for(int i=0 ; i<N ; i++) {
            if(Max < A[i].index-1)
                Max = A[i].index - i;
        }

        // 이동한 칸 수 + 1 해야 반복 횟수 알 수 있음.
        System.out.println(Max + 1);

    }
}


// 사용자 정의. value와 index 두 가지 저장.
class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value -o.value;
    }
}
