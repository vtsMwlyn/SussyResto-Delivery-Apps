package com.example.sussyrestodeliveryapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    ArrayList<String> orderList = new ArrayList<String>();
    BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        bottomMenu = findViewById(R.id.bottom_menu);
        bottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Fragment selectedFragment = null;

                switch(item.getItemId()){
                    case R.id.nav_order:
                        selectedFragment = new OrderFragment();

                        fm.setFragmentResultListener("reqKey", MainPage.this, new FragmentResultListener() {
                            @Override
                            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                                orderList = result.getStringArrayList("list");
                            }
                        });

                        break;

                    case R.id.nav_cart:
                        Bundle orDatBun = new Bundle();
                        orDatBun.putStringArrayList("list", orderList);

                        selectedFragment = new CartFragment();
                        selectedFragment.setArguments(orDatBun);

                        break;

                    case R.id.nav_history:
                        selectedFragment = new HistoryFragment();
                        break;
                }

                ft.replace(R.id.fragment_container, selectedFragment).commit();

                return false;
            }
        });

        bottomMenu.setSelectedItemId(R.id.nav_order);
    }
}