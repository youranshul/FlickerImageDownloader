package com.tigerspike.flickerimage;

import com.tigerspike.flickerimage.entity.FlickerImageResponse;
import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.network.HttpConstants;
import com.tigerspike.network.RetrofitServiceFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.http.GET;

public class FlickerImageDownloadRetrofitGateway implements FlickerImageDownloadService {

    private final ImageDownloadService imageDownloadService;

    @Inject
    public FlickerImageDownloadRetrofitGateway(RetrofitServiceFactory retrofitServiceFactory) {
        imageDownloadService = retrofitServiceFactory.getService(ImageDownloadService.class);
    }

    @Override
    public Observable<FlickerImageData> downloadImages() {
        return imageDownloadService.getPublicImages().map(
                new Function<FlickerImageResponse, FlickerImageData>() {
                    @Override
                    public FlickerImageData apply(FlickerImageResponse s) throws Exception {
                        System.out.print("Output is :" + s.getImageEntryList().size());
                        return null;
                    }
                });
    }

    interface ImageDownloadService {
        @GET(HttpConstants.FLICKER_URL)
        Observable<FlickerImageResponse> getPublicImages();
    }
}
