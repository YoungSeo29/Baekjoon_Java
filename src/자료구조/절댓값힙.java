package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 우선순위 큐 정렬 기준
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs)  // 절댓값 같으면 작은 숫자에 우선순위를 줌.
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(bf.readLine());
            if (request == 0) {
                if (myQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQueue.poll());  // 절댓값 가장 작은 수 출력 및 제거
            } else {
                myQueue.add(request);
            }
        }
    }
}
