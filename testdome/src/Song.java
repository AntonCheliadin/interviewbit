import java.util.HashSet;

/*
A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist.
Otherwise, the playlist will end with the last song which points to null.

Implement a function isRepeatingPlaylist that, efficiently with respect to time used,
returns true if a playlist is repeating or false if it is not.
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        HashSet<Song> songs = new HashSet<>();
        Song curr = this;
        while (curr != null) {
            if (!songs.add(curr)) {
                return true;
            }
            curr = curr.nextSong;
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}