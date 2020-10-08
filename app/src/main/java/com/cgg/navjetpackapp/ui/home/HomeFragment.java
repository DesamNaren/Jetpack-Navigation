package com.cgg.navjetpackapp.ui.home;

import android.os.Bundle;
import android.service.autofill.UserData;
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
import com.cgg.navjetpackapp.User;

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

                List<User> list = new ArrayList<>();
                User user = new User();
                user.setId(1);
                user.setName("TEST");
                user.setFlag(true);

                User user1 = new User();
                user1.setId(2);
                user1.setName("TWO TEST");
                user1.setFlag(true);

                list.add(user);
                list.add(user1);
                list.add(user);
                list.add(user);

                action.setACTIONGALLERY("HOME TO GALLERY");
                action.setUSERDATA(user);

                User[] array = list.toArray(new User[list.size()]);

                action.setUSERLIST(array);

                NavController navController = Navigation.findNavController(getActivity(),
                        R.id.nav_host_fragment);
                navController.navigate(action);
            }
        });
        return root;
    }
}