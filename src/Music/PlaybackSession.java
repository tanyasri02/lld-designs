package Music;

import java.util.List;

public class PlaybackSession {
    private final Integer userId;
    private final PlaybackQueue queue;
    private final MusicPlayer player;
    private final TrackRepository trackRepository;

    private PlaybackState state = PlaybackState.STOPPED;
    private int positionSeconds = 0;

    public PlaybackSession(Integer userId, PlaybackQueue queue, MusicPlayer player, TrackRepository trackRepository) {
        this.userId = userId;
        this.queue = queue;
        this.player = player;
        this.trackRepository = trackRepository;
    }

    // play this music/Track
    public void playTrack(String trackId) {
        Track track = trackRepository.findById(trackId);

        if (track == null) {
            throw new IllegalArgumentException("Track not found");
        }

        queue.setQueue(List.of(trackId), 0);
        positionSeconds = 0;
        player.play(track.getAudioUri());
        state = PlaybackState.PLAYING;
    }
    // add to queue - add to playlist
    public void playQueue(List<String> trackIds, int startIndex) {
        if (trackIds == null || trackIds.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        if (startIndex < 0 || startIndex >= trackIds.size()) {
            throw new IllegalArgumentException("Invalid start index");
        }

        // Validate before changing the active queue.
        for (String id : trackIds) {
            if (trackRepository.findById(id) == null) {
                throw new IllegalArgumentException("Unknown track: " + id);
            }
        }

        queue.setQueue(trackIds, startIndex);
        positionSeconds = 0;
        startCurrentTrack();
    }

    public void pause() {
        if (state != PlaybackState.PLAYING) {
            return;
        }
        player.pause();
        state = PlaybackState.PAUSED;
    }

    public void resume() {
        if (state != PlaybackState.PAUSED) {
            return;
        }
        player.resume();
        state = PlaybackState.PLAYING;
    }

    public void next() {
        String nextTrackId = queue.next();

        if (nextTrackId == null) {
            player.stop();
            state = PlaybackState.STOPPED;
            positionSeconds = 0;
            return;
        }

        positionSeconds = 0;
        startCurrentTrack();
    }

    public void previous() {
        String previousTrackId = queue.previous();

        if (previousTrackId == null) {
            seek(0);
            return;
        }

        positionSeconds = 0;
        startCurrentTrack();
    }

    public void seek(int positionSeconds) {
        String currentId = queue.getCurrentTrackId();
        Track track = currentId == null ? null : trackRepository.findById(currentId);

        if (track == null || positionSeconds < 0 || positionSeconds > track.getDurationSeconds()) {
            throw new IllegalArgumentException("Invalid seek position");
        }

        player.seek(positionSeconds);
        this.positionSeconds = positionSeconds;
    }

    private void startCurrentTrack() {
        String id = queue.getCurrentTrackId();
        Track track = trackRepository.findById(id);

        player.play(track.getAudioUri());
        state = PlaybackState.PLAYING;
    }

    public PlaybackState getState() {
        return state;
    }

    public Integer getUserId() {
        return userId;
    }
}
