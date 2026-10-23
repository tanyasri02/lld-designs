package Music;
import java.util.Arrays;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        // 1. Create User
        User user = new User(1, "U101");

        // 2. Create five Track objects
        Track t1 = new Track(
                "T101", "Music A", "ART101", "ALB101", 210, "audio/musicA.mp3"
        );

        Track t2 = new Track(
                "T102", "Music B", "ART102", "ALB102", 185, "audio/musicB.mp3"
        );

        Track t3 = new Track(
                "T103", "Music C", "ART103", "ALB103", 240, "audio/musicC.mp3"
        );

        Track t4 = new Track(
                "T104", "Music D", "ART104", "ALB104", 195, "audio/musicD.mp3"
        );

        Track t5 = new Track(
                "T105", "Music E", "ART105", "ALB105", 220, "audio/musicE.mp3"
        );

        // 3. Create TrackRepository implementation
        TrackRepository trackRepository = new TrackReposiotoryImpl();
        trackRepository.saveData(t1);
        trackRepository.saveData(t2);
        trackRepository.saveData(t3);
        trackRepository.saveData(t4);
        trackRepository.saveData(t5);

        // 4. Create AudioOutput implementation
        AudioOutput audioOutput = new AudioOutputImpl();

        // 5. Create MusicPlayer by injecting AudioOutput
        MusicPlayer player = new MusicPlayer(audioOutput);

        // 6. Create PlaybackQueue with five track IDs
        PlaybackQueue queue = new PlaybackQueue();

        List<String> trackIds = Arrays.asList("T101", "T102", "T103", "T104", "T105");

        queue.setQueue(trackIds, 0);

        // 7. Create PlaybackSession
        PlaybackSession session = new PlaybackSession(user.getId(), queue, player, trackRepository);

        // 8. Start playback
        session.playQueue(trackIds, 0);
    }
}