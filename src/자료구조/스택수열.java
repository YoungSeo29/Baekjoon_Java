package 자료구조;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0 ; i<N ; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();  // 문자열 조작에 용이한 StringBuffer 사용

        int num = 1;  // 오름차순 수
        boolean result = true;  // 수열 만들 수 있는지 없는지 여부.

        for(int i=0 ; i<A.length ;i++) {
            int su = A[i];  // 현재 수열의 수

            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);  // 현재 num을 스택에 넣고, 그 다음 num 1 증가
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();

                if(n>su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if(result) System.out.println(bf.toString());

    }
}
