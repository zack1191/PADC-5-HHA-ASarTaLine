package com.hha.heinhtetaung.asataline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.hha.heinhtetaung.asataline.data.model.WarDeeModel;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.delegate.FoodItemDelegate;
import com.hha.heinhtetaung.asataline.mvp.views.WarDeeView;

import java.util.List;

/**
 * Created by E5 on 7/7/2018.
 */

public class WarDeePresenter extends BasePresenter<WarDeeView> implements FoodItemDelegate {
    private MutableLiveData<List<WarDeeVO>> mWarDeeLd;
    private MutableLiveData<String> mErrorLd;


    @Override
    public void initPresenter(WarDeeView mView) {
        super.initPresenter(mView);
        mWarDeeLd = new MutableLiveData<>();
        mErrorLd = new MutableLiveData<>();
        WarDeeModel.getObjInstance(mView.getContext()).startLoadingWarDee(mWarDeeLd, mErrorLd);

    }

    public LiveData<List<WarDeeVO>> getWarDee() {
        return mWarDeeLd;
    }


    @Override
    public void onTapFoodItem(WarDeeVO warDeeVO) {
        mView.launchFoodDetail(warDeeVO.getWarDeeId());

    }
}
