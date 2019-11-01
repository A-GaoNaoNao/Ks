package com.example.ks.minap;

import com.example.ks.ItemList;
import com.example.ks.minam.MinaMedlo;
import com.example.ks.minam.Minabackll;

public class MinaPertent {
    public void Retrofit(final MinaView minaView){
        MinaMedlo medlo = new MinaMedlo();
        medlo.Retrofit(new Minabackll() {
            @Override
            public void ChengGong(ItemList itemList) {
                if (minaView!=null && itemList!=null){
                    minaView.Cheng(itemList);
                }
            }

            @Override
            public void ShiBai(Throwable e) {
                if (minaView!=null && e!=null){
                    minaView.Shi(e);
                }
            }
        });
    }
}
