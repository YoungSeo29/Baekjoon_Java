package 자료구조;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최솟값찾기 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        Deque<Node> mydeque = new LinkedList<>();

        for(int i=0 ; i<N ; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(now, i));

            if(mydeque.getFirst().index <= i-L) {
                mydeque.removeFirst();
            }

            bw.write(mydeque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();

    }

    static class Node {

        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;

        }
    }

}
