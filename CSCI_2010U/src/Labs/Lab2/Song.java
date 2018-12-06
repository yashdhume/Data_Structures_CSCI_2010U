package Labs.Lab2;

class Song {
    private String artist;
    private String title;
    private int duration;
    public static String collectionName;
    Song(String artist, String title, int duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;

    }
    private int getDuration(){
        return duration;
    }
    private String getTitle() {
        return title;
    }
    private String getArtist() {
        return artist;
    }



    public static void main(String[] args) {
        Song sed = new Song("The Ramones", "I Wanna be Sedated", 148);
        Song one = new Song("Daft Punk", "One More Time", 322);
        sed.collectionName = "Randy's Collection";
        System.out.println("Collection: " + one.collectionName);
        printSong(sed);
        printSong(one);
    }

    public static void printSong(Song song) {
        int min = song.getDuration() / 60;
        int sec = song.getDuration() % 60;
        System.out.printf("%s (%s) ­ %d:%d\n", song.getTitle(), song.getArtist(), min, sec);
    }
}

