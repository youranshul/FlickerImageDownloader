package com.tigerspike.flickerimage.model;

public class ImageEntryData {

    private final String authorName;
    private final String tag;
    private final String title;
    private final long publishDate;
    private final String imageLink;

    public ImageEntryData(String authorName, String tag, String title, long publish,
            String imageLink) {
        this.authorName = authorName;
        this.tag = tag;
        this.title = title;
        this.publishDate = publish;
        this.imageLink = imageLink;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public String getImageLink() {
        return imageLink;
    }
}
