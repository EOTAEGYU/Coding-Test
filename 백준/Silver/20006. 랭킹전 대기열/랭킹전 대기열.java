import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Room {
        int people;
        int minLevel;
        int maxLevel;
        ArrayList<Player> players;
        Room (int people, int minLevel, int maxLevel, Player player){
            this.people += people;
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
            this.players = new ArrayList<>();
            this.players.add(player);
        }

    }
    static class Player{
        String nickname;
        int level;
    }
    static ArrayList<Room> rooms;

    static void createRoom(Player player){
        int minLevel = player.level - 10;
        int maxLevel = player.level + 10;
        if (minLevel < 1){
            minLevel = 1;
        }
        if (maxLevel > 500){
            maxLevel = 500;
        }

        Room room = new Room(1, minLevel, maxLevel, player);
        rooms.add(room);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken()); // 플에이어 수
        int M = Integer.parseInt(st.nextToken()); // 방 정원

        // 플레이어 입력
        Player[] players = new Player[P];

        for (int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            Player player = new Player();
            player.level = Integer.parseInt(st.nextToken());
            player.nickname = st.nextToken();
            players[i] = player;
        }

        rooms = new ArrayList<>();

        // 방 생성 및 입장
        for (int i = 0; i < P; i++){
            // 방이 없을 때
            if (rooms.isEmpty()){
                createRoom(players[i]);
            } else {
                boolean entered = false;
                for (Room room : rooms){
                    // 레벨 범위 내 포함 및 정원이 비었을 때
                    if (room.minLevel <= players[i].level && players[i].level <= room.maxLevel && room.people < M){
                        room.players.add(players[i]);
                        room.people++;
                        entered = true;
                        break;
                    }
                }
                if(!entered) {
                    createRoom(players[i]);
                }
            }
        }



        // 출력
        for (Room room : rooms){
            // 닉네임 기준 정렬
            room.players.sort(Comparator.comparing(p -> p.nickname));

            if (room.people == M) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            for (Player player : room.players) {
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }
}
