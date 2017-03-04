package jso.mvvm_recycler.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import jso.mvvm_recycler.R;
import jso.mvvm_recycler.databinding.RecyclerviewItemBinding;
import jso.mvvm_recycler.models.SampleViewHolderModel;
import jso.mvvm_recycler.ui.Base.BaseRecyclerViewAdapter;
import jso.mvvm_recycler.ui.Base.BaseViewHolder;

/**
 * Created by Mathpresso on 2017-03-03.
 */

public class RecyclerViewExampleAdpater extends BaseRecyclerViewAdapter {

    public RecyclerViewExampleAdpater(){

    }


    @Override
    protected int layout(@NonNull int position) {
        //position에따른 layout지정
        return R.layout.recyclerview_item;
//        if(position==0){
//            return R.layout.recyclerview_item;
//        }else {
//            return R.layout.recyclerview_item;
//        }
    }

    @NonNull
    @Override
    protected BaseViewHolder viewHolder(@LayoutRes int layout, @NonNull View view) {
        //layout에 따른 viewholder 생성
        Log.d("recyclerView", "viewholder in RecyclerViewExampleAdpater");
        if(layout==R.layout.recyclerview_item){
            return new ExampleRecyclerViewHolder(view);
        }else {
            return null;
            //return new ExampleRecyclerViewHolder(view);
        }

    }

    public void addData(final @NonNull SampleViewHolderModel model) {
        //clearSections();
        Log.d("recyclerView", "addData in RecyclerViewExampleAdpater");
        addItem(model);
        notifyDataSetChanged();
    }


    public class ExampleRecyclerViewHolder extends BaseViewHolder{
        View view;
        RecyclerviewItemBinding binding;


        public ExampleRecyclerViewHolder(View view){
            super(view);
            this.view = view;
            binding = DataBindingUtil.bind(view);
        }

        @Override
        public void bindData(@Nullable Object data) throws Exception {
            binding.setModel((SampleViewHolderModel)data);
        }

        @Override
        public void onClick(@NonNull View view) {
            super.onClick(view);
            Toast.makeText(view.getContext(), "Clicked"+view.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
