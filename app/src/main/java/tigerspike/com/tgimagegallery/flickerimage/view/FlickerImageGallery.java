package tigerspike.com.tgimagegallery.flickerimage.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import tigerspike.com.tgimagegallery.R;
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
        addFragment(FlickerImageGalleryFragment.newInstance(), FlickerImageGalleryFragment.TAG);
    }

    private void initDaggerGraph() {
        flickerImageComponent = DaggerFlickerImageComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flicker_image_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public FlickerImageComponent getComponent() {
        return flickerImageComponent;
    }
}
