package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "feed")
public class FlickerImageResponse {

    private final List<ImageEntry> imageEntryList;

    public FlickerImageResponse(@ElementList(name = "entry") List<ImageEntry> imageEntryList) {
        this.imageEntryList = imageEntryList;
    }

    public List<ImageEntry> getImageEntryList() {
        return imageEntryList;
    }
}
