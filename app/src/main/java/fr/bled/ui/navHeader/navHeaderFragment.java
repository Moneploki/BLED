package fr.bled.ui.navHeader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Switch;
import android.widget.ImageView;
import android.widget.CompoundButton;

import android.util.Log;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.bled.R;

public class navHeaderFragment extends Fragment {

    private navHeaderViewModel navHeaderViewModel;
    Switch sw1;
    private ImageView imgV_2, imgV_3;
    AlertDialog.Builder builder;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navHeaderViewModel =
                ViewModelProviders.of(this).get(navHeaderViewModel.class);
        View root = inflater.inflate(R.layout.nav_header_main, container, false);
        navHeaderViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }

        });
        sw1 = root.findViewById(R.id.switch1);
        imgV_2 = root.findViewById(R.id.imageView2);
        imgV_3 = root.findViewById(R.id.imageView3);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   imgV_3.clearColorFilter();
                   imgV_2.setColorFilter(getContext().getResources().getColor(R.color.colorGreen));

               }else{
                   imgV_2.clearColorFilter();
                   imgV_3.setColorFilter(getContext().getResources().getColor(R.color.colorGreen));
               }
           }
        });
        return root;
    }
}
