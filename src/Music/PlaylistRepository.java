package Music;

public interface PlaylistRepository {
    Playlist findById(String playlistId);
    void save(Playlist playlist);
}
