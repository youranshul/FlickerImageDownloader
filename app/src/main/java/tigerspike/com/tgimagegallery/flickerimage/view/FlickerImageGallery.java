package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;

import tigerspike.com.tgimagegallery.app.di.HasComponent;
import tigerspike.com.tgimagegallery.app.view.BaseActivity;
import tigerspike.com.tgimagegallery.flickerimage.di.DaggerFlickerImageComponent;
import tigerspike.com.tgimagegallery.flickerimage.di.FlickerImageComponent;

public class FlickerImageGallery extends BaseActivity implements
        HasComponent<FlickerImageComponent> {

    private FlickerImageComponent flickerImageComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDaggerGraph();
        if (savedInstanceState == null) {
            addFragment(new FlickerImageGalleryFragment(), FlickerImageGalleryFragment.TAG);
        }
    }

    private void initDaggerGraph() {
        flickerImageComponent = DaggerFlickerImageComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public FlickerImageComponent getComponent() {
        return flickerImageComponent;
    }
}
