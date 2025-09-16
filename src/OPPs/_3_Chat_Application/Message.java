package OPPs._3_Chat_Application;

import java.time.*;

public class Message {
    public String senderId;
    public String receiverId;
    public String messageText;
    public LocalDateTime timestamp;

    public Message(String senderId, String receiverId, String messageText, LocalDateTime timestamp) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
        this.timestamp = timestamp;
    }
}
