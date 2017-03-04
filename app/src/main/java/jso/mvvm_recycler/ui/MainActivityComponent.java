package jso.mvvm_recycler.ui;

import dagger.Component;
import jso.mvvm_recycler.scope.PerActivity;

/**
 * Created by jang on 2017. 3. 2..
 */

@PerActivity
@Component(modules = MainModule.class)
public interface MainActivityComponent {
//    void inject(MainActivityViewModel __);
}
