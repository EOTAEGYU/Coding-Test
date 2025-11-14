class Solution {
    public String solution(String m, String[] musicinfos) {

        String bestTitle = null;
        int bestPlayTime = -1;
        int bestIndex = 1000; // 같은 재생 시간이면 입력 순서 비교용

        String m1 = normalize(m); // 입력 음 전처리

        for(int i = 0; i < musicinfos.length; i++){
            String[] musicinfo = musicinfos[i].split(",");

            int start = Integer.parseInt(musicinfo[0].substring(0, 2)) * 60
                    + Integer.parseInt(musicinfo[0].substring(3));
            int end = Integer.parseInt(musicinfo[1].substring(0, 2)) * 60
                    + Integer.parseInt(musicinfo[1].substring(3));

            int playTime = end - start;       // 재생 시간
            String title = musicinfo[2];      // 제목
            String original = musicinfo[3];           // 원본 악보
            String sound = normalize(original);       // 정규화된 악보
            int musicTime = sound.length();   // 악보 길이

            // 실제 재생된 음악 문자열 만들기
            String played = "";

            if(musicTime >= playTime){
                int cutLen = Math.min(original.length(), playTime * 2); 
                played = normalize(original.substring(0, cutLen))
                        .substring(0, playTime);
            } else {
                // 길면 반복하여 재생
                int over = playTime / musicTime;
                int some = playTime % musicTime;
                played = sound.repeat(over) + sound.substring(0, some);
            }

            // 기억한 멜로디가 포함되는가?
            if(played.contains(m1)) {

                // 더 좋은 후보인지 비교
                if (playTime > bestPlayTime ||
                   (playTime == bestPlayTime && i < bestIndex)) {

                    bestPlayTime = playTime;
                    bestTitle = title;
                    bestIndex = i;
                }
            }
        }

        // 아무 곡도 일치하지 않으면 "(None)"
        return bestTitle == null ? "(None)" : bestTitle;
    }

    private String normalize(String s) {
        return s
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b")
                .replace("E#", "e");
    }
}
