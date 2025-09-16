package OPPs.Increff;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialFeedSystem system = new SocialFeedSystem();
        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Make Post");
            System.out.println("3. Follow User");
            System.out.println("4. Show Feed");
            System.out.println("5. Share Post");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.print("User ID: ");
                String userId = sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.println(system.createUser(userId, name));
            } else if (choice.equals("2")) {
                System.out.print("User ID: ");
                String userId = sc.nextLine();
                System.out.print("Content: ");
                String content = sc.nextLine();
                System.out.println(system.makePost(userId, content));
            } else if (choice.equals("3")) {
                System.out.print("Follower ID: ");
                String followerId = sc.nextLine();
                System.out.print("Followee ID: ");
                String followeeId = sc.nextLine();
                System.out.println(system.followUser(followerId, followeeId));
            } else if (choice.equals("4")) {
                System.out.print("User ID: ");
                String userId = sc.nextLine();
                System.out.print("Limit (optional): ");
                String limitStr = sc.nextLine();
                Integer limit = null;
                if (!limitStr.isEmpty()) {
                    try {
                        limit = Integer.parseInt(limitStr);
                    } catch (NumberFormatException e) {
                    }
                }
                List<String> feed = system.showFeed(userId, limit);
                for (String post : feed)
                    System.out.println(post);
            } else if (choice.equals("5")) {
                System.out.print("User ID: ");
                String userId = sc.nextLine();
                System.out.print("Post ID: ");
                String postId = sc.nextLine();
                System.out.println(system.sharePost(userId, postId));
            } else if (choice.equals("6")) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
