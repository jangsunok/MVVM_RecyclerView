package jso.mvvm_recycler.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by jang on 2017. 3. 2..
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
