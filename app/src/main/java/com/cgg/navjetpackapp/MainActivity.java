package com.cgg.navjetpackapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(AppConstants.APP_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        LinearLayout llBottom = findViewById(R.id.bottom);
        LinearLayout llHome = llBottom.findViewById(R.id.home);
        final LinearLayout llCategory = llBottom.findViewById(R.id.category);
        final LinearLayout llSearch = llBottom.findViewById(R.id.search);
        final LinearLayout llCart = llBottom.findViewById(R.id.cart);

        llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!curFrag.contains(HomeFragment.class.getSimpleName())) {
                        navController.navigate(R.id.homeFragment);
                    }
                } else {
                    navController.navigate(R.id.homeFragment);
                }
            }
        });

        llCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!curFrag.contains(CategoriesFragment.class.getSimpleName())) {
                        navController.navigate(R.id.categoriesFragment);
                    }
                } else {
                    navController.navigate(R.id.categoriesFragment);
                }
            }
        });
        llSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!curFrag.contains(SearchFragment.class.getSimpleName())) {
                        navController.navigate(R.id.searchFragment);
                    }
                } else {
                    navController.navigate(R.id.searchFragment);
                }
            }
        });
        llCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!curFrag.contains(CartFragment.class.getSimpleName())) {
                        navController.navigate(R.id.cartFragment);
                    }
                } else {
                    navController.navigate(R.id.cartFragment);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (navController != null && navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getLabel() != null) {

            String catFlag = sharedPreferences.getString(AppConstants.CAT_TO_DEST_SEL, "");
            if (TextUtils.isEmpty(catFlag)) {
                String curFrag = navController.getCurrentDestination().getLabel().toString();
                if (!curFrag.contains(HomeFragment.class.getSimpleName())) {
                    navController.navigate(R.id.homeFragment);
                } else {
                    finish();
                }
            } else {
                editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                editor.commit();
                navController.navigate(R.id.categoriesFragment);
            }
        } else {
            finish();
        }
    }
}
