package com.cgg.navjetpackapp.navdrawer.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cgg.navjetpackapp.R;
import com.cgg.navjetpackapp.general.User;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private TextView tvMsg;
    private TextView text_parcelable_val;
    private TextView tvCustomList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        text_parcelable_val = root.findViewById(R.id.text_parcelable_val);
        tvMsg = root.findViewById(R.id.text_msg);
        tvCustomList = root.findViewById(R.id.text_custom_list_val);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFragmentDirections.ActionNavGalleryToNavSlideshow action =
                        GalleryFragmentDirections.actionNavGalleryToNavSlideshow(0);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                action.setUSERLIST(userList);
                navController.navigate(action);
            }
        });
        return root;
    }

    User[] userList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            GalleryFragmentArgs args = GalleryFragmentArgs.fromBundle(getArguments());
            String msg = args.getACTIONGALLERY();
            tvMsg.setText(msg);

            User user = args.getUSERDATA();
            if (user != null) {
                text_parcelable_val.setText(user.toString());
            }

            userList = args.getUSERLIST();
            if (userList != null) {
                tvCustomList.setText(userList[1].toString());
            }
        }
    }
}