package com.tigerspike.flickerimage.entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class FlickerImageResponse {

    @ElementList(entry = "entry", inline = true)
    private final List<ImageEntry> imageEntryList;

    public FlickerImageResponse(
            @ElementList(entry = "entry", inline = true) List<ImageEntry> imageEntryList) {
        this.imageEntryList = imageEntryList;
    }

    public List<ImageEntry> getImageEntryList() {
        return imageEntryList;
    }
}
