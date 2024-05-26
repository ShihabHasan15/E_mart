package com.shibustudio.emart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cart_activity extends AppCompatActivity {
    ListView cart_list;
    TextView no_cart_text;
    public static String cart_text="";
    public static int price=0;
    ArrayList<View> viewArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart_list = findViewById(R.id.cart_list);
        no_cart_text = findViewById(R.id.no_cart_text);

        cart_list_adapter adapter = new cart_list_adapter();

        if (home_frag.added_item!=0){

            cart_list.setVisibility(View.VISIBLE);
            no_cart_text.setVisibility(View.GONE);

            cart_list.setAdapter(adapter);
        }
    }

    public class cart_list_adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return home_frag.added_item;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.cart_design, parent, false);
//
////            viewArrayList = new ArrayList<>();
////
////            viewArrayList.add(myView);
//
//
//            TextView cart_title = myView.findViewById(R.id.cart_title);
//            TextView cart_price = myView.findViewById(R.id.cart_price);
//
//
//            cart_title.setText(cart_text);
//            cart_price.setText(""+price);


//            viewArrayList.get(position);


            return myView;
        }
    }
}