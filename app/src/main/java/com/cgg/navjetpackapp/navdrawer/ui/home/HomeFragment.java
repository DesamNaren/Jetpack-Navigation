package com.cgg.navjetpackapp.navdrawer.ui.home;

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

import com.cgg.navjetpackapp.R;
import com.cgg.navjetpackapp.general.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionNavHomeToNavGallery action =
                        HomeFragmentDirections.actionNavHomeToNavGallery();

                List<UserDetails> list = new ArrayList<>();
                UserDetails userDetails = new UserDetails();
                userDetails.setId(1);
                userDetails.setName("TEST");
                userDetails.setFlag(true);

                UserDetails userDetails1 = new UserDetails();
                userDetails1.setId(2);
                userDetails1.setName("TWO TEST");
                userDetails1.setFlag(true);

                list.add(userDetails);
                list.add(userDetails1);
                list.add(userDetails);
                list.add(userDetails);

                action.setACTIONGALLERY("HOME TO GALLERY");
                action.setUDATA(userDetails);

                UserDetails[] array = list.toArray(new UserDetails[list.size()]);

                action.setULIST(array);

                NavController navController = Navigation.findNavController(getActivity(),
                        R.id.nav_host_fragment);
                navController.navigate(action);
            }
        });
        return root;
    }
}