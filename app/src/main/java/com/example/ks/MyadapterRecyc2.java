package com.example.ks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyadapterRecyc2 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemList.DataBean.DatasBean> list;

    public MyadapterRecyc2(Context context, ArrayList<ItemList.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_er, parent, false);
        return new ItemListerHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ItemListerHoler itemListerHoler = (ItemListerHoler) holder;
        itemListerHoler.title.setText(list.get(position).getTitle());
        itemListerHoler.desc.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getEnvelopePic()).into(itemListerHoler.iv);
        Glide.with(context).load(list.get(position).getEnvelopePic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(itemListerHoler.iv_er);
        itemListerHoler.name.setText(list.get(position).getChapterName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickler!=null){
                    clickler.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ItemListerHoler extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView desc;
        private ImageView iv_er;
        private TextView name;
        public ItemListerHoler(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_er);
            title = itemView.findViewById(R.id.tv_title);
            desc = itemView.findViewById(R.id.tv_desc);
            iv_er = itemView.findViewById(R.id.iv_er_shang);
            name = itemView.findViewById(R.id.tv_name);
        }
    }

    interface Clickler{
        void click(int index);
    }
    private Clickler clickler;

    public void setClickler(Clickler clickler) {
        this.clickler = clickler;
    }
}
