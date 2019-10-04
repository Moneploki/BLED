package fr.bled.ui.mode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ModeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mode section");
    }

    public LiveData<String> getText() {
        return mText;
    }
}