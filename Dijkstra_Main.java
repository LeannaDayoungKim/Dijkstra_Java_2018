//1515009 Dayoung Kim
import java.util.PriorityQueue;
import java.util.Scanner;
public class Dijkstra_Main {
public static int dist[];//최소비용
public static int n,m;
public static int weight[][];//가중치
public static final int INF = 1000000000;//무한대 값

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int i,j,start,dest; 
n = sc.nextInt();
weight = new int [n+1][n+1];
dist= new int [n+1];//배열 생성

for(i=1;i<=n;i++) {
dist[i]=INF;
for(j=1;j<=n;j++)
weight[i][j]=INF;
}//초기화

m = sc.nextInt();
int a,b,c;
for(i=0;i<m;i++) {
a= sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
if(weight[a][b]>c)
weight[a][b]= c;
}//가중치 설정

start = sc.nextInt();
dest = sc.nextInt();
dijkstra(start);//시작점에 대한 다익스트라 알고리즘 실행
System.out.println(dist[dest]);//도착점까지의 최소비용 값



}
public static void dijkstra(int start) {//다익스트라 구현
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(start);//우선순위 큐에 시작점 넣기
weight[start][start] = 0;//시작점의 가중치를 0
dist[start] = 0;//시작점까지의 최소비용 0
int i, temp;

while(!pq.isEmpty()) {
temp = pq.poll();//우선순위 큐에서 현재 위치와 가장 가까운 점 가져오기
for(i=1;i<=n;i++) {
if(dist[i] > weight[temp][i]+dist[temp]) {//현재 최소비용과 그 전 점의 최소비용+ 그 전에서부터 가중치 비교
dist[i] = weight[temp][i]+dist[temp];//더한 것이 더 작다면 최소비용 다시 설정
pq.offer(i);//우선순위 큐에 삽입
}
}
}

}

}
