package jso.mvvm_recycler.ui.Base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Mathpresso on 2017-03-03.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private final View view;


    public BaseViewHolder(View view) {

        super(view);
        this.view = view;
        view.setOnClickListener(this);
    }


    /**
     * No-op click implementation. Subclasses should override this method to implement click handling.
     */

    //viewholder의 아이템 클릭이 필요하면 직접 구현해서 쓰세요~
    @Override
    public void onClick(final @NonNull View view) {

    }

    /**
     * Populate a view with data that was bound in `bindData`.
     *
     * @deprecated Prefer creating subscriptions to a viewmodel in the constructor, then using #{link #bindData} to
     *             send new data to the viewmodel.
     */
    @Deprecated
    public void onBind() {}

    /**
     * Implementations of this should inspect `data` to set instance variables in the view holder that
     * `onBind` can then use without worrying about type safety.
     *
     * @throws Exception Raised when binding is unsuccessful.
     */

    abstract public void bindData(final @Nullable Object data) throws Exception;



    /**
     * Called when the ViewHolder is being detached. Subclasses should override if they need to do any work
     * when the ViewHolder is being de-allocated.
     */
    protected void destroy() {}

    protected @NonNull View view() {
        return view;
    }

    protected @NonNull
    Context context() {
        return view.getContext();
    }
}
