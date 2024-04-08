package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class home_frag extends Fragment {

ImageSlider imageSlider;
RecyclerView recycle;

TabLayout tab;

HashMap<String, String> hashMap;

ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();



ArrayList<SlideModel> imageList = new ArrayList<>();





    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_home_frag, container, false);


//rest api data fetching==================================================

        RequestQueue queue = Volley.newRequestQueue(requireContext());

        String url = "https://dummyjson.com/products";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray products = response.getJSONArray("products");

                    for (int i=0; i<products.length(); i++){

                        JSONObject item_info = products.getJSONObject(i);

                        String title = item_info.getString("title");
                        String des = item_info.getString("description");
                        String brand = item_info.getString("brand");
                        String category = item_info.getString("category");
                        String thumbnail = item_info.getString("thumbnail");

                        int id = item_info.getInt("id");
                        int price = item_info.getInt("price");
                        int discount_percent = item_info.getInt("discountPercentage");
                        double rating = item_info.getDouble("rating");
                        int stock = item_info.getInt("stock");

                        JSONArray product_images = item_info.getJSONArray("images");

                        for (int j=0; j<product_images.length(); j++){
                            String img = product_images.getString(j);
                        }

                        //putting data with hashmap and arraylist
                        hashMap = new HashMap<>();

                        hashMap.put("title", ""+title);
                        hashMap.put("description", ""+des);
                        hashMap.put("brand", ""+brand);
                        hashMap.put("category", ""+category);
                        hashMap.put("thumbnail", ""+thumbnail);

                        hashMap.put("id", ""+id);
                        hashMap.put("price", ""+price);
                        hashMap.put("discountPercentage", ""+discount_percent);
                        hashMap.put("rating", ""+rating);
                        hashMap.put("stock", ""+stock);

                        arrayList.add(hashMap);
                    }




                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //recyclerview===============================================================

                recycle = myView.findViewById(R.id.recycle);

                recycleAdapter adapter = new recycleAdapter();
                recycle.setAdapter(adapter);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

                recycle.setLayoutManager(gridLayoutManager);

                //recyclerview ends==========================================================
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

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







//tablayout================================================================
        tab = myView.findViewById(R.id.tab);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//tablayout ends======================================================



        return myView;
    }


    public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.recycleViewHolder>{
        ImageView product_image;
        public class recycleViewHolder extends RecyclerView.ViewHolder{

            TextView product_name,brand_name, description, stock, price, previous, rating;
            CardView cart_btn;





            public recycleViewHolder(@NonNull View itemView) {
                super(itemView);

                cart_btn = itemView.findViewById(R.id.cart_btn);
                product_image = itemView.findViewById(R.id.product_image);

                product_name = itemView.findViewById(R.id.product_name);
                brand_name = itemView.findViewById(R.id.brand_name);
                description = itemView.findViewById(R.id.description);
                stock = itemView.findViewById(R.id.stock);
                price = itemView.findViewById(R.id.price);
                previous = itemView.findViewById(R.id.previous);
                rating = itemView.findViewById(R.id.rating);



            }
        }

        @NonNull
        @Override
        public recycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View inflateView = inflater.inflate(R.layout.item_design, parent, false);

            return new recycleViewHolder(inflateView);
        }

        @Override
        public void onBindViewHolder(@NonNull recycleViewHolder holder, int position) {


            HashMap<String, String> getdata = arrayList.get(position);

            String title = getdata.get("title");
            String description = getdata.get("description");
            String brand = getdata.get("brand");
            String thumbnail = getdata.get("thumbnail");

            String rating = getdata.get("rating");
            String stock = getdata.get("stock");

            holder.product_name.setText(title);
            holder.description.setText(description);
            holder.brand_name.setText(brand);
            holder.rating.setText(rating);
            holder.stock.setText(stock);

            Picasso.get().load(thumbnail)
                    .placeholder(R.color.white)
                    .into(product_image);


        }

        @Override
        public int getItemCount() {

            return arrayList.size();
        }




    }
}