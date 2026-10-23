package Music;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;

    public PlaylistService(
            PlaylistRepository playlistRepository,
            TrackRepository trackRepository) {
        this.playlistRepository = playlistRepository;
        this.trackRepository = trackRepository;
    }

    public void addTrack(
            String userId, String playlistId, String trackId) {

        Playlist playlist = playlistRepository.findById(playlistId);

        if (playlist == null) {
            throw new IllegalArgumentException("Playlist not found");
        }

        if (!playlist.isOwnedBy(userId)) {
            throw new SecurityException(
                    "You cannot modify this playlist");
        }

        if (trackRepository.findById(trackId) == null) {
            throw new IllegalArgumentException("Track not found");
        }

        playlist.addTrack(trackId);
        playlistRepository.save(playlist);
    }
}
