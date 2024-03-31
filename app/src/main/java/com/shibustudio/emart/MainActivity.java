package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    DrawerLayout drawer;

    MaterialToolbar toolbar;

    NavigationView navigationView;

    BottomNavigationView bottomNavigationView;

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

        //============================================================================

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer
        );

        drawer.addDrawerListener(toggle);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame, new home_frag());
                    fragmentTransaction.commit();
                    toolbar.setSubtitle("Home");
                }
                if (item.getItemId()==R.id.messege){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new MessegeFrag())
                    .commit();
                    toolbar.setSubtitle("Messege");
                }if (item.getItemId()==R.id.cart){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new MessegeFrag())
                    .commit();
                    toolbar.setSubtitle("Carts");
                }if (item.getItemId()==R.id.account){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new AccountFrag())
                    .commit();
                    toolbar.setSubtitle("Account");
                }
                return true;
            }
        });



    }
}