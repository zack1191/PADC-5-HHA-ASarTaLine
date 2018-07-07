package com.hha.heinhtetaung.asataline.data.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.hha.heinhtetaung.asataline.AppConstant;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.network.responses.GetWarDeeResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by E5 on 7/7/2018.
 */

public class WarDeeModel extends BaseModel {
    public static WarDeeModel objInstance;
    private List<WarDeeVO> warDeeVOList;

    protected WarDeeModel(Context context) {
        super(context);
        warDeeVOList = new ArrayList<>();

    }

    public static WarDeeModel getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = new WarDeeModel(context);
        }
        return objInstance;
    }


    public void startLoadingWarDee(final MutableLiveData<List<WarDeeVO>> mWarDeeLd, final MutableLiveData<String> mErrorLD) {
        io.reactivex.Observable<GetWarDeeResponse> getWarDeeResponseObservable = theApi.getWarDeeItems(AppConstant.ACCESS_TOKEN);
        getWarDeeResponseObservable.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetWarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetWarDeeResponse getWarDeeResponse) {
                        if (getWarDeeResponse != null) {
                            warDeeVOList = getWarDeeResponse.getWarDeeVOS();
                            mWarDeeLd.setValue(warDeeVOList);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                });
    }

    public WarDeeVO getWarDeeVOById(String warDeeId) {
        if (!warDeeVOList.isEmpty()) {
            for (WarDeeVO warDeeVO : warDeeVOList) {
                if (warDeeVO.getWarDeeId().equals(warDeeId)) {
                    return warDeeVO;
                }
            }
        }
        return null;
    }
}
