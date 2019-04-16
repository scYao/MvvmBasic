package com.baisidai.mvvmbasic.viewmodel;

import android.databinding.BaseObservable;
import android.util.Log;

import com.baisidai.mvvmbasic.CompletedListener;
import com.baisidai.mvvmbasic.adapter.MainAdapter;
import com.baisidai.mvvmbasic.base.BaseBean;
import com.baisidai.mvvmbasic.bean.PublicNumberBean;
import com.baisidai.mvvmbasic.data.MainRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainViewModel{
    MainRepository repository = new MainRepository();
    private Observer<BaseBean<List<PublicNumberBean>>> observer;
    private MainAdapter adapter;
    private CompletedListener completedListener;//完成监听主要是为了在activity中关闭菊花图

    public MainViewModel( MainAdapter adapter,CompletedListener completedListener) {
        this.adapter = adapter;
        this.completedListener = completedListener;
    }

    public void getList() {
      observer = new Observer<BaseBean<List<PublicNumberBean>>>() {
          @Override
          public void onSubscribe(Disposable d) {

          }

          @Override
          public void onNext(BaseBean<List<PublicNumberBean>> listBaseBean) {
              if (listBaseBean.getErrorCode() ==0){
                  adapter.setData(listBaseBean.getData());
              }
          }

          @Override
          public void onError(Throwable e) {
            completedListener.onCompleted();
          }

          @Override
          public void onComplete() {
            completedListener.onCompleted();
          }
      };
        repository.getList(observer);
    }

}
