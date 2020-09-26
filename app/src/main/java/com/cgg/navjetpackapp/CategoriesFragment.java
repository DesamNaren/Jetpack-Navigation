package com.cgg.navjetpackapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class CategoriesFragment extends Fragment {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        if (getActivity() != null) {
            sharedPreferences = getActivity().getSharedPreferences(AppConstants.APP_PREF, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            view.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, AppConstants.CAT_TO_DEST_SEL);
                    editor.commit();
                    navController.navigate(R.id.action_categoriesFragment_to_searchFragment);
                }
            });
            view.findViewById(R.id.btn_cart).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, AppConstants.CAT_TO_DEST_SEL);
                    editor.commit();
                    navController.navigate(R.id.action_categoriesFragment_to_cartFragment);
                }
            });
        }
    }
}
