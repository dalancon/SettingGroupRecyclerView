package com.dalancon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        MineItemDecoration mineItemDecoration = new MineItemDecoration(this)
                .setShowTopLine(true)
                .setShowBottomLine(false)
                .setDividerHeight(getResources().getDimensionPixelSize(R.dimen.divider_height))
                .setDividerMarginLeft(getResources().getDimensionPixelSize(R.dimen.divider_margin_left))
                .setSectionIndexs(2, 5)
                .setGroupDividerColor("#F2F2F2")
                .setDividerColor("#F4F4F4")
                .setTopAndBottomMarginLeft(getResources().getDimensionPixelSize(R.dimen.top_bottom_margin_left));

        recyclerView.addItemDecoration(mineItemDecoration);
        recyclerView.setAdapter(new MyAdapter(this));


    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        private LayoutInflater minflater = null;

        public MyAdapter(Context context) {
            minflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyHolder(minflater.inflate(R.layout.item_layout, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class MyHolder extends RecyclerView.ViewHolder {

            public MyHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

    }
}
