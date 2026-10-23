package Music;

// todo : ask shiwam
public class MusicPlayer implements AudioOutput {
    private final AudioOutput output;

    public MusicPlayer(AudioOutput output) {
        this.output = output;
    }

    public void play(String audioUri) {
        output.play(audioUri);
    }

    public void pause() {
        output.pause();
    }

    public void resume() {
        output.resume();
    }

    public void seek(int positionSeconds) {
        if (positionSeconds < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        output.seek(positionSeconds);
    }

    public void stop() {
        output.stop();
    }
}
