package com.hha.heinhtetaung.asataline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hha.heinhtetaung.asataline.R;
import com.hha.heinhtetaung.asataline.adapters.FoodItemAdapter;
import com.hha.heinhtetaung.asataline.components.SmartRecyclerView;
import com.hha.heinhtetaung.asataline.data.model.WarDeeModel;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;
import com.hha.heinhtetaung.asataline.delegate.FoodItemDelegate;
import com.hha.heinhtetaung.asataline.mvp.presenters.WarDeePresenter;
import com.hha.heinhtetaung.asataline.mvp.views.WarDeeView;
import com.hha.heinhtetaung.asataline.network.responses.GetWarDeeResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WarDeeView {
    @BindView(R.id.rv_recycler)
    SmartRecyclerView rvFood;

    private FoodItemAdapter mFoodItemAdapter;
    private FoodItemDelegate mFoodItemDelegate;
    private WarDeePresenter mWarDeePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        WarDeeModel.getObjInstance(getApplicationContext());
        mWarDeePresenter = ViewModelProviders.of(this).get(WarDeePresenter.class);
        mWarDeePresenter.initPresenter(this);

        mWarDeePresenter.getWarDee().observe(this, new Observer<List<WarDeeVO>>() {
            @Override
            public void onChanged(@Nullable List<WarDeeVO> warDeeVOS) {
                displayWarDeeItem(warDeeVOS);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mFoodItemAdapter = new FoodItemAdapter(getApplicationContext(), mWarDeePresenter);
        rvFood.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvFood.setAdapter(mFoodItemAdapter);


    }

    private void displayWarDeeItem(List<WarDeeVO> warDeeVOS) {
        mFoodItemAdapter.appendNewData(warDeeVOS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void launchFoodDetail(String warDeeId) {
        Intent intent = FoodDetailActivity.newIntent(getApplicationContext(), warDeeId);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return null;
    }
}
