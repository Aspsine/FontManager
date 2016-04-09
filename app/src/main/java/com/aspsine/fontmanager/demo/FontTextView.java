package com.aspsine.fontmanager.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by aspsine on 15/12/26.
 */
public class FontTextView extends TextView {

    public FontTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontTextView, defStyleAttr, 0);
        try {
            final int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.FontTextView_textFont) {
                    int defaultValue = FontsUtils.FONT_LANEHUM;
                    int textFont = a.getInt(attr, defaultValue);
                    if (!isInEditMode()) {
                        FontsUtils.setFonts(this, textFont);
                    }
                    // only 1 attrs
                    // simply break jump the loop
                    break;
                }
            }
        } finally {
            a.recycle();
        }
    }

}
