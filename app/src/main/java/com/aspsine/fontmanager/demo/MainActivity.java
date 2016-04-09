package com.aspsine.fontmanager.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (ViewGroup) findViewById(R.id.container);

        Button btnFontOne = (Button) findViewById(R.id.btnFontOne);
        Button btnFontTwo = (Button) findViewById(R.id.btnFontTwo);
        Button btnFontThree = (Button) findViewById(R.id.btnFontThree);
        Button btnFontFour = (Button) findViewById(R.id.btnFontFour);

        FontsUtils.setFonts(btnFontOne, FontsUtils.FONT_LANEHUM);
        FontsUtils.setFonts(btnFontTwo, FontsUtils.FONT_ORANGE_JUICE);
        FontsUtils.setFonts(btnFontThree, FontsUtils.FONT_ORMONT_LIGHT);
        FontsUtils.setFonts(btnFontFour, FontsUtils.FONT_WEDGIE_REGULAR);

        btnFontOne.setOnClickListener(this);
        btnFontTwo.setOnClickListener(this);
        btnFontThree.setOnClickListener(this);
        btnFontFour.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFontOne:
                FontsUtils.setFonts(container, FontsUtils.FONT_LANEHUM);
                break;
            case R.id.btnFontTwo:
                FontsUtils.setFonts(container, FontsUtils.FONT_ORANGE_JUICE);
                break;
            case R.id.btnFontThree:
                FontsUtils.setFonts(container, FontsUtils.FONT_ORMONT_LIGHT);
                break;
            case R.id.btnFontFour:
                FontsUtils.setFonts(container, FontsUtils.FONT_WEDGIE_REGULAR);
                break;

        }
    }
}
