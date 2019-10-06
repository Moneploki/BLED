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
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import fr.bled.R;

public class ManageFragment extends Fragment {

    private ManageViewModel manageViewModel;
    private ColorPickerView colorpicker;
    private ConstraintLayout mlayout;

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

        colorpicker = (ColorPickerView) root.findViewById(R.id.color_picker_view);
        mlayout = (ConstraintLayout) root.findViewById(R.id.layoutManage);
        colorpicker.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                mlayout.setBackgroundColor(selectedColor);
            }
        });
        return root;
    }

}
