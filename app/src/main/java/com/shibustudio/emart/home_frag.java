package com.shibustudio.emart;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphTextView;

public class home_frag extends Fragment {
ImageSlider imageSlider;
RecyclerView recycle;
static int added_item = 0;
LinearLayout delivery, grocery, gadgets, home_appliances, gym, womens_item, mens_item, cosmetics;
HashMap<String, String> hashMap;
public static ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
NeumorphTextView popular;
HashMap<Integer, String> imageMap;
public static ArrayList<HashMap<Integer, String>> imageLinks = new ArrayList<>();
ArrayList<SlideModel> imageList = new ArrayList<>();
ProgressBar progress;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_home_frag, container, false);


        recycle = myView.findViewById(R.id.recycle);

        progress = myView.findViewById(R.id.progress);

        delivery = myView.findViewById(R.id.delivery);
        grocery = myView.findViewById(R.id.grocery);
        gadgets = myView.findViewById(R.id.gadgets);
        home_appliances = myView.findViewById(R.id.home_appliances);
        gym = myView.findViewById(R.id.gym);
        womens_item = myView.findViewById(R.id.womens_item);
        mens_item = myView.findViewById(R.id.mens_item);
        cosmetics = myView.findViewById(R.id.cosmetics);
        popular = myView.findViewById(R.id.popular);

        Animation scaleAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_button);
        Animation popular_anim = AnimationUtils.loadAnimation(getContext(), R.anim.popular_anim);
        Animation breath_anim = AnimationUtils.loadAnimation(getContext(), R.anim.breath_anim);

        popular.startAnimation(popular_anim);

        int endColor = ContextCompat.getColor(getContext(), R.color.myColor);


        try {
            ObjectAnimator colorAnim = ObjectAnimator.ofObject(popular, "backgroundColor", new ArgbEvaluator(), Color.RED, endColor);
            colorAnim.setDuration(2000);
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        delivery.startAnimation(breath_anim);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
//                delivery.startAnimation(breath_anim);
            }
        });

        grocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        gadgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        home_appliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        womens_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

        mens_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });
        
        cosmetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scaleAnimation);
            }
        });

//rest api data fetching==================================================

        RequestQueue queue = Volley.newRequestQueue(getContext());

        String url = "https://dummyjson.com/products";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                progress.setVisibility(View.GONE);

                try {
                    JSONArray products = response.getJSONArray("products");

                    for (int i=0; i<products.length(); i++){

                        JSONObject item_info = products.getJSONObject(i);

//                        imageMap = new HashMap<>();

                        String title = item_info.getString("title");
                        String des = item_info.getString("description");
//                        String brand = item_info.getString("brand");
                        String category = item_info.getString("category");
                        String thumbnail = item_info.getString("thumbnail");

                        int id = item_info.getInt("id");
                        double price = item_info.getDouble("price");
                        double discount_percent = item_info.getDouble("discountPercentage");
                        double rating = item_info.getDouble("rating");
                        int stock = item_info.getInt("stock");

                        JSONArray product_images = item_info.getJSONArray("images");

                        for (int j=0; j<product_images.length(); j++){
                            String image = product_images.getString(j);
                        }


                        //putting data with hashmap and arraylist
                        hashMap = new HashMap<>();

                        hashMap.put("title", ""+title);
                        hashMap.put("description", ""+des);
//                        hashMap.put("brand", ""+brand);
                        hashMap.put("category", ""+category);
                        hashMap.put("thumbnail", ""+thumbnail);

                        hashMap.put("id", ""+id);
                        hashMap.put("price", ""+price);
                        hashMap.put("discountPercentage", ""+discount_percent);
                        hashMap.put("rating", ""+rating);
                        hashMap.put("stock", ""+stock);



//                        for (int j=0; j<product_images.length(); j++){
////                            imageMap.put(j, product_images.getString(j));
//                        }



                        arrayList.add(hashMap);
                    }



                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //recyclerview===============================================================


                recycleAdapter adapter = new recycleAdapter();
                recycle.setAdapter(adapter);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

                recycle.setLayoutManager(gridLayoutManager);

                //recyclerview ends==========================================================
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progress.setVisibility(View.GONE);
            }
        });

        queue.add(jsonObjectRequest);

