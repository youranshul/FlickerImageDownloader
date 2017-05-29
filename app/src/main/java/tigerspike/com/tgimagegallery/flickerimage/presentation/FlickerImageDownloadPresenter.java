package tigerspike.com.tgimagegallery.flickerimage.presentation;

import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.NoRequest;
import com.tigerspike.interactor.Interactor;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import tigerspike.com.tgimagegallery.app.PerActivity;
import tigerspike.com.tgimagegallery.flickerimage.view.FlickerImageView;

@PerActivity
public class FlickerImageDownloadPresenter {

    private final Interactor<FlickerImageData, NoRequest> imageDownloadInteractor;
    private FlickerImageView view;

    @Inject
    public FlickerImageDownloadPresenter(Interactor imageDownloadInteractor) {
        this.imageDownloadInteractor = imageDownloadInteractor;
    }

    public void onViewCreated(FlickerImageView view) {
        this.view = view;
    }

    public void loadFlickerImages() {
        view.showProgressBar();
        imageDownloadInteractor.execute(new FlickerImageObserver(), new NoRequest());
    }

    private class FlickerImageObserver extends DisposableObserver<FlickerImageData> {

        @Override
        public void onNext(FlickerImageData flickerImageData) {
            view.populateGridView(flickerImageData);
        }

        @Override
        public void onError(Throwable e) {
            view.hideProgressBar();
            view.showErrorView();
        }

        @Override
        public void onComplete() {
            view.hideProgressBar();
        }
    }
}
