import java.util.*;
import java.util.stream.Collectors;

class Song {
    String genre;
    int playCnt;
    int idx;
    
    public Song(String genre, int playCnt, int idx) {
        this.genre = genre;
        this.playCnt = playCnt;
        this.idx = idx;
    }
}

class Genre {
    ArrayList<Song> songs;
    int totalCnt;
    
    public Genre(){
        this.songs = new ArrayList<Song>();
        this.totalCnt = 0;
    }
    
    public void addSong(Song song, int cnt){
        this.songs.add(song);        
        Collections.sort(this.songs, (s1, s2) -> {
            return Integer.compare(s2.playCnt, s1.playCnt); 
        });  
        
        this.totalCnt += cnt;
    }
    
    public int getTotalCnt(){
        return this.totalCnt;
    }
}

class Solution {
    public static void main(String[] arg){
        String[] p1 = {"classic","pop","classic","classic","pop"};
        int[] p2 = {500,600,150,800,2500};
        int[] rlt = {};

        rlt = solution(p1, p2);

        for(int i : rlt) System.out.print(i + " ");
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        ArrayList<Song> songList = new ArrayList<Song>();
        Map<String, Genre> genreList= new HashMap<String, Genre>();
        
        for(int i=0; i<genres.length; i++){
            songList.add(new Song(genres[i], plays[i], i));
        }
        
        for(Song song : songList){
            if(genreList.containsKey(song.genre)) {
                genreList.get(song.genre).addSong(song, song.playCnt);
            }else{
                genreList.put(song.genre, new Genre());
                genreList.get(song.genre).addSong(song, song.playCnt);
            }
        }
        
        // genreList를 totalCnt 순으로 내림차순 해야됨.
        genreList = genreList.entrySet()
                                .stream()
                                .sorted((s1,s2) -> Integer.compare(s2.getValue().totalCnt, s1.getValue().totalCnt))
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        
        Iterator<String> keys = genreList.keySet().iterator();
        while(keys.hasNext()){
            String name = keys.next();
            System.out.println(name + ": " + Integer.toString(genreList.get(name).totalCnt));
            
            if(genreList.get(name).songs.size() >= 2){
                for(int i=0; i<2; i++){
                    System.out.println(genreList.get(name).songs.get(i).idx);
                    answer.add(genreList.get(name).songs.get(i).idx);
                }    
            } else {
                for(int i=0; i<1; i++){
                    System.out.println(genreList.get(name).songs.get(i).idx);
                    answer.add(genreList.get(name).songs.get(i).idx);
                }
            }
            
        }
        
        int[] ans = new int[answer.size()];
        int cnt = 0;
        for(int tmp : answer){
            ans[cnt++] = tmp;
        }
        
        return ans;
    }
}