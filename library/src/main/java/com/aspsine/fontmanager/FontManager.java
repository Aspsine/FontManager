package com.aspsine.fontmanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aspsine on 16/1/20.
 */
public class FontManager {

    private static FontManager sInstance;

    private static Map<String, SoftReference<Typeface>> sTypefaceMap = new HashMap<>();

    public static FontManager getInstance() {
        if (sInstance == null) {
            synchronized (FontManager.class) {
                if (sInstance == null) {
                    sInstance = new FontManager();
                }
            }
        }
        return sInstance;
    }

    private FontManager() {
    }

    public void init(Context context, String[] fontAssetPaths) {
        Context applicationContext = context.getApplicationContext();
        AssetManager assetManager = applicationContext.getAssets();
        for (String path : fontAssetPaths) {
            add(assetManager, path);
        }
    }

    public Typeface getTypeface(AssetManager assetManager, String path) {
        Typeface typeface = null;
        SoftReference<Typeface> typefaceSoftReference = sTypefaceMap.get(path);
        if (typefaceSoftReference != null) {
            typeface = typefaceSoftReference.get();
        }
        if (typeface == null) {
            typeface = add(assetManager, path);
        }
        return typeface;
    }

    private Typeface add(AssetManager assetManager, String path) {
        Typeface typeface = Typeface.createFromAsset(assetManager, path);
        SoftReference<Typeface> typefaceSoftReference = new SoftReference<Typeface>(typeface);
        sTypefaceMap.put(path, typefaceSoftReference);
        return typeface;
    }

    private void remove(String path) {
        sTypefaceMap.remove(path);
    }

    private void clear(){
        sTypefaceMap.clear();
    }

}
