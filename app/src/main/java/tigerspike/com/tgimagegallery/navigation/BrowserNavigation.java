package tigerspike.com.tgimagegallery.navigation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.tigerspike.navigation.BrowserNavigationCommand;

public class BrowserNavigation implements BrowserNavigationCommand {
    private final Activity activity;
    private String imageUrl;

    public BrowserNavigation(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void navigate() {
        if (activity != null && imageUrl != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(imageUrl));
            activity.startActivity(intent);
        }
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
