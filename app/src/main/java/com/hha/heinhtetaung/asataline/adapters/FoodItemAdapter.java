package com.hha.heinhtetaung.asataline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.asataline.R;
import com.hha.heinhtetaung.asataline.data.vo.GeneralTasetVO;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.delegate.FoodItemDelegate;
import com.hha.heinhtetaung.asataline.viewholders.FoodItemViewholder;

/**
 * Created by E5 on 7/7/2018.
 */

public class FoodItemAdapter extends BaseRecyclerAdapter<FoodItemViewholder, WarDeeVO> {

    private FoodItemDelegate mFoodItemDelegate;

    public FoodItemAdapter(Context context, FoodItemDelegate foodItemDelegate) {
        super(context);
        mFoodItemDelegate = foodItemDelegate;
    }

    @NonNull
    @Override
    public FoodItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodItemView = mLayoutInflator.inflate(R.layout.item_main, parent, false);
        return new FoodItemViewholder(foodItemView, mFoodItemDelegate);
    }
}