package com.tigerspike.flickerimage.model;

import java.util.List;

public class FlickerImageDataProvider implements FlickerImageData {

    private final List<ImageEntryData> entryDataList;

    public FlickerImageDataProvider(List<ImageEntryData> entryDataList) {
        this.entryDataList = entryDataList;
    }

    @Override
    public String getAuthorName(int index) {
        return entryDataList.get(index).getAuthorName();
    }

    @Override
    public String getImageLink(int index) {
        return entryDataList.get(index).getImageLink();
    }

    @Override
    public String getImageTag(int index) {
        return entryDataList.get(index).getTag();
    }

    @Override
    public String getImageTitle(int index) {
        return entryDataList.get(index).getTitle();
    }

    @Override
    public String getPublishDate(int index) {
        return entryDataList.get(index).getPublishDate();
    }
}
