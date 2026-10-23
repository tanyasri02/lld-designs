package Music;

import java.util.ArrayList;
import java.util.List;

public class PlaybackQueue {
    private final List<String> trackIds = new ArrayList<>();
    private int currentIndex = -1;
    // This replaces the entire queue
    public void setQueue(List<String> ids, int startIndex) {
        if (ids == null || ids.isEmpty()) {
            trackIds.clear();
            currentIndex = -1;
            return;
        }

        if (startIndex < 0 || startIndex >= ids.size()) {
            throw new IllegalArgumentException("Invalid start index");
        }

        trackIds.clear();
        trackIds.addAll(ids);
        currentIndex = startIndex;
    }

    public String getCurrentTrackId() {
        if (currentIndex < 0 || currentIndex >= trackIds.size()) {
            return null;
        }
        return trackIds.get(currentIndex);
    }

    public String next() {
        if (currentIndex + 1 >= trackIds.size()) {
            return null;
        }
        return trackIds.get(++currentIndex);
    }

    public String previous() {
        if (currentIndex <= 0) {
            return null;
        }
        return trackIds.get(--currentIndex);
    }

    // Add to the queue
    public void enqueue(String trackId) {
        trackIds.add(trackId);
    }

    public boolean isEmpty() {
        return trackIds.isEmpty();
    }
}
