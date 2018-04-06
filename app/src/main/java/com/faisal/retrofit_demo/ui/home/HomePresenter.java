package com.faisal.retrofit_demo.ui.home;

import android.content.Context;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;

import com.faisal.retrofit_demo.base.BasePresenter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;





public class HomePresenter extends BasePresenter<HomeMvpView> {
    private final String TAG = getClass().getName();
    private HomeMvpView loginMvpView;
    private Context mContext;

    public HomePresenter(Context context) {
        mContext = context;
    }



    public File createImageFile() throws IOException {

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String imageFileName = "IMG_" + timeStamp;

        File storageDirectory =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        try {
            storageDirectory.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return File.createTempFile(imageFileName, ".jpg", storageDirectory);
    }
}
