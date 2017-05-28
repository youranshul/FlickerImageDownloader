package tigerspike.com.tgimagegallery.flickerimage.di;

import dagger.Component;
import tigerspike.com.tgimagegallery.app.PerActivity;
import tigerspike.com.tgimagegallery.app.di.components.ActivityComponent;
import tigerspike.com.tgimagegallery.app.di.components.ApplicationComponent;
import tigerspike.com.tgimagegallery.app.di.modules.ActivityModule;
import tigerspike.com.tgimagegallery.flickerimage.view.FlickerImageGalleryFragment;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        FlickerImageModule.class})
public interface FlickerImageComponent extends ActivityComponent {

    void inject(FlickerImageGalleryFragment fragment);

}
