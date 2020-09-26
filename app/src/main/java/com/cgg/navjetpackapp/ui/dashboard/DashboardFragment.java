package com.cgg.navjetpackapp.ui.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cgg.navjetpackapp.AppConstants;
import com.cgg.navjetpackapp.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.frag_categories, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        if (getActivity() != null) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(AppConstants.APP_PREF, Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            view.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, AppConstants.CAT_TO_DEST_SEL);
                    editor.commit();
                    navController.navigate(R.id.navigation_search);
                }
            });
            view.findViewById(R.id.btn_cart).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putString(AppConstants.CAT_TO_DEST_SEL, AppConstants.CAT_TO_DEST_SEL);
                    editor.commit();
                    navController.navigate(R.id.navigation_cart);
                }
            });
        }
    }
}