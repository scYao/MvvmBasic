package com.baisidai.mvvmbasic.http;

import com.baisidai.mvvmbasic.base.BaseBean;
import com.baisidai.mvvmbasic.bean.PublicNumberBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("wxarticle/chapters/json")
    Observable<BaseBean<List<PublicNumberBean>>> getList();
}