//rest api data fetching ends=============================================




//image slider=================================================================

        imageSlider = myView.findViewById(R.id.image_slider);

        imageList.add(new SlideModel(R.drawable.pic_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_three, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_four, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_five, ScaleTypes.FIT));

//        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT);

        imageSlider.setImageList(imageList, ScaleTypes.FIT);

//image slider ends========================================================

        return myView;
    }



//All item adapter



    public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.recycleViewHolder>{
        ImageView product_image;
        public class recycleViewHolder extends RecyclerView.ViewHolder{
            TextView product_name,brand_name, description, stock, price, previous, rating, cart_text;
            NeumorphCardView cart_btn;
            MaterialCardView full_card;

            public recycleViewHolder(@NonNull View itemView) {
                super(itemView);

                cart_btn = itemView.findViewById(R.id.cart_btn);
                product_image = itemView.findViewById(R.id.product_image);
                full_card = itemView.findViewById(R.id.full_card);
                cart_text = itemView.findViewById(R.id.cart_text);

                product_name = itemView.findViewById(R.id.product_name);
                brand_name = itemView.findViewById(R.id.brand_name);
                description = itemView.findViewById(R.id.description);
                stock = itemView.findViewById(R.id.stock);
                price = itemView.findViewById(R.id.price);
                previous = itemView.findViewById(R.id.previous);
                rating = itemView.findViewById(R.id.rating);

//                LinearLayout product_body = itemView.findViewById(R.id.product_body);

            }
        }
        @NonNull
        @Override
        public recycleAdapter.recycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View inflateView = inflater.inflate(R.layout.item_design, parent, false);

            return new recycleViewHolder(inflateView);
        }

        @Override
        public void onBindViewHolder(@NonNull recycleAdapter.recycleViewHolder holder, int position) {

            HashMap<String, String> getdata = arrayList.get(position);
//            HashMap<Integer, String> getImages = imageLinks.get(position);

            String title = getdata.get("title");
            String description = getdata.get("description");
//            String brand = getdata.get("brand");
            String thumbnail = getdata.get("thumbnail");

            String image1 = getdata.get("img1");
            String image2 = getdata.get("img2");
            String image3 = getdata.get("img3");
            String image4 = getdata.get("img4");
            String image5 = getdata.get("img5");

            String rating = getdata.get("rating");
            String stock = getdata.get("stock");
            double previous_price = Double.parseDouble(getdata.get("price"));
            double discountPercent = Double.parseDouble(getdata.get("discountPercentage"));

            int discount_price = (int) (previous_price*(discountPercent/100));

            int final_price = (int) previous_price - discount_price;

            String previous = "<del>৳"+previous_price+"</del>";

//            itemFull.IMAGE_LINKS = new ArrayList<>();

//            itemFull.IMAGE_LINKS.add(image1);
//            itemFull.IMAGE_LINKS.add(image2);
//            itemFull.IMAGE_LINKS.add(image3);
//            itemFull.IMAGE_LINKS.add(image4);
//            itemFull.IMAGE_LINKS.add(image5);

            holder.product_name.setText(title);
            holder.description.setText(description);
//            holder.brand_name.setText(""+brand);
            holder.rating.setText(rating);
            holder.stock.setText(stock);
            holder.previous.setText(Html.fromHtml(previous));
            holder.price.setText("৳"+final_price);

            Picasso.get().load(thumbnail)
                    .placeholder(R.color.white)
                    .into(product_image);


            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.scale_button);
            Animation item_anim = AnimationUtils.loadAnimation(getContext(), R.anim.scale_button);

            Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.bebasneue_regular);

            holder.cart_text.setTypeface(typeface);
            holder.cart_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(anim);
                    holder.cart_text.setText("Added");
                    added_item = added_item+1;
                    Cart_activity.cart_text = title;
                    Cart_activity.price = final_price;
                }
            });

            holder.full_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(item_anim);

                    Bitmap imageBitmap = ((BitmapDrawable) product_image.getDrawable()).getBitmap();
                    itemFull.fullimage = imageBitmap;

                    itemFull.TITLE = title;

                    startActivity(new Intent(getContext(), itemFull.class));
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }
}