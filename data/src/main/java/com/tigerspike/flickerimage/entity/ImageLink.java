package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ImageLink {

    @Attribute(name = "href", required = false)
    private String imageUrl;

    public ImageLink(@Attribute(name = "href") String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
