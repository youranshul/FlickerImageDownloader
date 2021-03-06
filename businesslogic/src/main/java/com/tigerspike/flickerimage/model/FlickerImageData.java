package com.tigerspike.flickerimage.model;

public interface FlickerImageData {

    String getAuthorName(int index);

    String getImageLink(int index);

    String getImageTag(int index);

    String getImageTitle(int index);

    long getPublishDate(int index);

    int getItemsSize();
}
