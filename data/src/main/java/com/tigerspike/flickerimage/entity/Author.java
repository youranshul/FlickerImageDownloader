package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.Element;

class Author {

    private final String authorName;

    Author(@Element(name = "name") String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }
}
