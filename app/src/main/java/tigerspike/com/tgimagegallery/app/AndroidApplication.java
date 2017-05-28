package tigerspike.com.tgimagegallery.app;

import android.app.Application;

import tigerspike.com.tgimagegallery.app.di.components.ApplicationComponent;
import tigerspike.com.tgimagegallery.app.di.components.DaggerApplicationComponent;
import tigerspike.com.tgimagegallery.app.di.modules.ApplicationModule;

public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
