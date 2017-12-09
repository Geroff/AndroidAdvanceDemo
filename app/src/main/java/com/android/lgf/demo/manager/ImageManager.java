package com.android.lgf.demo.manager;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by lgf on 17-12-10.
 */

public class ImageManager {
    public static final int MAX_CACHE_SIZE = 50;
    private static volatile ImageManager instance = null;
    private LruCache<String, Bitmap> cache;

    private ImageManager() {
        cache = new LruCache<String, Bitmap>(MAX_CACHE_SIZE);
    }

    public static ImageManager getInstance() {
        if (instance == null) {
            synchronized (ImageManager.class) {
                if (instance == null) {
                    instance = new ImageManager();
                }
            }
        }

        return instance;
    }

    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }

    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }
}
