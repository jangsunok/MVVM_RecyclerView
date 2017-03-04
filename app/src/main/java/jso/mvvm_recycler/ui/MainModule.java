package jso.mvvm_recycler.ui;

import dagger.Module;
import dagger.Provides;
import jso.mvvm_recycler.scope.PerActivity;

/**
 * Created by jang on 2017. 3. 2..
 */


@Module
public class MainModule {

    MainActivity activity;


    public MainModule(MainActivity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    MainActivity provideMainActivity(){ return activity; }



}
