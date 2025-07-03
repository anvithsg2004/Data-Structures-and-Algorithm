package DSA.LLD._3_Structural_Design_Patterns._3_Facade_Design_Pattern;

class VideoCompressor {
    public void compress(String fileName) {
        System.out.println("Compressing video: " + fileName);
    }
}

class CloudUploader {
    public void upload(String fileName) {
        System.out.println("Uploading video to cloud: " + fileName);
    }
}

class ThumbnailGenerator {
    public void generate(String fileName) {
        System.out.println("Generating thumbnail for: " + fileName);
    }
}

class Notifier {
    public void notifyUsers() {
        System.out.println("Notifying subscribers...");
    }
}

class YouTubeUploaderFacade {
    private VideoCompressor compressor = new VideoCompressor();
    private CloudUploader uploader = new CloudUploader();
    private ThumbnailGenerator generator = new ThumbnailGenerator();
    private Notifier notifier = new Notifier();

    public void uploadVideo(String fileName) {
        compressor.compress(fileName);
        uploader.upload(fileName);
        generator.generate(fileName);
        notifier.notifyUsers();
    }
}

public class Main {
    public static void main(String[] args) {
        YouTubeUploaderFacade uploader = new YouTubeUploaderFacade();
        uploader.uploadVideo("my_video.mp4");
    }
}
