package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickCountRedPixels(View view)
    {
        // get the bitmap from the image view widget
        ImageView ringImage = (ImageView) findViewById(R.id.imageView);
        ringImage.invalidate();
        BitmapDrawable drawable = (BitmapDrawable)ringImage.getDrawable();
        Bitmap bitmapImage = drawable.getBitmap();


        // create RingDetector object and set bitmap based on the one chosen
        PixelDetectorDemo pixelDetectorDemo = new PixelDetectorDemo(bitmapImage);


        // do method based on counting "yellow pixels"
        int nRedPixels = 0;
        int nPixThreshRed = 100;
        int nPixThreshBlueGreen = 100;
        nRedPixels = pixelDetectorDemo.countRedPixels(bitmapImage, nPixThreshRed, nPixThreshBlueGreen);


        // set it in the text output
        String strNumRedPixels = String.format("Number of red pixels: %d.", nRedPixels);
        TextView editText = (TextView)findViewById(R.id.NumberRedPixels);
        editText.setText(strNumRedPixels);
    }
}