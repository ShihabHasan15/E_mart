package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

public class Place_order extends AppCompatActivity {
    RadioGroup payment_methods;
    RadioButton bkash_button, nagad_button, home_cash_button;
    MaterialCardView bkash, nagad, home_cash;
    MaterialButton place_order;
    TextView base_price, discount, discounted_price, delivery_charge, total_price, order_title;
    ImageView order_img, backArrow;
    boolean clicked = false;
    public static int d_price = 0, delivery_charge_amount=100, t_price=0;
    public static double b_price=0, discount_amount=0;
    public static String product_title = "", order_image = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        payment_methods = findViewById(R.id.payment_methods);

        bkash_button = findViewById(R.id.bkash_button);
        nagad_button = findViewById(R.id.nagad_button);
        home_cash_button = findViewById(R.id.home_cash_button);

        bkash = findViewById(R.id.bkash);
        nagad = findViewById(R.id.nagad);
        home_cash = findViewById(R.id.home_cash);

        place_order = findViewById(R.id.place_order);

        base_price = findViewById(R.id.base_price);
        discount = findViewById(R.id.discount);
        discounted_price = findViewById(R.id.discounted_price);
        delivery_charge = findViewById(R.id.delivery_charge);
        total_price = findViewById(R.id.total_price);
        order_title = findViewById(R.id.order_title);
        order_img = findViewById(R.id.order_img);
        backArrow = findViewById(R.id.backArrow);

        Animation scaleAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_button);


        int total_payable = t_price + delivery_charge_amount;

        String dis_amount = String.format("%.2f", discount_amount);

        base_price.setText(""+b_price);
        discount.setText(""+dis_amount);
        discounted_price.setText(""+t_price);
        delivery_charge.setText(""+delivery_charge_amount);
        total_price.setText(""+total_payable);


        order_title.setText(product_title);

        Picasso.get().load(order_image)
                        .into(order_img);




        bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bkash_button.setChecked(true);
                nagad_button.setChecked(false);
                home_cash_button.setChecked(false);
                v.startAnimation(scaleAnimation);
                clicked = true;
            }
        });

        nagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nagad_button.setChecked(true);
                bkash_button.setChecked(false);
                home_cash_button.setChecked(false);
                v.startAnimation(scaleAnimation);
                clicked = true;
            }
        });

        home_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_cash_button.setChecked(true);
                bkash_button.setChecked(false);
                nagad_button.setChecked(false);
                v.startAnimation(scaleAnimation);
                clicked = true;
            }
        });

        payment_methods.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);

            }
        });




        place_order.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            if (clicked==true){

                if (bkash_button.isChecked()) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast_file, null);
                    toastView.setBackgroundColor(R.color.red);

                    TextView toast_txt = toastView.findViewById(R.id.toast_txt);

                    toast_txt.setText("Bkash service is unavailable right now !");
                    toast.setView(toastView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                } else if (nagad_button.isChecked()) {

                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast_file, null);
                    toastView.setBackgroundColor(R.color.red);

                    TextView toast_txt = toastView.findViewById(R.id.toast_txt);

                    toast_txt.setText("Nagad service is unavailable right now !");
                    toast.setView(toastView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();

                }else {

                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast_file, null);

                    toast.setView(toastView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();

                    finish();

                }
            }else {

                Toast toast = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View toastView = inflater.inflate(R.layout.toast_file, null);
                toastView.setBackgroundColor(R.color.red);

                TextView toast_txt = toastView.findViewById(R.id.toast_txt);

                toast_txt.setText("Please select an payment method");
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

            }


            }
        });



        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}