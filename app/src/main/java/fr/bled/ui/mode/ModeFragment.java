package fr.bled.ui.mode;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.PorterDuff;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.bled.R;


public class ModeFragment extends Fragment {

    private java.lang.String[] button_name_t = {"Blink", "Blinkalt", "Sparkle", "Sparkle 2", "Strobo", "Cycle colors", "Pixel shift left", "Pixel shift right", "Pixel bounce","Pixel smooth shift left", "Pixel smooth shift right","Pixel smooth bounce","PixelSmoothBounce twice", "Comet","Comet col","Moving bars","Moving gradient","Larson scanner","Larson scanner 2","Fade in","Fade out","Fade inout","Glow","Plasma","Fade Colors","Fade colors loop","Pixels fade colors","Fire","Bouncing balls","Bubbles","Twinkle","Random","Infinite"};

    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ModeViewModel modeViewModel = ViewModelProviders.of(this).get(ModeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mode, container, false);
        final TextView textView = root.findViewById(R.id.text_mode);
        modeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ImageButton simpleImageButton_0 = root.findViewById(R.id.imageButton1);
        ImageButton simpleImageButton_1 = root.findViewById(R.id.imageButton2);
        ImageButton simpleImageButton_2 = root.findViewById(R.id.imageButton3);
        ImageButton simpleImageButton_3 = root.findViewById(R.id.imageButton4);
        ImageButton simpleImageButton_4 = root.findViewById(R.id.imageButton5);
        ImageButton simpleImageButton_5 = root.findViewById(R.id.imageButton6);
        ImageButton simpleImageButton_6 = root.findViewById(R.id.imageButton7);
        ImageButton simpleImageButton_7 = root.findViewById(R.id.imageButton8);
        ImageButton simpleImageButton_8 = root.findViewById(R.id.imageButton9);
        ImageButton simpleImageButton_9 = root.findViewById(R.id.imageButton10);
        ImageButton simpleImageButton_10 = root.findViewById(R.id.imageButton11);
        ImageButton simpleImageButton_11 = root.findViewById(R.id.imageButton12);
        ImageButton simpleImageButton_12 = root.findViewById(R.id.imageButton13);
        ImageButton simpleImageButton_13= root.findViewById(R.id.imageButton14);
        ImageButton simpleImageButton_14 = root.findViewById(R.id.imageButton15);
        ImageButton simpleImageButton_15 = root.findViewById(R.id.imageButton16);
        ImageButton simpleImageButton_16 = root.findViewById(R.id.imageButton17);
        ImageButton simpleImageButton_17 = root.findViewById(R.id.imageButton18);
        ImageButton simpleImageButton_18 = root.findViewById(R.id.imageButton19);
        ImageButton simpleImageButton_19 = root.findViewById(R.id.imageButton20);
        ImageButton simpleImageButton_20 = root.findViewById(R.id.imageButton21);
        ImageButton simpleImageButton_21 = root.findViewById(R.id.imageButton22);
        ImageButton simpleImageButton_22 = root.findViewById(R.id.imageButton23);
        ImageButton simpleImageButton_23 = root.findViewById(R.id.imageButton24);
        ImageButton simpleImageButton_24 = root.findViewById(R.id.imageButton25);
        ImageButton simpleImageButton_25 = root.findViewById(R.id.imageButton26);
        ImageButton simpleImageButton_26 = root.findViewById(R.id.imageButton27);
        ImageButton simpleImageButton_27 = root.findViewById(R.id.imageButton28);
        ImageButton simpleImageButton_28 = root.findViewById(R.id.imageButton29);
        ImageButton simpleImageButton_29 = root.findViewById(R.id.imageButton30);
        ImageButton simpleImageButton_30 = root.findViewById(R.id.imageButton31);
        ImageButton simpleImageButton_31 = root.findViewById(R.id.imageButton32);
        ImageButton simpleImageButton_32 = root.findViewById(R.id.imageButton33);



        final ImageButton[] button_list = {simpleImageButton_0, simpleImageButton_1, simpleImageButton_2, simpleImageButton_3, simpleImageButton_4, simpleImageButton_5, simpleImageButton_6, simpleImageButton_7, simpleImageButton_8,
                simpleImageButton_9,simpleImageButton_10, simpleImageButton_11, simpleImageButton_12, simpleImageButton_13, simpleImageButton_14, simpleImageButton_15, simpleImageButton_16, simpleImageButton_17, simpleImageButton_18,
                simpleImageButton_19,simpleImageButton_20, simpleImageButton_21, simpleImageButton_22, simpleImageButton_23, simpleImageButton_24, simpleImageButton_25, simpleImageButton_26, simpleImageButton_27, simpleImageButton_28,
                simpleImageButton_29, simpleImageButton_30,simpleImageButton_31,simpleImageButton_32};

        for (int i=0;i<button_list.length;i++){
            button_list[i].setTag(button_name_t[i]);
            //button_list[i].setBackgroundColor(0xFFB300);
        }

        for (final ImageButton button : button_list) {
            int indice_button_on = 0;
            // perform click event on button's

            button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            v.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            button.setColorFilter(Color.argb(255,255,255,0));
                            button.invalidate();
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Toast.makeText(getContext(), button.getTag().toString(), Toast.LENGTH_LONG).show();
                            button.setColorFilter(Color.argb(255,255,255,0));
                            // Registrer value

                        case MotionEvent.ACTION_CANCEL: {
                              //   button.clearColorFilter();
                             //    button.invalidate();

                            v.getBackground().clearColorFilter();
                            v.invalidate();
                            break;
                        }
                    }
                    return true;
                }
            });
        }

        return root;
    }

}