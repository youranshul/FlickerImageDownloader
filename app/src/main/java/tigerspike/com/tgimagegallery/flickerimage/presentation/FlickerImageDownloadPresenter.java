package tigerspike.com.tgimagegallery.flickerimage.presentation;

import com.tigerspike.interactor.DefaultObserver;
import com.tigerspike.interactor.Interactor;

import javax.inject.Inject;

import tigerspike.com.tgimagegallery.flickerimage.view.FlickerImageView;

public class FlickerImageDownloadPresenter {

    private final Interactor imageDownloadInteractor;
    private FlickerImageView view;

    @Inject
    public FlickerImageDownloadPresenter(Interactor imageDownloadInteractor) {
        this.imageDownloadInteractor = imageDownloadInteractor;
    }

    public void onViewCreated(FlickerImageView view) {
        this.view = view;
    }

    public void onLoadImageButtonClicked() {
        imageDownloadInteractor.execute(new DefaultObserver() {
            @Override
            public void onError(Throwable e) {

            }
        }, null);
    }
}
