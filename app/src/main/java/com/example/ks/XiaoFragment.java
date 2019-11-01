package com.example.ks;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ks.adapter.MyadapterRecyc;
import com.example.ks.minap.MinaPertent;
import com.example.ks.minap.MinaView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoFragment extends Fragment implements MinaView, MyadapterRecyc.Clickl {


    private RecyclerView re;
    private ArrayList<ItemList.DataBean.DatasBean> datasBeans;
    private MyadapterRecyc myadapterRecyc;

    public XiaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xiao, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re);

        re.setLayoutManager(new LinearLayoutManager(getContext()));

        datasBeans = new ArrayList<>();

        myadapterRecyc = new MyadapterRecyc(getContext(), datasBeans);

        re.setAdapter(myadapterRecyc);

        MinaPertent pertent = new MinaPertent();
        pertent.Retrofit(this);

        myadapterRecyc.setClickl(this);

        re.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void Cheng(ItemList itemList) {
        ArrayList<ItemList.DataBean.DatasBean> datas = (ArrayList<ItemList.DataBean.DatasBean>) itemList.getData().getDatas();
        Log.i("Gao", "Cheng: "+datas);
        datasBeans.addAll(datas);
        myadapterRecyc.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String link = datasBeans.get(index).getLink();
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("link",link);
        startActivity(intent);
    }
}
