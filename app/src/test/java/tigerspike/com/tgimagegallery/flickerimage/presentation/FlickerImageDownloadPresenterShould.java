package tigerspike.com.tgimagegallery.flickerimage.presentation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.tigerspike.flickerimage.model.FlickerImageData;
import com.tigerspike.flickerimage.model.NoRequest;
import com.tigerspike.interactor.Interactor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.observers.DisposableObserver;
import tigerspike.com.tgimagegallery.flickerimage.view.FlickerImageView;

public class FlickerImageDownloadPresenterShould {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Interactor<FlickerImageData, NoRequest> flickerImageDownloadInteractor;
    @Mock
    private FlickerImageView flickerImageView;

    private FlickerImageDownloadPresenter flickerImageDownloadPresenter;

    @Before
    public void setup() {
        flickerImageDownloadPresenter = new FlickerImageDownloadPresenter(
                flickerImageDownloadInteractor);
        flickerImageDownloadPresenter.onViewCreated(flickerImageView);
    }

    @Test
    public void executeImageDownloadRequest() {
        flickerImageDownloadPresenter.loadFlickerImages();

        verify(flickerImageDownloadInteractor).execute(any(DisposableObserver.class),
                any(NoRequest.class));
    }
}