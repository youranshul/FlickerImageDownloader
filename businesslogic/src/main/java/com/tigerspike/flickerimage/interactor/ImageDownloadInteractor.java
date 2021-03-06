package com.tigerspike.flickerimage.interactor;

import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.NoRequest;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.interactor.Interactor;
import com.tigerspike.interactor.PostExecutionThread;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ImageDownloadInteractor extends Interactor<FlickerImageData, NoRequest> {

    private final FlickerImageDownloadService downloadService;

    @Inject
    public ImageDownloadInteractor(PostExecutionThread postExecutionThread,
            FlickerImageDownloadService downloadService) {
        super(postExecutionThread);
        this.downloadService = downloadService;
    }

    @Override
    public Observable<FlickerImageData> buildUseCase(NoRequest noRequest) {
        return downloadService.downloadImages();
    }
}
