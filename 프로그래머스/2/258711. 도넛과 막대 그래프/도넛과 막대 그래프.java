class Solution {
    static int N = 1_000_000;
    public int[] solution(int[][] edges) {
        int[] ingoing = new int[N];
        int[] outgoing = new int[N];
        
        for(int[] edge : edges){
            outgoing[edge[0]-1]++;
            ingoing[edge[1]-1]++;
        }
        
        // 2️⃣ 주요 변수
        int created = 0; // 생성 정점
        int eight = 0;   // 8자 그래프 개수
        int stick = 0;   // 막대 그래프 개수
        
        // 3️⃣ 정점별 패턴 검사
        for(int i=0; i<N; i++) {
            if(outgoing[i] >= 2) {  // 간선 2개 이상 나감
                if(ingoing[i] == 0) { // 들어오는 간선 없음
                    created = i;       // 생성 정점
                } else {
                    eight++;           // 도넛 두 개가 한 점에서 만나는 8자형
                }
            }
            else if(outgoing[i] == 0 && ingoing[i] > 0) {
                stick++;  // 막대 그래프의 끝점
            }
        }
        
        return new int[] {created+1, outgoing[created]-eight-stick, stick, eight};

    }
}