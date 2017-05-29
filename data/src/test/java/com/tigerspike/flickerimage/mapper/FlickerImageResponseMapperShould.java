package com.tigerspike.flickerimage.mapper;

import com.tigerspike.flickerimage.entity.Author;
import com.tigerspike.flickerimage.entity.FlickerImageResponse;
import com.tigerspike.flickerimage.entity.ImageEntry;
import com.tigerspike.flickerimage.entity.ImageLink;
import com.tigerspike.flickerimage.model.FlickerImageData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlickerImageResponseMapperShould {

    private static final String NAME_1 = "name1";
    private static final String TAG_1 = "tag1";
    private static final String TITLE_1 = "title1";
    private static final String PUBLISH_1 = "2017-06-30T10:31:38Z";
    private static final String IMAGELINK_1 = "imagelink1";
    private static final String NAME_2 = "name2";
    private static final String TAG_2 = "tag2";
    private static final String TITLE_2 = "title2";
    private static final String PUBLISH_2 = "2017-05-29T10:31:38Z";
    private static final String IMAGELINK_2 = "imagelink2";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private FlickerImageResponseMapper responseMapper;
    private FlickerImageResponse flickerImageResponse;

    @Before
    public void setUp() {

        flickerImageResponse = new FlickerImageResponse(
                prepareImageEntryList());
        responseMapper = new FlickerImageResponseMapper();
    }

    private List<ImageEntry> prepareImageEntryList() {
        List<ImageEntry> imageEntryList = new ArrayList<>();

        ImageLink link1 = new ImageLink(IMAGELINK_1);
        ImageLink link2 = new ImageLink(IMAGELINK_2);

        List<ImageLink> imageLinkListOne = new ArrayList<>();
        imageLinkListOne.add(link1);
        imageLinkListOne.add(link2);
        Author author1 = new Author(NAME_1);
        ImageEntry entryOne = new ImageEntry(author1, imageLinkListOne, TITLE_1, PUBLISH_1, TAG_1);

        List<ImageLink> imageLinkListTwo = new ArrayList<>();
        imageLinkListTwo.add(link1);
        imageLinkListTwo.add(link2);
        Author author2 = new Author(NAME_2);
        ImageEntry entryTwo = new ImageEntry(author2, imageLinkListTwo, TITLE_2, PUBLISH_2, TAG_2);

        imageEntryList.add(entryOne);
        imageEntryList.add(entryTwo);

        return imageEntryList;
    }

    @Test
    public void transformAuthorNameCorrectly() {

        FlickerImageData flickerImageData = responseMapper.transform(flickerImageResponse);

        Assert.assertEquals(flickerImageData.getAuthorName(FIRST_INDEX), NAME_2);
    }


    @Test
    public void transformImageLinksSortedByPublishDateCorrectly() {

        FlickerImageData flickerImageData = responseMapper.transform(flickerImageResponse);

        Assert.assertEquals(flickerImageData.getImageLink(FIRST_INDEX), IMAGELINK_2);
    }

    @Test
    public void transformTagCorrectly() {

        FlickerImageData flickerImageData = responseMapper.transform(flickerImageResponse);

        Assert.assertEquals(flickerImageData.getImageTag(FIRST_INDEX), TAG_2);
    }

    @Test
    public void transformTitleCorrectly() {

        FlickerImageData flickerImageData = responseMapper.transform(flickerImageResponse);

        Assert.assertEquals(flickerImageData.getImageTitle(SECOND_INDEX), TITLE_1);
    }

    @Test
    public void sortByPublishDateCorrectly() {

        FlickerImageData flickerImageData = responseMapper.transform(flickerImageResponse);

        Assert.assertEquals(flickerImageData.getImageLink(SECOND_INDEX), IMAGELINK_2);
    }
}