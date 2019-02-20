package com.aaa.myapplication.ToolBar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aaa.myapplication.R;

/**
 * Created by Administrator on 2018/11/6 0006.
 */

public class LSJadapter extends RecyclerView.Adapter<LSJadapter.MyViewHolder> {
    private Context context;
    private int[] bgs = {R.mipmap.bg_1, R.mipmap.bg_2, R.mipmap.bg_3, R.mipmap.bg_4};

    public LSJadapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(bgs[position % 4]);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
