package io.harry.zealot.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import org.assertj.android.api.content.IntentAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import io.harry.zealot.BuildConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.RuntimeEnvironment.application;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MenuActivityTest {
    public static final int PICK_PHOTO = 9;
    private MenuActivity subject;

    @Before
    public void setUp() throws Exception {
        subject = Robolectric.setupActivity(MenuActivity.class);
    }

    @Test
    public void onStartClick_startsTestAjaeActivity() throws Exception {
        subject.onStartClick();

        IntentAssert intentAssert = new IntentAssert(shadowOf(subject).getNextStartedActivity());
        intentAssert.hasComponent(application, TestAjaeActivity.class);
    }

    @Test
    public void onUploadAjae_launchesGalleryAppToPickPhoto() throws Exception {
        subject.onUploadClick();

        ShadowActivity.IntentForResult actual = shadowOf(subject).getNextStartedActivityForResult();

        assertThat(actual.requestCode).isEqualTo(PICK_PHOTO);

        IntentAssert intentAssert = new IntentAssert(actual.intent);

        intentAssert.hasAction(Intent.ACTION_PICK);
        intentAssert.hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    @Test
    public void onActivityResult_createsBitmapImageFromURI() throws Exception {
        Intent data = new Intent();
        Uri uri = new Uri.Builder().build();
        data.setData(uri);

        subject.onActivityResult(PICK_PHOTO, Activity.RESULT_OK, data);
        

    }
}