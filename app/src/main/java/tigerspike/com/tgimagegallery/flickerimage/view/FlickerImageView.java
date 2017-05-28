package tigerspike.com.tgimagegallery.flickerimage.view;

import com.tigerspike.flickerimage.model.FlickerImageData;

public interface FlickerImageView {

    void showProgressBar();

    void hideProgressBar();

    void showErrorView();

    void populateGridView(FlickerImageData flickerImageData);
}
