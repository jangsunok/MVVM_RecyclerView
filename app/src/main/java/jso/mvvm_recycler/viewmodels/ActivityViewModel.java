package jso.mvvm_recycler.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Mathpresso9 on 2017-02-28.
 */

public class ActivityViewModel<ViewType> extends BaseObservable {
    private final PublishSubject<ViewType> viewChange = PublishSubject.create();
    private final Observable<ViewType> view = viewChange.filter(getNotNullFilterFunc());
    private final CompositeSubscription subscriptions = new CompositeSubscription();

//    private final PublishSubject<ActivityResult> activityResult = PublishSubject.create();

    private final PublishSubject<Intent> intent = PublishSubject.create();

    public ActivityViewModel() {
    }

    private Func1<ViewType, Boolean> getNotNullFilterFunc() {
        return new Func1<ViewType, Boolean>() {
            @Override
            public Boolean call(ViewType viewType) {
                return view != null;
            }
        };
    }

//    public void activityResult(final @NonNull ActivityResult activityResult) {
//        this.activityResult.onNext(activityResult);
//    }


    public void intent(final @NonNull Intent intent) {
        this.intent.onNext(intent);
    }

//    protected
//    @NonNull
//    Observable<ActivityResult> activityResult() {
//        return activityResult;
//    }

    public @NonNull Observable<Intent> intent() {
        return intent;
    }


    @CallSuper
    public void onCreate(final @NonNull Context context, final @Nullable Bundle savedInstanceState) {
        dropView();
    }

    @CallSuper
    public void onResume(final @NonNull ViewType view) {
        onTakeView(view);
    }

    @CallSuper
    public void onPause() {
        dropView();
    }

    @CallSuper
    public void onDestroy() {
        subscriptions.clear();
        viewChange.onCompleted();
    }

    private void onTakeView(final @NonNull ViewType view) {
        viewChange.onNext(view);
    }

    private void dropView() {
        viewChange.onNext(null);
    }


    /**
     * By composing this transformer with an observable you guarantee that every observable in your view model
     * will be properly completed when the view model completes.
     *
     * It is required that *every* observable in a view model do `.compose(bindToLifecycle())` before calling
     * `subscribe`.
     */
//    public @NonNull <T> Observable.Transformer<T, T> bindToLifecycle() {
//        return source -> source.takeUntil(
//                view.switchMap(v -> v.lifecycle().map(e -> Pair.create(v, e)))
//                        .filter(ve -> isFinished(ve.first, ve.second))
//        );
//    }

    /**
     * Determines from a view and lifecycle event if the view's life is over.
     */
//    private boolean isFinished(final @NonNull ViewType view, final @NonNull ActivityEvent event) {
//        return event == ActivityEvent.DESTROY;
//    }

}
