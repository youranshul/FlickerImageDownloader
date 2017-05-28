package tigerspike.com.tgimagegallery.flickerimage.presentation;

import com.tigerspike.flickerimage.model.FlickerImageData;
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
        //TODO this is giving unchecked exception check why?
        imageDownloadInteractor.execute(new DefaultObserver<FlickerImageData>() {
            @Override
            public void onError(Throwable e) {
                view.hideProgressBar();
                view.showErrorView();
            }

            @Override
            public void onNext(FlickerImageData flickerImageData) {
                view.hideProgressBar();
                view.populateGridView(flickerImageData);
            }
        }, null);
    }
}
