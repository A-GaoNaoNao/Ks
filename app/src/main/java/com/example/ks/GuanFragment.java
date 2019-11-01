package com.example.ks;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ks.minap.MinaPertent;
import com.example.ks.minap.MinaView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuanFragment extends Fragment implements MinaView, MyadapterRecyc2.Clickler {


    private RecyclerView re;
    private ArrayList<ItemList.DataBean.DatasBean> list;
    private MyadapterRecyc2 myadapterRecyc2;

    public GuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guan, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_er);

        re.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        myadapterRecyc2 = new MyadapterRecyc2(getContext(), list);

        re.setAdapter(myadapterRecyc2);

        MinaPertent pertent = new MinaPertent();
        pertent.Retrofit(this);

        myadapterRecyc2.setClickler(this);
    }

    @Override
    public void Cheng(ItemList itemList) {
        ArrayList<ItemList.DataBean.DatasBean> datas = (ArrayList<ItemList.DataBean.DatasBean>) itemList.getData().getDatas();
        list.addAll(datas);
        myadapterRecyc2.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String link = list.get(index).getLink();
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("link",link);
        startActivity(intent);
    }
}
