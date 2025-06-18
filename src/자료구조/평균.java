package 자료구조;

import java.util.Scanner;

public class 평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int scores[] = new int[N];

        // 점수 입력받기
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if(scores[i] > max) max = scores[i];
            sum += scores[i];
        }

        System.out.println(sum*100 / max / N);

    }
}
