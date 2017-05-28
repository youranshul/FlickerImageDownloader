package com.tigerspike.flickerimage;

import com.tigerspike.flickerimage.entity.FlickerImageResponse;
import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.mapper.DataMapper;
import com.tigerspike.network.HttpConstants;
import com.tigerspike.network.RetrofitServiceFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.http.GET;

public class FlickerImageDownloadRetrofitGateway implements FlickerImageDownloadService {

    private final ImageDownloadService imageDownloadService;
    private final DataMapper<FlickerImageResponse, FlickerImageData> dataMapper;

    @Inject
    public FlickerImageDownloadRetrofitGateway(RetrofitServiceFactory retrofitServiceFactory,
            DataMapper<FlickerImageResponse, FlickerImageData> dataMapper) {
        imageDownloadService = retrofitServiceFactory.getService(ImageDownloadService.class);
        this.dataMapper = dataMapper;
    }

    @Override
    public Observable<FlickerImageData> downloadImages() {
        return imageDownloadService.getPublicImages().map(
                new Function<FlickerImageResponse, FlickerImageData>() {
                    @Override
                    public FlickerImageData apply(FlickerImageResponse response) throws Exception {
                        return dataMapper.transform(response);
                    }
                });
    }

    interface ImageDownloadService {
        @GET(HttpConstants.FLICKER_URL)
        Observable<FlickerImageResponse> getPublicImages();
    }
}
