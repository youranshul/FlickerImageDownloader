package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.Element;

class ImageEntry {

    private final Author author;
    private final ImageLink imageLink;
    private final String title;
    private final String publishedDate;
    private final String tag;

    public ImageEntry(@Element(name = "author") Author author,
            @Element(name = "link") ImageLink imageLink,
            @Element(name = "title") String title,
            @Element(name = "published") String publishedDate,
            @Element(name = "id") String tag) {
        this.imageLink = imageLink;
        this.title = title;
        this.publishedDate = publishedDate;
        this.tag = tag;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public ImageLink getImageLink() {
        return imageLink;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getTag() {
        return tag;
    }
}
