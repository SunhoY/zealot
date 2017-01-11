package io.harry.zealot.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.harry.zealot.R;

public class MenuActivity extends ZealotBaseActivity {
    public static final int PICK_PHOTO = 9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_button)
    public void onStartClick() {
        startActivity(new Intent(this, TestAjaeActivity.class));
    }

    @OnClick(R.id.upload_button)
    public void onUploadClick() {
        startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), PICK_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri selectedImage = data.getData();
        Cursor cursor = getContentResolver().query(selectedImage, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
        String decodableImage = "";
        if(cursor.moveToFirst()) {
            decodableImage = cursor.getString(0);
        }

        cursor.close();

        Bitmap imageSource = BitmapFactory.decodeFile(decodableImage);
        Bitmap.createScaledBitmap(imageSource, )

    }
}
