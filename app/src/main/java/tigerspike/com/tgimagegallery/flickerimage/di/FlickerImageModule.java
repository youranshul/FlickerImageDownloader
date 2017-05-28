package tigerspike.com.tgimagegallery.flickerimage.di;

import android.app.Activity;

import com.tigerspike.flickerimage.FlickerImageDownloadRetrofitGateway;
import com.tigerspike.flickerimage.entity.FlickerImageResponse;
import com.tigerspike.flickerimage.interactor.ImageDownloadInteractor;
import com.tigerspike.flickerimage.mapper.FlickerImageResponseMapper;
import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.FlickerImageDataProvider;
import com.tigerspike.flickerimage.model.ImageEntryData;
import com.tigerspike.flickerimage.service.FlickerImageDownloadService;
import com.tigerspike.interactor.Interactor;
import com.tigerspike.mapper.DataMapper;
import com.tigerspike.navigation.BrowserNavigationCommand;

import java.util.Collections;

import dagger.Module;
import dagger.Provides;
import tigerspike.com.tgimagegallery.app.PerActivity;
import tigerspike.com.tgimagegallery.flickerimage.adapter.RecycleFlickerImageAdapter;
import tigerspike.com.tgimagegallery.navigation.BrowserNavigation;

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

    @Provides
    @PerActivity
    DataMapper<FlickerImageResponse, FlickerImageData> provideFlickerDataMapper(
            FlickerImageResponseMapper flickerImageResponseMapper) {
        return flickerImageResponseMapper;
    }

    @Provides
    @PerActivity
    RecycleFlickerImageAdapter provideAdapter() {
        return new RecycleFlickerImageAdapter(
                new FlickerImageDataProvider(Collections.<ImageEntryData>emptyList()));
    }

    @Provides
    @PerActivity
    BrowserNavigationCommand provideBrowserNavigationCommand(Activity activity) {
        return new BrowserNavigation(activity);
    }
}
