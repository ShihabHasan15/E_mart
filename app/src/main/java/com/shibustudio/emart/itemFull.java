package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class itemFull extends AppCompatActivity {
    public static ImageView fullImage;
    ArrayList<SlideModel> fullImageList = new ArrayList<>();
TextView titleText;
    public static String TITLE = "";
    public static String DES = "";
    public static Bitmap fullimage = null;
    public static ArrayList<String> IMAGE_LINKS = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemfull);



        fullImage = findViewById(R.id.fullImage);
        titleText = findViewById(R.id.titleText);

        titleText.setText(TITLE);

        if (fullimage!=null){
            fullImage.setImageBitmap(fullimage);
        }

    }
}