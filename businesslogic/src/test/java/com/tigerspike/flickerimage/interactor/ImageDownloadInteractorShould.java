package com.tigerspike.flickerimage.interactor;

import static org.mockito.Mockito.when;

import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.FlickerImageDataProvider;
import com.tigerspike.flickerimage.model.ImageEntryData;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.interactor.PostExecutionThread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;

import io.reactivex.Observable;

public class ImageDownloadInteractorShould {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PostExecutionThread postExecutionThread;

    @Mock
    private FlickerImageDownloadService flickerImageDownloadService;

    private ImageDownloadInteractor imageDownloadInteractor;

    @Before
    public void setup() {
        imageDownloadInteractor = new ImageDownloadInteractor(postExecutionThread,
                flickerImageDownloadService);
    }

    @Test(expected = NullPointerException.class)
    public void throwNullPointerExceptionWhenServiceNull() throws Exception {
        imageDownloadInteractor = new ImageDownloadInteractor(postExecutionThread,
                null);
        imageDownloadInteractor.buildUseCase(null);
    }

    @Test
    public void giveValidFlickerImageData() throws Exception {
        FlickerImageData data = new FlickerImageDataProvider(
                Collections.<ImageEntryData>emptyList());
        when(flickerImageDownloadService.downloadImages()).thenReturn(
                Observable.just(data));
        Observable<FlickerImageData> dataObservable = imageDownloadInteractor.buildUseCase(null);

        Assert.assertNotNull(dataObservable.blockingFirst());
    }
}