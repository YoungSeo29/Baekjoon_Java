package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {
    static ArrayList<Integer>[] A;
    static boolean visited[];  // 방문 여부 배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        // 인접 리스트 초기화 하기
        for(int i=1 ; i< n+1 ; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        // DFS 함수 호출 횟수 저장할 변수
        int count = 0;

        for( int i=1 ; i< n +1 ; i++) {
            if(!visited[i]) {  // 아직 방문하지 않은 정점이라면
                count ++;
                DFS(i);  // 새로운 연결 요소의 시작 정점에서만 호출하는 중
            }
        }

        System.out.println(count);

    }


    // DFS 탐색 함수
    static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : A[v]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }
    }
}