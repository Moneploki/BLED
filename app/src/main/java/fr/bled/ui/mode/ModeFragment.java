package fr.bled.ui.mode;

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

import fr.bled.R;

public class ModeFragment extends Fragment {

    private ModeViewModel modeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        modeViewModel =
                ViewModelProviders.of(this).get(ModeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mode, container, false);
        final TextView textView = root.findViewById(R.id.text_mode);
        modeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}