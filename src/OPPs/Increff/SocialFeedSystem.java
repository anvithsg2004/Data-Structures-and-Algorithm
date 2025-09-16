package OPPs.Increff;

import java.util.*;

class SocialFeedSystem {
    private Map<String, String> users = new HashMap<>();
    private Map<String, Post> posts = new LinkedHashMap<>();
    private Map<String, Set<String>> followers = new HashMap<>();
    private int postCounter = 1;

    private class Post {
        String userId;
        String content;
        Set<String> sharedBy = new HashSet<>();

        Post(String userId, String content) {
            this.userId = userId;
            this.content = content;
        }
    }

    public String createUser(String userId, String name) {
        if (users.containsKey(userId))
            return "Error";
        users.put(userId, name);
        followers.put(userId, new HashSet<>());
        return "Success";
    }

    public String makePost(String userId, String content) {
        if (!users.containsKey(userId) || content.length() > 280)
            return "Error";
        String postId = String.format("POST%03d", postCounter++);
        posts.put(postId, new Post(userId, content));
        return postId;
    }

    public String followUser(String followerId, String followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId))
            return "Error";
        followers.get(followerId).add(followeeId);
        return "Success";
    }

    public List<String> showFeed(String userId, Integer limit) {
        if (!users.containsKey(userId))
            return new ArrayList<>();
        List<String> feed = new ArrayList<>();
        Set<String> followees = followers.get(userId);
        List<Map.Entry<String, Post>> entryList = new ArrayList<>(posts.entrySet());
        Collections.reverse(entryList);
        for (Map.Entry<String, Post> entry : entryList) {
            Post post = entry.getValue();
            if (post.userId.equals(userId) || followees.contains(post.userId) || post.sharedBy.contains(userId)) {
                feed.add(entry.getKey() + ": " + post.content);
            }
            if (limit != null && feed.size() >= limit)
                break;
        }
        return feed;
    }

    public String sharePost(String userId, String postId) {
        if (!users.containsKey(userId) || !posts.containsKey(postId))
            return "Error";
        posts.get(postId).sharedBy.add(userId);
        return "Success";
    }
}
