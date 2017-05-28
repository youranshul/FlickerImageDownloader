package com.tigerspike.flickerimage.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlickerImageDataProviderShould {

    private static final String NAME_1 = "name1";
    private static final String TAG_1 = "tag1";
    private static final String TITLE_1 = "title1";
    private static final String PUBLISH_1 = "publish1";
    private static final String IMAGELINK_1 = "imagelink1";
    private static final String NAME_2 = "name2";
    private static final String TAG_2 = "tag2";
    private static final String TITLE_2 = "title2";
    private static final String PUBLISH_2 = "publish2";
    private static final String IMAGELINK_2 = "imagelink2";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private FlickerImageDataProvider flickerDataProvider;

    @Before
    public void setUp() {
        ImageEntryData entryDataOne = new ImageEntryData(NAME_1, TAG_1, TITLE_1, PUBLISH_1,
                IMAGELINK_1);
        ImageEntryData entryDataTwo = new ImageEntryData(NAME_2, TAG_2, TITLE_2, PUBLISH_2,
                IMAGELINK_2);
        List<ImageEntryData> imageEntryDataList = new ArrayList<>();
        imageEntryDataList.add(entryDataOne);
        imageEntryDataList.add(entryDataTwo);
        flickerDataProvider = new FlickerImageDataProvider(imageEntryDataList);
    }

    @Test
    public void transformAuthorNameCorrectly() {

        Assert.assertEquals(flickerDataProvider.getAuthorName(FIRST_INDEX), NAME_1);
    }


    @Test
    public void transformImageLinksCorrectly() {

        Assert.assertEquals(flickerDataProvider.getImageLink(FIRST_INDEX), IMAGELINK_1);
    }

    @Test
    public void transformTagCorrectly() {
        Assert.assertEquals(flickerDataProvider.getImageTag(FIRST_INDEX), TAG_1);
    }

    @Test
    public void transformTitleCorrectly() {
        Assert.assertEquals(flickerDataProvider.getImageTitle(SECOND_INDEX), TITLE_2);
    }

    @Test
    public void transformPublishDateCorrectly() {
        Assert.assertEquals(flickerDataProvider.getPublishDate(SECOND_INDEX), PUBLISH_2);
    }
}