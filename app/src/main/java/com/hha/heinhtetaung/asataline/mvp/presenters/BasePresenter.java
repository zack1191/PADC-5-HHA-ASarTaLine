package com.hha.heinhtetaung.asataline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hha.heinhtetaung.asataline.mvp.views.BaseView;

/**
 * Created by E5 on 7/7/2018.
 */

public abstract class BasePresenter<T extends BaseView> extends ViewModel {
    protected T mView;
    protected MutableLiveData<String> errorMsgLD;

    public void initPresenter(T mView) {
        this.mView = mView;
        errorMsgLD = new MutableLiveData<>();
    }

    public LiveData<String> getErrorLD() {
        return errorMsgLD;
    }
}
