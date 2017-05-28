package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tigerspike.flickerimage.model.FlickerImageData;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import tigerspike.com.tgimagegallery.R;
import tigerspike.com.tgimagegallery.app.view.BaseFragment;
import tigerspike.com.tgimagegallery.flickerimage.adapter.RecycleFlickerImageAdapter;
import tigerspike.com.tgimagegallery.flickerimage.di.FlickerImageComponent;
import tigerspike.com.tgimagegallery.flickerimage.presentation.FlickerImageDownloadPresenter;

public class FlickerImageGalleryFragment extends BaseFragment implements FlickerImageView {

    public static final String TAG = FlickerImageGalleryFragment.class.getSimpleName();

    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;

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

        initGridLayout();

        imageDownloadPresenter.onViewCreated(this);
    }

    private void initGridLayout() {
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 4);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);

    }

    @OnClick(R.id.load_image_btn)
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

    @Override
    public void showErrorView() {

    }

    @Override
    public void populateGridView(FlickerImageData flickerImageData) {
        recyclerView.setAdapter(new RecycleFlickerImageAdapter(flickerImageData));
    }
}
