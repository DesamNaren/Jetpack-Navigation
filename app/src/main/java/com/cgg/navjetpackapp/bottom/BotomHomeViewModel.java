package com.cgg.navjetpackapp.bottom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BotomHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BotomHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}