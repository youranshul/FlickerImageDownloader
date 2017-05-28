package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Author {

    @Element(name = "name", required = false)
    private final String authorName;

    public Author(@Element(name = "name") String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }
}
