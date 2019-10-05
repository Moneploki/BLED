package fr.bled.ui.mode;

import android.annotation.SuppressLint;
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

    private java.lang.String[] button_name_t = {"Blink", "Blinkalt", "Sparkle", "Sparkle 2", "Strobo", "Cycle colors", "Pixel shift left", "Pixel shift right", "Pixel bounce"};
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

        ImageButton[] button_list = {simpleImageButton_0, simpleImageButton_1, simpleImageButton_2, simpleImageButton_3, simpleImageButton_4, simpleImageButton_5, simpleImageButton_6, simpleImageButton_7, simpleImageButton_8};

        for (int i=0;i<9;i++){
            button_list[i].setTag(button_name_t[i]);
        }

        for (final ImageButton button : button_list) {
            // perform click event on button's

            button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {

                            v.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                            Toast.makeText(getContext(), button.getTag().toString(), Toast.LENGTH_LONG).show();
                            // Registrer value
                        case MotionEvent.ACTION_CANCEL: {

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