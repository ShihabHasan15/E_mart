package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    DrawerLayout drawer;

    MaterialToolbar toolbar;

    NavigationView navigationView;

    BottomNavigationView bottomNavigationView;

    LottieAnimationView progress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //=======================================================================
        // Home Fragment

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, new home_frag());
        fragmentTransaction.commit();

        //========================================================================



        //============================================================================
        // id identifying
        //============================================================================

        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.btm);

        bottomNavigationView.getOrCreateBadge(R.id.messege).setNumber(3);
        bottomNavigationView.getOrCreateBadge(R.id.cart).setNumber(3);


        drawer.setScrimColor(getResources().getColor(android.R.color.transparent));

        //============================================================================

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer
        );

        drawer.addDrawerListener(toggle);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return true;
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.search_button){
                    startActivity(new Intent(MainActivity.this, SearchActivity.class));
                }

                if (item.getItemId()==R.id.user){
                    startActivity(new Intent(MainActivity.this, Account_activity.class));
                }
                return true;
            }
        });

    }

//    @SuppressLint("MissingSuperCall")
//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//        new AlertDialog.Builder(MainActivity.this)
//                .setTitle("Exit")
//                .setMessage("Do you want to exit?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .show();
//    }
}