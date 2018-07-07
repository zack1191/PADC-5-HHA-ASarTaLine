package com.hha.heinhtetaung.asataline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.hha.heinhtetaung.asataline.data.model.WarDeeModel;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.mvp.views.BaseView;
import com.hha.heinhtetaung.asataline.mvp.views.WarDeeDetailView;
import com.hha.heinhtetaung.asataline.mvp.views.WarDeeView;

/**
 * Created by E5 on 7/7/2018.
 */

public class WarDeeDetailPresenter extends BasePresenter<WarDeeDetailView> {

    private MutableLiveData<WarDeeVO> mWarDeeLd;

    @Override
    public void initPresenter(WarDeeDetailView mView) {
        super.initPresenter(mView);
        mWarDeeLd = new MutableLiveData<>();

    }

    public LiveData<WarDeeVO> getWarDeeDetail(String warDeeId) {
        WarDeeVO warDeeVO = WarDeeModel.getObjInstance(mView.getContext()).getWarDeeVOById(warDeeId);
        mWarDeeLd.setValue(warDeeVO);
        return mWarDeeLd;
    }
}
