package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import javax.inject.Inject;

import butterknife.OnClick;
import tigerspike.com.tgimagegallery.R;
import tigerspike.com.tgimagegallery.app.view.BaseFragment;
import tigerspike.com.tgimagegallery.flickerimage.di.FlickerImageComponent;
import tigerspike.com.tgimagegallery.flickerimage.presentation.FlickerImageDownloadPresenter;

public class FlickerImageGalleryFragment extends BaseFragment implements FlickerImageView {

    public static final String TAG = FlickerImageGalleryFragment.class.getSimpleName();

    @Inject
    FlickerImageDownloadPresenter imageDownloadPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.content_flicker_image_gallery;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFlickerImageDependency();

        imageDownloadPresenter.onViewCreated(this);
    }

    @OnClick(R.id.btn_load_image)
    public void loadImageClicked() {
        imageDownloadPresenter.onLoadImageButtonClicked();
    }

    private void initFlickerImageDependency() {
        getComponent(FlickerImageComponent.class).inject(this);
    }

    public static Fragment newInstance() {
        return new FlickerImageGalleryFragment();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
