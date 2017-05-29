package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

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
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    FlickerImageDownloadPresenter imageDownloadPresenter;
    @Inject
    RecycleFlickerImageAdapter recycleFlickerImageAdapter;
    @Inject
    BrowserNavigationCommand browserNavigationCommand;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initFlickerImageDependency();
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
            imageDownloadPresenter.loadFlickerImages();
        }
        initGridLayout();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_flicker_image_gallery, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reload) {
            imageDownloadPresenter.loadFlickerImages();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initGridLayout() {
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);
        recycleFlickerImageAdapter.setOnImageClickListener(this);
        recyclerView.setAdapter(recycleFlickerImageAdapter);

    }

    private void initFlickerImageDependency() {
        getComponent(FlickerImageComponent.class).inject(this);
    }

    @Override
    public void showProgressBar() {
        if (progressBar.getVisibility() == View.GONE) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgressBar() {
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorView() {
        if (getView() != null) {
            Snackbar.make(getView(), getString(R.string.error),
                    BaseTransientBottomBar.LENGTH_SHORT).show();
        }
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
