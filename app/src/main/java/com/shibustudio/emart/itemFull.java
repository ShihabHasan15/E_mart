package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class itemFull extends AppCompatActivity {
    public static ImageView fullImage;
    ArrayList<SlideModel> fullImageList = new ArrayList<>();
    TextView titleText, category, warranty, shipping, availability;
    TextView short_title;
    public static String short_title_text = "", category_txt = "", warranty_txt = "", shipping_txt = "",
    availbility_info = "";
    RatingBar rate;
    static ImageView img1, img2, img3;
    public static String slide1 = "",slide2 = "",slide3 = "";
    ImageButton back_button;
    MaterialButton buy_button, wishlist_button;
    public static String TITLE = "";
    public static String DES = "";
    public static String image = "";
    public static float rating = 0;
    public static ArrayList<String> IMAGE_LINKS = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemfull);



        fullImage = findViewById(R.id.fullImage);
        titleText = findViewById(R.id.titleText);
        back_button = findViewById(R.id.back_button);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        rate = findViewById(R.id.rating);
        short_title = findViewById(R.id.short_title);
        category = findViewById(R.id.category);
        warranty = findViewById(R.id.waranty);
        shipping = findViewById(R.id.shipping);
        availability = findViewById(R.id.availability);

        buy_button = findViewById(R.id.buy_button);
        wishlist_button = findViewById(R.id.wishlist_button);



        Animation scaleAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_button);

        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        wishlist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
                wishlist_button.setText("Added");
                wishlist_button.setIconResource(R.drawable.filled_love);
            }
        });


        rate.setRating(rating);
        short_title.setText(short_title_text);
        category.setText(category_txt);
        warranty.setText(warranty_txt);
        shipping.setText(shipping_txt);
        availability.setText(availbility_info);



        Picasso.get().load(slide1)
                        .into(img1);

        if (!slide2.isEmpty()){
            Picasso.get().load(slide2)
                    .into(img2);
        } else if (slide2.isEmpty()) {
            Picasso.get().load(slide1)
                    .into(img2);
        }


        if (!slide3.isEmpty()){
            Picasso.get().load(slide3)
                    .into(img3);
        } else if (slide3.isEmpty()) {
            Picasso.get().load(slide1)
                    .into(img3);
        }


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        titleText.setText(TITLE);

        Picasso.get().load(image)
                .into(fullImage);


    }



//    public class adapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return home_frag.review_list.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            return null;
//        }
//    }
}