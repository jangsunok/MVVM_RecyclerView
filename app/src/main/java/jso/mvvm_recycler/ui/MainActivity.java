package jso.mvvm_recycler.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import jso.mvvm_recycler.R;
import jso.mvvm_recycler.databinding.ActivityMainBinding;
import jso.mvvm_recycler.models.SampleViewHolderModel;
import jso.mvvm_recycler.ui.adapters.RecyclerViewExampleAdpater;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by jang on 2017. 3. 2..
 */

public class MainActivity extends AppCompatActivity {




    RecyclerViewExampleAdpater adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        AppComponent appComponent = ((MyApplication)getApplication()).getAppComponent();
//        appComponent.inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView recyclerView = binding.recyclerView;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewExampleAdpater();
        recyclerView.setAdapter(adapter);


        //Add Data to RecyclerView > User Observable
        //ArrayList<SampleViewHolderModel> models = new ArrayList<>();

        Observable.just(
                new SampleViewHolderModel("JangSunOk", "hello", "01012341234"),
                new SampleViewHolderModel("SunOk", "hello1", "01045674567"),
                new SampleViewHolderModel("Jang", "hello2", "01098769876"))
                .subscribe(new Action1<SampleViewHolderModel>() {
                    @Override
                    public void call(SampleViewHolderModel models) {
                        Log.d("recyclerView", "call models");
                        adapter.addData(models);
                    }
                });

//        ArrayList<SampleViewHolderModel> list = new ArrayList<>();
//        list.add(new SampleViewHolderModel("JangSunOk", "hello", "01012341234"));
//        list.add(new SampleViewHolderModel("SunOk", "hello1", "01045674567"));
//        list.add(new SampleViewHolderModel("Jang", "hello2", "01098769876"));
//        adapter.addItems(list);



    }

}
