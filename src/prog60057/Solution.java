public class Solution {
    public static void main(String[] args){
        String s = "abcabcabcabcdededededede"; // answer = 14

        int answer = solution(s);

        System.out.println(answer);
    }

    public static int solution(String s){
        int answer = Integer.MAX_VALUE; // 압축 문자열 중 가장 짧은 길이를 갱신하기 위한 변수

        for(int unit=1; unit<s.length(); unit++){ // unit : 단위길이. 문자열을 자를 단위.
            String target = ""; // 문자열 단위를 저장할 변수
            String compressed = ""; // 압축 문자열 저장할 변수
            int cnt = 1; // 반복횟수 체크

            // 단위길이만큼의 단위를 target에 저장
            for(int i=0; i<unit; i++){
                target += s.charAt(i);
            }

            // target 단위가 몇번 반복되는지를 체크
            for(int i=unit; i<s.length(); i+=unit){
                String current = ""; // 단위 길이만큼의 추출한 부분 문자열을 저장.
                for(int j=i; j<i+unit; j++){
                    if(s.length() <= j) break; // s 길이 넘어가면 current에는 단위길이보다 짧게 저장되겠지.
                    current += s.charAt(j);
                }

                // 샘플 뽑았으니 target과 비교
                if(target.equals(current)){
                    // 같으면 cnt 증가시키고 for문 재실행(=다음 단위길이 체크)
                    cnt++;
                } else {
                    // 다르면, 우선 현재까지 카운트된 target을 compressed에 갱신
                    if(cnt > 1){
                        compressed += cnt + target;
                    } else {
                        compressed += target;
                    }
                    // 카운트 변수 초기화 및 새로운 target을 current로 갱신
                    cnt = 1;
                    target = current;
                }
            }

            // 위의 반복문이 종료되는 경우는 2가지
            if(cnt > 1){
                // 1. unit 길이에 딱 맞게 문자열이 끝난 경우
                compressed += cnt + target;
            } else {
                // 2. unit 길이보다 짧게 잔여 문자열이 남은 경우
                compressed += target;
            }

            // 최소 길이 갱신
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}