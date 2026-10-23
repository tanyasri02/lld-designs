package Music;
//User's playlist
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String id;
    private final String ownerId;
    private String name;
    private final List<String> trackIds = new ArrayList<>();

    public Playlist(String id, String ownerId, String name) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
    }

    public void addTrack(String trackId) {
        if (trackId == null || trackId.isBlank()) {
            throw new IllegalArgumentException("Invalid track ID");
        }
        trackIds.add(trackId);
    }

    public void removeTrack(String trackId) {
        trackIds.remove(trackId);
    }

    public void reorderTrack(int from, int to) {
        if (from < 0 || from >= trackIds.size()
                || to < 0 || to >= trackIds.size()) {
            throw new IndexOutOfBoundsException();
        }

        String trackId = trackIds.remove(from);
        trackIds.add(to, trackId);
    }

    public boolean isOwnedBy(String userId) {
        return ownerId.equals(userId);
    }

    public List<String> getTrackIds() {
        return List.copyOf(trackIds);
    }

    public String getId() {
        return id;
    }
}