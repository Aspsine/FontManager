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

    /**
     * load fonts into memory, this may take some times.
     *
     * @param context        activity&application&service context
     * @param fontAssetPaths array of paths in asserts
     */
    public void init(Context context, String[] fontAssetPaths) {
        Context applicationContext = context.getApplicationContext();
        AssetManager assetManager = applicationContext.getAssets();
        for (String path : fontAssetPaths) {
            add(assetManager, path);
        }
    }

    /**
     * Get the Typeface. If it hasn't been cached, cache it then return it.
     *
     * @param assetManager {@link AssetManager}
     * @param path         Font path in asserts folder
     * @return The Typeface associated with path
     */
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

    public void remove(String path) {
        sTypefaceMap.remove(path);
    }

    public void clear() {
        sTypefaceMap.clear();
    }

}
