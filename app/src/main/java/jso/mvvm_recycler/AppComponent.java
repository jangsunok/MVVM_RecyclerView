package jso.mvvm_recycler;

import javax.inject.Singleton;

import dagger.Component;
import jso.mvvm_recycler.ui.MainActivity;

/**
 * Created by jang on 2017. 3. 2..
 */

@Singleton
@Component( modules = AppModule.class )
public interface AppComponent {

    void inject(MainActivity __);

}
