
package tigerspike.com.tgimagegallery.app.di.components;

import android.app.Activity;

import dagger.Component;
import tigerspike.com.tgimagegallery.app.PerActivity;
import tigerspike.com.tgimagegallery.app.di.modules.ActivityModule;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
