package Music;

public interface TrackRepository {
    Track findById(String id);
    void saveData(Track track);
}
