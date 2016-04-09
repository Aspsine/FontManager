package com.aspsine.fontmanager.demo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.fontmanager.FontManager;


/**
 * Created by aspsine on 16/1/20.
 */
public class FontsUtils {

    public static final int FONT_LANEHUM = 0;
    public static final int FONT_ORANGE_JUICE = 1;
    public static final int FONT_ORMONT_LIGHT = 2;
    public static final int FONT_WEDGIE_REGULAR = 3;

    private static final String[] FontPaths = {"fonts/Lanehum.ttf", "fonts/OrangeJuice.ttf", "fonts/OrmontLight.ttf", "fonts/WedgieRegular.ttf"};

    public static void init(Context context) {
        FontManager.getInstance().init(context, FontPaths);
    }

    public static void setFonts(TextView textView, int fontType) {
        AssetManager assetManager = textView.getContext().getApplicationContext().getAssets();
        textView.setTypeface(getTypeface(assetManager, fontType));
    }

    public static void setFonts(ViewGroup viewGroup, int fontType) {
        AssetManager assetManager = viewGroup.getContext().getApplicationContext().getAssets();
        Typeface typeface = getTypeface(assetManager, fontType);
        setFonts(viewGroup, typeface);
    }

    public static void setFonts(ViewGroup viewGroup, Typeface typeface) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface);
            } else if (view instanceof ViewGroup) {
                setFonts((ViewGroup) view, typeface);
            }
        }
    }

    public static Typeface getTypeface(AssetManager assetManager, int fontType) {
        String path = FontPaths[fontType];
        Typeface typeface = FontManager.getInstance().getTypeface(assetManager, path);
        return typeface;
    }
}
