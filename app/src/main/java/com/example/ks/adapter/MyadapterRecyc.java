package com.example.ks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ks.ItemList;
import com.example.ks.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadapterRecyc extends RecyclerView.Adapter {
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
        if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item_2, parent, false);
            return new ItemListHolder2(view);
        }
        if (viewType == 3){
            View view = LayoutInflater.from(context).inflate(R.layout.layout_item_3, parent, false);
            return new ItemListHolder3(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_4, parent, false);
        return new ItemListHolder4(view);
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

        if (type == 3){
            ItemListHolder3 itemListHolder3 = (ItemListHolder3) holder;
            itemListHolder3.desc.setText(list.get(position).getDesc());
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(itemListHolder3.iv);
        }
        if (type == 4){
            ItemListHolder4 itemListHolder4 = (ItemListHolder4) holder;
            itemListHolder4.desc.setText(list.get(position).getDesc());
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(itemListHolder4.iv);
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
        if (position == 0){
            return 1;
        }
        if(position == 1){
            return 2;
        }
        if (position == 2){
            return 3;
        }else {
            return 4;
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

    class ItemListHolder3 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView desc;
        public ItemListHolder3(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_item_3);
            desc = itemView.findViewById(R.id.tv_item_3);
        }
    }
    class ItemListHolder4 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView desc;
        public ItemListHolder4(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_item_4);
            desc = itemView.findViewById(R.id.tv_item_4);
        }
    }

   public interface Clickl{
        void click(int index);
    }
    private Clickl clickl;

    public void setClickl(Clickl clickl) {
        this.clickl = clickl;
    }
}
