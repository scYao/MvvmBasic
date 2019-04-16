package com.baisidai.mvvmbasic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baisidai.mvvmbasic.adapter.MainAdapter;
import com.baisidai.mvvmbasic.base.BaseActivity;
import com.baisidai.mvvmbasic.databinding.ActivityMainBinding;
import com.baisidai.mvvmbasic.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity implements CompletedListener{
    private MainViewModel viewModel;
    private LinearLayoutManager layoutManager;
    private MainAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        viewModel = new MainViewModel(adapter,this);
        showWaitDialog();//显示加载动画
        viewModel.getList();
    }

    @Override
    public void onCompleted() {
        dismissWaitDialog();
    }
}
