package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.Element;

class ImageLink {

    @Element(name = "href")
    private String imageUrl;
}
