package com.baisidai.mvvmbasic.data;

import com.baisidai.mvvmbasic.base.BaseBean;
import com.baisidai.mvvmbasic.base.BaseRepository;
import com.baisidai.mvvmbasic.bean.PublicNumberBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainRepository extends BaseRepository {

    public void getList(Observer<BaseBean<List<PublicNumberBean>>> observer) {
        apiService.getList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
