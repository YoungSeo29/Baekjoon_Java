package 자료구조;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> myQueue = new LinkedList<>();

        // 큐에 숫자 저장하기
        for(int i=1 ; i<=N ; i++) {
            myQueue.add(i);
        }

        // 카드 1장 남을 때까지
        while(myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());   // 맨 위 카드 맨 아래로 이동
        }

        System.out.println(myQueue.poll());

    }
}
