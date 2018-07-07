package com.hha.heinhtetaung.asataline.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.asataline.R;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.delegate.FoodItemDelegate;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;

/**
 * Created by E5 on 7/7/2018.
 */

public class FoodItemViewholder extends BaseViewHolder<WarDeeVO> {

    @BindView(R.id.iv_justice)
    ImageView ivFood;

    @BindView(R.id.tv_food)
    MMTextView tvFoodName;

    @BindView(R.id.tv_food_disc)
    MMTextView tvFoodTaste;

    private WarDeeVO warDeeVO;

    private FoodItemDelegate mFoodItemDelegate;

    public FoodItemViewholder(View itemView, FoodItemDelegate foodItemDelegate) {
        super(itemView);
        mFoodItemDelegate = foodItemDelegate;
    }


    @Override
    public void onClick(View view) {
        mFoodItemDelegate.onTapFoodItem(warDeeVO);
    }

    @Override
    public void setData(WarDeeVO data) {
        warDeeVO = data;
        Glide.with(ivFood.getContext())
                .load(data.getImages().get(0))
                .into(ivFood);
        tvFoodName.setText(data.getName());
        tvFoodTaste.setText(data.getGeneralTasteVOS().get(0).getTaste());

    }
}
