package com.example.demo1;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.io.FileOutputStream;
import java.io.IOException;
public class PixelDetectorDemo {

    // member variables
    Bitmap image = null;
    String m_strOutputPath = "tempPath";
    int n_redPixelCount = 0;


    // constructor
    public PixelDetectorDemo(Bitmap ringImage) {

        // deep copy to make new bitmap owned by ring detector class
        image = Bitmap.createBitmap(ringImage);

    }


    // function to return the number of pixels based on the bitmap
    public int countRedPixels (Bitmap image, int redThreshold, int blueGreenThreshold) {

        //creating variables to store pixels count
        int nR = 0;
        int nG = 0;
        int nB = 0;

        // creating variables to store ratios\
        int nRedPixel = 0;
        int nCurrentPixel = 0;

        //creating image variables
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();


        //looping through all pixels and counting the number of pixels with r, g, or, b above
        // thresholds
        for (int i = 0; i < imageHeight; i++) {
            for (int j = 0; j < imageWidth; j++) {

                //get pixel value
                nCurrentPixel = image.getPixel(j, i);
                nR = Color.red(nCurrentPixel);
                nG = Color.green(nCurrentPixel);
                nB = Color.blue(nCurrentPixel);

                if ((nR > redThreshold) && (nG < blueGreenThreshold) && (nB < blueGreenThreshold)) {
                    nRedPixel++;
                }
            }
        }
        return nRedPixel;
    }
}