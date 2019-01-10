package com.example.korob.tvitt.pojo;

public class Tweet {
    private User user;
    private Long id;
    private String creationDate;
    private String text;
    private Long retweetCont;
    private Long favouriteCount;
    private String imageUrl;

    public Tweet(User user, Long id, String creationDate, String text, Long retweetCont, Long favouriteCount, String imageUrl) {
        this.user = user;
        this.id = id;
        this.creationDate = creationDate;
        this.text = text;
        this.retweetCont = retweetCont;
        this.favouriteCount = favouriteCount;
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getText() {
        return text;
    }

    public Long getRetweetCont() {
        return retweetCont;
    }

    public Long getFavouriteCount() {
        return favouriteCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (!user.equals(tweet.user)) return false;
        if (!id.equals(tweet.id)) return false;
        if (!creationDate.equals(tweet.creationDate)) return false;
        if (!text.equals(tweet.text)) return false;
        if (!retweetCont.equals(tweet.retweetCont)) return false;
        if (!favouriteCount.equals(tweet.favouriteCount)) return false;
        return imageUrl != null ? imageUrl.equals(tweet.imageUrl) : tweet.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + retweetCont.hashCode();
        result = 31 * result + favouriteCount.hashCode();
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
