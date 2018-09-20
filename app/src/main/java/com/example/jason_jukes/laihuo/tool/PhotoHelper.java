package com.example.jason_jukes.laihuo.tool;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.View;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;

/**
 * Created by Mickey on 2017/8/28.
 * <p>
 * 调用系统相机和相册
 */

public class PhotoHelper {
    private View rootView;

    public PhotoHelper(View rootView) {
        this.rootView = rootView;
    }

    public static PhotoHelper of(View rootView, Context context) {
        return new PhotoHelper(rootView);
    }

    public void onCamera(View view, TakePhoto photo, int width, int height) {
        File file = new File(Environment.getExternalStorageDirectory(),
                "/temp" + System.currentTimeMillis() + ".jpg");

        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);

        configCompress(photo);
        configTakePhotoOption(photo);
//        photo.onPickFromCaptureWithCrop(imageUri, getCropOptions(width, height));
        photo.onPickFromCapture(imageUri);

    }

    public void onPicture(View view, TakePhoto photo, int width, int height) {
        File file = new File(Environment.getExternalStorageDirectory(),
                "/temp" + System.currentTimeMillis() + ".jpg");

        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);

        configCompress(photo);
        configTakePhotoOption(photo);

//        photo.onPickFromGalleryWithCrop(imageUri, getCropOptions(width, height));
        photo.onPickFromGallery();

    }

    //裁剪图片属性
    private CropOptions getCropOptions(int width, int height) {
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(width).setAspectY(height);//裁剪时的尺寸比例
        builder.setWithOwnCrop(true);//s使用第三方还是takephoto自带的裁剪工具
        return builder.create();
    }

    //配置图片属性
    private void configTakePhotoOption(TakePhoto photo) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);//使用自带相册
        builder.setCorrectImage(true);//纠正旋转角度
        photo.setTakePhotoOptions(builder.create());
    }

    //    配置压缩
    private void configCompress(TakePhoto takePhoto) {
        CompressConfig config = new CompressConfig.Builder()
                .setMaxSize(1024000)//大小不超过1000k
                .setMaxPixel(1200)//最大像素1200
                .enableReserveRaw(true)//是否压缩
                .create();
        takePhoto.onEnableCompress(config, true);//这个trued代表显示压缩进度条
    }
}