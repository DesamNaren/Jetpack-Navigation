package com.cgg.navjetpackapp.navdrawer.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public void setmText(String string) {
        mText.setValue(string);
    }

    public LiveData<String> getText() {
        return mText;
    }
}