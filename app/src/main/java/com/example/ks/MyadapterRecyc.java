package com.example.ks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyadapterRecyc extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemList.DataBean.DatasBean> list;

    public MyadapterRecyc(Context context, ArrayList<ItemList.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item_1, parent, false);
            return new ItemListHolder1(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_2, parent, false);
        return new ItemListHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if(type == 1){
            ItemListHolder1 itemListHolder1 = (ItemListHolder1) holder;
            itemListHolder1.desc.setText(list.get(position).getDesc());
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(itemListHolder1.iv);
        }
        if (type == 2){
            ItemListHolder2 itemListHolder2 = (ItemListHolder2) holder;
            itemListHolder2.desc.setText(list.get(position).getDesc());
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(itemListHolder2.iv);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickl!=null){
                    clickl.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position %2 == 0){
            return 1;
        }else {
            return 2;
        }
    }

    class ItemListHolder1 extends RecyclerView.ViewHolder {
        private TextView desc;
        private ImageView iv;
        public ItemListHolder1(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.tv_item_1);
            iv = itemView.findViewById(R.id.iv_item_1);
        }
    }

    class ItemListHolder2 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView desc;
        public ItemListHolder2(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_item_2);
            desc = itemView.findViewById(R.id.tv_item_2);
        }
    }
    interface Clickl{
        void click(int index);
    }
    private Clickl clickl;

    public void setClickl(Clickl clickl) {
        this.clickl = clickl;
    }
}
