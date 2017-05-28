package tigerspike.com.tgimagegallery.flickerimage.di;

import com.tigerspike.flickerimage.FlickerImageDownloadRetrofitGateway;
import com.tigerspike.flickerimage.interactor.ImageDownloadInteractor;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.interactor.Interactor;

import dagger.Module;
import dagger.Provides;
import tigerspike.com.tgimagegallery.app.PerActivity;

@Module
public class FlickerImageModule {


    @Provides
    @PerActivity
    Interactor provideImageDownloadInteractor(ImageDownloadInteractor imageDownloadInteractor) {
        return imageDownloadInteractor;
    }

    @Provides
    @PerActivity
    FlickerImageDownloadService provideImageDownloadService(
            FlickerImageDownloadRetrofitGateway serviceGateway) {
        return serviceGateway;
    }
}
