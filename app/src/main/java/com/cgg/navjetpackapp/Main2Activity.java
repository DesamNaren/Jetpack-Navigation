package com.cgg.navjetpackapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {
    NavController navController;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences(AppConstants.APP_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_categories,
                R.id.navigation_search, R.id.navigation_cart)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController,
                appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.getMenu().findItem(R.id.navigation_home).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!MainFragment.class.getSimpleName().contains(curFrag)) {
                        navController.navigate(R.id.navigation_home);
                    }
                } else {
                    navController.navigate(R.id.navigation_home);
                }
                return true;
            }
        });


        navView.getMenu().findItem(R.id.navigation_categories).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!CategoriesFragment.class.getSimpleName().contains(curFrag)) {
                        navController.navigate(R.id.navigation_categories);
                    }
                } else {
                    navController.navigate(R.id.navigation_categories);
                }
                return true;
            }
        });
        navView.getMenu().findItem(R.id.navigation_search).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!SearchFragment.class.getSimpleName().contains(curFrag)) {
                        navController.navigate(R.id.navigation_search);
                    }
                } else {
                    navController.navigate(R.id.navigation_search);
                }
                return true;
            }
        });

        navView.getMenu().findItem(R.id.navigation_cart).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (navController.getCurrentDestination() != null &&
                        navController.getCurrentDestination().getLabel() != null) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                    editor.commit();
                    String curFrag = navController.getCurrentDestination().getLabel().toString();
                    if (!CartFragment.class.getSimpleName().contains(curFrag)) {
                        navController.navigate(R.id.navigation_cart);
                    }
                } else {
                    navController.navigate(R.id.navigation_cart);
                }
                return true;
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
                if (!MainFragment.class.getSimpleName().contains(curFrag)) {
                    navController.navigate(R.id.navigation_home);
                } else {
                    finish();
                }
            } else {
                editor.putString(AppConstants.CAT_TO_DEST_SEL, "");
                editor.commit();
                navController.navigate(R.id.navigation_categories);
            }
        } else {
            finish();
        }
    }
}
