package Music;
//Details of music or song track
public class Track {
    private final String id;
    private final String title;
    private final String artistId;
    private final String albumId;
    private final int durationSeconds;
    private final String audioUri;

    public Track(String id, String title, String artistId, String albumId, int durationSeconds, String audioUri) {

        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }

        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.albumId = albumId;
        this.durationSeconds = durationSeconds;
        this.audioUri = audioUri;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public String getAudioUri() {
        return audioUri;
    }
}
