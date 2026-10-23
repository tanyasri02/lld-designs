package Music;

public class AudioOutputImpl implements AudioOutput {

        @Override
        public void play(String audioUri) {
            System.out.println("Playing audio: " + audioUri);
        }

        @Override
        public void pause() {
            System.out.println("Audio paused");
        }

        @Override
        public void resume() {
            System.out.println("Audio resumed");
        }

        @Override
        public void seek(int positionSeconds) {
            System.out.println("Seek to: " + positionSeconds + " seconds");
        }

        @Override
        public void stop() {
            System.out.println("Audio stopped");
        }
}
