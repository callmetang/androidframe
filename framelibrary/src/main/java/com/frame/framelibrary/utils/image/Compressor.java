package com.frame.framelibrary.utils.image;

import android.content.Context;
import android.graphics.Bitmap;

import com.frame.framelibrary.utils.LogUtil;

import java.io.File;
import java.io.IOException;

/**
 * 图片压缩
 */
public class Compressor {
    //max width and height values of the compressed image is taken as 612x816
    private int maxWidth = 612;
    private int maxHeight = 816;
    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private int quality = 80;
    private String destinationDirectoryPath;

    public Compressor(Context context) {
//        destinationDirectoryPath = context.getCacheDir().getPath() + File.separator + "images";
        destinationDirectoryPath = new File(context.getExternalCacheDir(), "images").getPath();
        LogUtil.d("destinationDirectoryPath = " + destinationDirectoryPath);
    }

    public Compressor setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Compressor setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public Compressor setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
        return this;
    }

    public Compressor setQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public Compressor setDestinationDirectoryPath(String destinationDirectoryPath) {
        this.destinationDirectoryPath = destinationDirectoryPath;
        return this;
    }

    public File compressToFile(File imageFile) throws IOException {
        return compressToFile(imageFile, imageFile.getName());
    }

    public File compressToFile(File imageFile, String compressedFileName) throws IOException {
        return ImageUtils.compressImage(imageFile, maxWidth, maxHeight, compressFormat, quality,
                destinationDirectoryPath + File.separator + compressedFileName);
    }

    public Bitmap compressToBitmap(File imageFile) throws IOException {
        return ImageUtils.decodeSampledBitmapFromFile(imageFile, maxWidth, maxHeight);
    }
}
