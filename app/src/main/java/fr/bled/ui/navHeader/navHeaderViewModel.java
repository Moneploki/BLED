package fr.bled.ui.navHeader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class navHeaderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public navHeaderViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}