
class Twitter {
    private static int timeStamp = 0;

    // user -> users they follow
    private Map<Integer, Set<Integer>> followMap;

    // user -> list of their tweets
    private Map<Integer, List<Tweet>> tweetsMap;

    private class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetsMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(
                (a, b) -> a.time - b.time);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId); // follow self

        for (int followeeId : followMap.get(userId)) {
            List<Tweet> tweets = tweetsMap.get(followeeId);
            if (tweets == null)
                continue;

            for (int i = tweets.size() - 1; i >= 0 && i >= tweets.size() - 10; i--) {
                minHeap.offer(tweets.get(i));
                if (minHeap.size() > 10) {
                    minHeap.poll(); // remove least recent
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().tweetId); // add to front for reverse order
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        Set<Integer> followees = followMap.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
