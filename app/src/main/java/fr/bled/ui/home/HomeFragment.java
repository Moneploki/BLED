package fr.bled.ui.home;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.widget.ProgressBar;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.LinearGradient;



import fr.bled.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @RequiresApi(api = Build.VERSION_CODES.Q)
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
/*
        SeekBar seekBarFont0 = root.findViewById(R.id.seekBar);
        SeekBar seekBarFont1 = root.findViewById(R.id.seekBar2);
        SeekBar seekBarFont2 = root.findViewById(R.id.seekBar3);
        SeekBar seekBarFont3 = root.findViewById(R.id.seekBar4);

        SeekBar[] seekBarFontTab = {seekBarFont0,seekBarFont1,seekBarFont2,seekBarFont3};


       LinearGradient test = new LinearGradient(0.f, 0.f, 300.f, 0.0f,

                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(test);



        for (int i=0;i<seekBarFontTab.length;i++) {
            seekBarFontTab[i].setScaleY(seekBarFontTab[i].getScaleY()/ 3);
            seekBarFontTab[i].setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFF0000, 0xFF0000FF}));


        }
        for (int i=0;i<seekBarFontTab.length;i++){
            seekBarFontTab[i].setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFF0000, 0xFF0000FF}));
        }
*/
        return root;
    }
}