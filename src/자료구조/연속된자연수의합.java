package 자료구조;

import java.io.IOException;
import java.util.Scanner;

public class 연속된자연수의합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int left_index = 0;
        int right_index = 0;
        int sum = 0;

        while(right_index != N) {
            if(sum == N) {
                count ++;
                right_index++;
                sum += right_index;
            } else if(sum > N) {
                left_index++;
                sum = sum - left_index;
            } else {
                right_index++;
                sum += right_index;
            }
            System.out.println("left : " + left_index + " right : " + right_index + " sum : " + sum + " count : " + count);
        }

        System.out.println(count);

    }
}
