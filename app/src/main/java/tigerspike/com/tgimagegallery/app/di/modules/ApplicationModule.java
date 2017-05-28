package tigerspike.com.tgimagegallery.app.di.modules;

import android.content.Context;

import com.tigerspike.interactor.PostExecutionThread;
import com.tigerspike.network.ConfigurableRetrofitServiceFactory;
import com.tigerspike.network.RetrofitServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tigerspike.com.tgimagegallery.app.AndroidApplication;
import tigerspike.com.tgimagegallery.app.UiThread;

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    RetrofitServiceFactory provideRetrofitService(
            ConfigurableRetrofitServiceFactory retrofitServiceFactory) {
        return retrofitServiceFactory;
    }
}
