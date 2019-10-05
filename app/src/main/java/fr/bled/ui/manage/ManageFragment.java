package fr.bled.ui.manage;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import fr.bled.R;

public class ManageFragment extends Fragment {

    private ManageViewModel manageViewModel;
    private LinearLayout mlayout;
    private int defaultColor;
    private Button mButton;
    private ColorPickerDialogBuilder colorPicker;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        manageViewModel =
                ViewModelProviders.of(this).get(ManageViewModel.class);
        View root = inflater.inflate(R.layout.fragment_manage, container, false);
        final TextView textView = root.findViewById(R.id.text_manage);
        manageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        mlayout = root.findViewById(R.id.layoutManage);
        defaultColor = getContext().getColor(R.color.colorPrimary);
        mButton = (Button) root.findViewById(R.id.buttonPickColor);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openColorPicker();
            }
        });
        return root;
    }

    private void openColorPicker() {
        colorPicker = ColorPickerDialogBuilder.with(getContext());
        colorPicker
                .setTitle("Choose color")
                .initialColor(defaultColor)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        defaultColor=selectedColor;
                        mlayout.setBackgroundColor(selectedColor);
                        Toast.makeText(getContext(),"onColorSelected: 0x" + Integer.toHexString(selectedColor),Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }
}
