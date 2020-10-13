package com.cgg.navjetpackapp.navdrawer.ui.slideshow;

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

import com.cgg.navjetpackapp.R;
import com.cgg.navjetpackapp.general.UserDetails;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private TextView tvMsg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        tvMsg = root.findViewById(R.id.text_msg);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null) {
            SlideshowFragmentArgs args = SlideshowFragmentArgs.fromBundle(getArguments());
            UserDetails[] userDetails = args.getUSERLIST();
            tvMsg.setText("USER SIZE "+ userDetails.length);
        }
    }
}