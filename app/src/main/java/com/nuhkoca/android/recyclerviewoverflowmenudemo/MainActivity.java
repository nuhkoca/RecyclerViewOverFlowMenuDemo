package com.nuhkoca.android.recyclerviewoverflowmenudemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nuhkoca.android.recyclerviewoverflowmenudemo.adapter.SimpleDataAdapter;
import com.nuhkoca.android.recyclerviewoverflowmenudemo.model.SimpleDataModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;
    private List<SimpleDataModel> mSimpleDataModel;

    private static final int IMAGE = R.drawable.demo_pic;
    private static final int TITLE = R.string.title_text;
    private static final int DESCRIPTION = R.string.description_text;
    private static final int AUTHOR = R.string.author_text;
    private static final int DATE = R.string.date_text;

    private static final int MAX_ROWS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToList();
        initUI();
    }

    private void initUI() {
        RecyclerView mItemRecyclerView = findViewById(R.id.rv_item_holder);
        mItemRecyclerView.setHasFixedSize(true);
        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mItemRecyclerView.setAdapter(new SimpleDataAdapter(mSimpleDataModel, mContext));
    }

    private void addItemsToList() {
        mSimpleDataModel = new ArrayList<>();

        for (int i = 0; i < MAX_ROWS; i++) {
            SimpleDataModel simpleDataModel = new SimpleDataModel(IMAGE, TITLE, DESCRIPTION, AUTHOR, DATE);

            mSimpleDataModel.add(simpleDataModel);
        }
    }
}