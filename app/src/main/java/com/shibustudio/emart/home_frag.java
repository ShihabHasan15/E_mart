package com.shibustudio.emart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class home_frag extends Fragment {

ImageSlider imageSlider;
RecyclerView recycle;

ArrayList<SlideModel> imageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_home_frag, container, false);


        recycle = myView.findViewById(R.id.recycle);

        recycle.setLayoutManager(new GridLayoutManager(getContext(), GridLayoutManager.VERTICAL));
        recycleAdapter adapter = new recycleAdapter();
        recycle.setAdapter(adapter);

        imageSlider = myView.findViewById(R.id.image_slider);

        imageList.add(new SlideModel(R.drawable.pic_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_three, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_four, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.pic_five, ScaleTypes.FIT));

//        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT);

        imageSlider.setImageList(imageList, ScaleTypes.FIT);


        return myView;
    }


    public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.recycleViewHolder>{
        public class recycleViewHolder extends RecyclerView.ViewHolder{
            public recycleViewHolder(@NonNull View itemView) {
                super(itemView);
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

        }

        @Override
        public int getItemCount() {
            return 20;
        }




    }
}