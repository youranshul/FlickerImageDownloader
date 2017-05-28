package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.navigation.BrowserNavigationCommand;

import javax.inject.Inject;

import butterknife.Bind;
import tigerspike.com.tgimagegallery.R;
import tigerspike.com.tgimagegallery.app.view.BaseFragment;
import tigerspike.com.tgimagegallery.flickerimage.OnImageClickListener;
import tigerspike.com.tgimagegallery.flickerimage.adapter.RecycleFlickerImageAdapter;
import tigerspike.com.tgimagegallery.flickerimage.di.FlickerImageComponent;
import tigerspike.com.tgimagegallery.flickerimage.presentation.FlickerImageDownloadPresenter;

public class FlickerImageGalleryFragment extends BaseFragment implements FlickerImageView,
        OnImageClickListener {
    public static final String TAG = FlickerImageGalleryFragment.class.getSimpleName();

    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;

    @Inject
    FlickerImageDownloadPresenter imageDownloadPresenter;
    @Inject
    RecycleFlickerImageAdapter recycleFlickerImageAdapter;
    @Inject
    BrowserNavigationCommand browserNavigationCommand;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFlickerImageDependency();
    }

    public FlickerImageGalleryFragment() {
        setRetainInstance(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.content_flicker_image_gallery;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDownloadPresenter.onViewCreated(this);
        if (savedInstanceState == null) {
            imageDownloadPresenter.onLoadImageButtonClicked();
        }
        initGridLayout();
    }

    private void initGridLayout() {
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);
        recycleFlickerImageAdapter.setOnImageClickListener(this);
        recyclerView.setAdapter(recycleFlickerImageAdapter);


    }

    /*  @OnClick(R.id.load_image_btn)
      public void loadImageClicked() {
          imageDownloadPresenter.onLoadImageButtonClicked();
      }
  */
    private void initFlickerImageDependency() {
        getComponent(FlickerImageComponent.class).inject(this);
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
        recycleFlickerImageAdapter.refreshData(flickerImageData);
    }

    @Override
    public void onImageClick(String imageUrl) {
        browserNavigationCommand.setImageUrl(imageUrl);
        browserNavigationCommand.navigate();
    }
}
