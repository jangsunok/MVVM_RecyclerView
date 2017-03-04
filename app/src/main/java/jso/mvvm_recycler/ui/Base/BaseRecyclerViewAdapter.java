package jso.mvvm_recycler.ui.Base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathpresso on 2017-03-03.
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Object> itemList = new ArrayList<>();

    public List<Object> itemList() {
        return itemList;
    }

    public void clearItemList() {
        itemList.clear();
    }

    public <T> void addItem(final @NonNull T item) {
        itemList.add(item);
    }

    public <T> void addItems(final @NonNull ArrayList<T> items) {
        for(Object item : items){
            itemList.add(item);
        }
    }


    public <T> void setItem(final int location, final @NonNull Object item) {
        itemList.set(location, item);
    }

    public <T> void insertItem(final int location, final @NonNull Object item) {
        itemList.add(location, item);
    }

    /**
     * Fetch the layout id associated with a sectionRow.
     */
    protected abstract int layout(int position);

    /**
     * Returns a new BaseViewHolder given a layout and view.
     */
    protected abstract @NonNull BaseViewHolder viewHolder(final @LayoutRes int layout, final @NonNull View view);


    @Override
    public final @NonNull BaseViewHolder onCreateViewHolder(final @NonNull ViewGroup viewGroup, final @LayoutRes int layout) {
        final View view = inflateView(viewGroup, layout);
        final BaseViewHolder viewHolder = viewHolder(layout, view);
        return viewHolder;
    }


    @Override
    public final void onBindViewHolder(final @NonNull BaseViewHolder viewHolder, final int position) {
        final Object data = itemList.get(position);
        try {
            viewHolder.bindData(data);
            //viewHolder.onBind();
        } catch (final Exception e) {

        }
    }


    @Override
    public final int getItemViewType(final int position) {
        return layout(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * Gets the data object associated with a position.
     */
    protected Object objectFromPosition(final int position) {
        return itemList.get(position);
    }

    private @NonNull View inflateView(final @NonNull ViewGroup viewGroup, final @LayoutRes int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return layoutInflater.inflate(viewType, viewGroup, false);
    }
}
