package OPPs._3_Chat_Application;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class ChatSystem {
    Map<String, User> users = new HashMap<>();
    Map<String, List<Message>> messagesSent = new HashMap<>();

    public String registerUser(String userId, String name) {

        if (users.containsKey(userId)) {
            System.out.println("User already exists.");
            return "Error";
        }
        users.put(userId, new User(userId, name));
        messagesSent.put(userId, new ArrayList<>());
        return "Success";
    }

    public String sendMessage(String senderId, String receiverId, String messageText, LocalDateTime timestamp) {

        if (!users.containsKey(senderId) || !users.containsKey(receiverId)) {
            System.out.println("Register first");
            return "Error";
        }
        messagesSent.get(senderId).add(new Message(senderId, receiverId, messageText, timestamp));
        return "Success";
    }

    public List<String> getConversation(String userId1, String userId2) {

        List<String> messages = new ArrayList<>();

        Map<String, LocalDateTime> Messages = new HashMap<>();
        List<Message> userId1AllMessages = messagesSent.get(userId1);
        for (Message ms : userId1AllMessages) {
            if (ms.senderId.equals(userId1) && ms.receiverId.equals(userId2)) {
                Messages.put(ms.messageText, ms.timestamp);
            }
        }

        List<Message> userId2AllMessages = messagesSent.get(userId2);
        for (Message ms : userId2AllMessages) {
            if (ms.senderId.equals(userId2) && ms.receiverId.equals(userId1)) {
                Messages.put(ms.messageText, ms.timestamp);
            }
        }

        Map<String, LocalDateTime> sortedMessages = Messages.entrySet().stream().sorted(Map.Entry.comparingByValue()) // sorts by LocalDateTime
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new // maintains insertion order
                ));

        return messages;

    }

    public List<String> listAllUsers() {
        List<String> userList = new ArrayList<>();

        for (Map.Entry<String, User> map : users.entrySet()) {
            String userId = map.getKey();
            User user = map.getValue();
            userList.add(user.name);
        }

        return userList;
    }

    public List<Message> getUserConversations(String userId) {

        List<Message> conversations = new ArrayList<>(messagesSent.get(userId));

        for (Map.Entry<String, List<Message>> mess : messagesSent.entrySet()) {

            List<Message> currentMessage = mess.getValue();

            for (Message m : currentMessage) {

                if (m.receiverId.equals(userId)) {
                    conversations.add(m);
                }

            }

        }

        return conversations;
    }
}
