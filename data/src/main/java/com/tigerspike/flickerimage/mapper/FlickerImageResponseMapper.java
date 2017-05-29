package com.tigerspike.flickerimage.mapper;

import com.tigerspike.flickerimage.entity.FlickerImageResponse;
import com.tigerspike.flickerimage.entity.ImageEntry;
import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.FlickerImageDataProvider;
import com.tigerspike.flickerimage.model.ImageEntryData;
import com.tigerspike.mapper.DataMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

public class FlickerImageResponseMapper implements
        DataMapper<FlickerImageResponse, FlickerImageData> {

    @Inject
    public FlickerImageResponseMapper() {
    }

    @Override
    public FlickerImageData transform(FlickerImageResponse flickerImageResponse) {
        List<ImageEntryData> imageEntryDataList = new ArrayList<>();
        if (flickerImageResponse.getImageEntryList() != null) {
            for (ImageEntry entry : flickerImageResponse.getImageEntryList()) {
                String authorName = entry.getAuthorName() != null ? entry.getAuthorName() : "";
                String tag = entry.getTag() != null ? entry.getTag() : "";
                String title = entry.getTitle() != null ? entry.getTitle() : "";
                long publish = entry.getPublishedDate();
                String imageLink = entry.getImageLink();
                ImageEntryData entryData = new ImageEntryData(authorName, tag, title, publish,
                        imageLink);
                imageEntryDataList.add(entryData);
            }

            Collections.sort(imageEntryDataList, new Comparator<ImageEntryData>() {
                @Override
                public int compare(ImageEntryData o1, ImageEntryData o2) {
                    return o1.getPublishDate() < o2.getPublishDate() ? -1
                            : o1.getPublishDate() > o2.getPublishDate() ? 1 : 0;
                }
            });
        }
        return new FlickerImageDataProvider(imageEntryDataList);
    }
}
