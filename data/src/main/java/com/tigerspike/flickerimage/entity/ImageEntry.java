package com.tigerspike.flickerimage.entity;

import com.tigerspike.DateFormatter;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class ImageEntry {

    private static final String EMPTY = "";

    @Element(name = "author", required = false)
    private final Author author;

    @ElementList(entry = "link", inline = true)
    private final List<ImageLink> imageLinkList;

    @Element(name = "title", required = false)
    private final String title;

    @Element(name = "published", required = false)
    private final String publishedDate;

    @Element(name = "id", required = false)
    private final String tag;
    private DateFormatter dateFormatter;

    public ImageEntry(@Element(name = "author") Author author,
            @ElementList(entry = "link", inline = true) List<ImageLink> imageLinkList,
            @Element(name = "title") String title,
            @Element(name = "published") String publishedDate,
            @Element(name = "id") String tag) {
        this.imageLinkList = imageLinkList;
        this.title = title;
        this.publishedDate = publishedDate;
        this.tag = tag;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return author.getAuthorName();
    }

    public long getPublishedDate() {
        if (publishedDate == null || publishedDate.isEmpty()) {
            return 0;
        }

        if (dateFormatter == null) {
            dateFormatter = new DateFormatter();
        }
        return dateFormatter.formatDate(publishedDate);
    }

    public String getTag() {
        return tag;
    }

    public String getImageLink() {
        return getImageUrl();

    }

    private String getImageUrl() {
        if (imageLinkList != null && imageLinkList.size() > 1
                && imageLinkList.get(1).getImageUrl() != null) {
            return imageLinkList.get(1).getImageUrl();
        }
        return EMPTY;
    }
}
