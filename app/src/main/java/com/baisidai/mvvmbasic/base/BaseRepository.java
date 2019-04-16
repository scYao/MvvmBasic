package com.baisidai.mvvmbasic.base;

import com.baisidai.mvvmbasic.config.Url;
import com.baisidai.mvvmbasic.http.APIService;
import com.baisidai.mvvmbasic.http.HttpUtils;

public abstract class BaseRepository {
    protected APIService apiService;

    public BaseRepository() {
        if (apiService == null) {
            apiService = HttpUtils.getAPIService(Url.BASE_URL);
        }
    }

}
