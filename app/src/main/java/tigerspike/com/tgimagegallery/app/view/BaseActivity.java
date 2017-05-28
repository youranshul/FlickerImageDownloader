package tigerspike.com.tgimagegallery.app.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import tigerspike.com.tgimagegallery.R;
import tigerspike.com.tgimagegallery.app.AndroidApplication;
import tigerspike.com.tgimagegallery.app.di.components.ApplicationComponent;
import tigerspike.com.tgimagegallery.app.di.modules.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    @Bind(R.id.fragment_container)
    ViewGroup fragmentContainer;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected int getLayoutId() {
        return R.layout.flicker_image_gallery;
    }

    protected void addFragment(final Fragment fragment, final String tag) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer.getId(), fragment, tag);
        transaction.commit();
    }
}