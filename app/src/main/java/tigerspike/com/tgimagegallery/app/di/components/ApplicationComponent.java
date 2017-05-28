package tigerspike.com.tgimagegallery.app.di.components;

import android.content.Context;

import com.tigerspike.interactor.PostExecutionThread;
import com.tigerspike.network.RetrofitServiceFactory;

import javax.inject.Singleton;

import dagger.Component;
import tigerspike.com.tgimagegallery.app.di.modules.ApplicationModule;
import tigerspike.com.tgimagegallery.app.view.BaseActivity;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    PostExecutionThread postExecutionThread();

    RetrofitServiceFactory retrofit();
}