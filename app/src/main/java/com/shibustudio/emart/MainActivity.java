package com.shibustudio.emart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    DrawerLayout drawer;

    MaterialToolbar toolbar;

    NavigationView navigationView;

    public static BottomNavigationView bottomNavigationView;

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




        drawer.setScrimColor(getResources().getColor(android.R.color.transparent));

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

                }else if (item.getItemId()==R.id.notification){

                    bottomNavigationView.removeBadge(R.id.notification);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame, new MessegeFrag());
                    fragmentTransaction.commit();

                } else if (item.getItemId()==R.id.account) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame, new userFrag());
                    fragmentTransaction.commit();


                }

                return true;
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.search_button){
                    startActivity(new Intent(MainActivity.this, SearchActivity.class));
                }

                if (item.getItemId()==R.id.cart){

                    startActivity(new Intent(MainActivity.this, Cart_activity.class));

                }
                return true;
            }
        });

    }

    @SuppressLint({"MissingSuperCall"})
    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.exit_dialog, null);



        dialogBuilder.setView(dialogView);

        MaterialButton yes = dialogView.findViewById(R.id.yes);
        MaterialButton no = dialogView.findViewById(R.id.no);



        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


//        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        alertDialog.show();




    }
}