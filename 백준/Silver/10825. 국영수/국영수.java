import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Student implements Comparable<Student>{
        String name;
        int kor, eng, math;

        Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            // 여기에 문제의 4가지 조건을 순서대로 구현합니다.
            if (this.kor != other.kor) {
                return other.kor - this.kor; // 1. 국어 내림차순
            }
            if (this.eng != other.eng) {
                return this.eng - other.eng; // 2. 영어 오름차순
            }
            if (this.math != other.math) {
                return other.math - this.math; // 3. 수학 내림차순
            }
            return this.name.compareTo(other.name); // 4. 이름 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(students[i].name).append("\n");
        }
        System.out.println(sb);
    }
}
