package com.hha.heinhtetaung.asataline.activities;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.asataline.R;
import com.hha.heinhtetaung.asataline.data.model.WarDeeModel;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.mvp.presenters.WarDeeDetailPresenter;
import com.hha.heinhtetaung.asataline.mvp.views.WarDeeDetailView;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 7/6/2018.
 */

public class FoodDetailActivity extends AppCompatActivity implements WarDeeDetailView {

    @BindView(R.id.iv_detail_image)
    ImageView ivDetailImage;

    @BindView(R.id.tv_food_title)
    MMTextView tvFoodTitle;

    @BindView(R.id.tv_food_disc)
    MMTextView tvFoodTaste;

    @BindView(R.id.tv_price)
    MMTextView tvPrice;

    private static final String WARDEE_ID = "WARDEE_ID";
    private WarDeeDetailPresenter mWarDeeDetailPresenter;

    public static Intent newIntent(Context context, String warDeeId) {
        Intent intent = new Intent(context, FoodDetailActivity.class);
        intent.putExtra(WARDEE_ID, warDeeId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this, this);
        WarDeeModel.getObjInstance(getApplicationContext());

        mWarDeeDetailPresenter = ViewModelProviders.of(this).get(WarDeeDetailPresenter.class);
        mWarDeeDetailPresenter.initPresenter(this);

        final String warDeeId = getIntent().getStringExtra(WARDEE_ID);
        mWarDeeDetailPresenter.getWarDeeDetail(warDeeId).observe(this, new Observer<WarDeeVO>() {
            @Override
            public void onChanged(@Nullable WarDeeVO warDeeVO) {
                displayWarDeeDetail(warDeeVO);
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void displayWarDeeDetail(WarDeeVO warDeeVO) {
        Glide.with(ivDetailImage.getContext())
                .load(warDeeVO.getImages().get(0))
                .into(ivDetailImage);
        tvFoodTitle.setText(warDeeVO.getName());
        tvFoodTaste.setText(warDeeVO.getGeneralTasteVOS().get(0).getTasteDesc());
        tvPrice.setText(warDeeVO.getPriceRangeMin() + "_" + warDeeVO.getPriceRangeMax());
    }

    @Override
    public Context getContext() {
        return null;
    }
}
