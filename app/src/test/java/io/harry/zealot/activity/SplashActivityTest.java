package io.harry.zealot.activity;

import android.view.View;
import android.view.animation.Animation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.harry.zealot.BuildConfig;
import io.harry.zealot.R;
import io.harry.zealot.ZealotBaseTest;
import io.harry.zealot.wrapper.AnimationHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SplashActivityTest extends ZealotBaseTest {
    private SplashActivity subject;

    @BindView(R.id.view_container)
    View viewContainer;

    @Inject
    AnimationHelper mockAnimationHelper;

    @Mock
    Animation mockAnimation;

    @Before
    public void createActivity() throws Exception {
        MockitoAnnotations.initMocks(this);

        subject = Robolectric.buildActivity(SplashActivity.class).create().visible().get();
        zealotComponent.inject(this);
        ButterKnife.bind(this, subject);

        when(mockAnimationHelper.loadAnimation(anyInt())).thenReturn(mockAnimation);
    }

    @Test
    public void onResume_loadsFadeOutAnimationFromAnimationWrapper() throws Exception {
        subject.onResume();

        verify(mockAnimationHelper).loadAnimation(R.anim.fade_out);
    }

    @Test
    public void afterLoadingAnimation_setsAnimationListenerAsSubject() throws Exception {
        when(mockAnimationHelper.loadAnimation(R.anim.fade_out)).thenReturn(mockAnimation);

        subject.onResume();

        verify(mockAnimation).setAnimationListener(subject);
    }

    @Test
    public void onResume_startsAnimationOnViewContainer() throws Exception {
        subject.onResume();

        verify(mockAnimationHelper).startAnimation(viewContainer, mockAnimation);
    }

    @Test
    public void onAnimationEnd_setsVisibilityOfViewContainerAsGone() throws Exception {
        subject.onAnimationEnd(mock(Animation.class));

        assertThat(viewContainer.getVisibility()).isEqualTo(View.GONE);
    }

    @Test
    public void onAnimationEnd_finishesActivity() throws Exception {
        subject.onAnimationEnd(mock(Animation.class));

        assertThat(subject.isFinishing()).isTrue();
    }
}