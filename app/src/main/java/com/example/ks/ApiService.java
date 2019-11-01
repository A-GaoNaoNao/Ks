package com.example.ks;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("https://www.wanandroid.com/project/list/1/json?cid=294")
    Observable<ItemList>getItemList();
}
