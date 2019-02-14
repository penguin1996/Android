package com.accenture.mvvm.view.Adapters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.accenture.mvvm.R;
import com.accenture.mvvm.databinding.GirlsListBinding;
import com.accenture.mvvm.model.ItemEntity;
import java.util.List;

 public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MailTypeViewHolder> {
    private List<ItemEntity> itemEntityList;

    public ItemAdapter(List<ItemEntity> itemEntityList){
        this.itemEntityList = itemEntityList;
    }

    @Override
    public ItemAdapter.MailTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GirlsListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.girls_list, parent, false);
        return new MailTypeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.MailTypeViewHolder holder, int position) {
        holder.binding.setItem(itemEntityList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemEntityList.size();
    }

     @BindingAdapter({"android:src"})
     public static void setImageResource(ImageView imageView, int resource ) {
         imageView.setImageResource( resource );
     }

    class MailTypeViewHolder extends RecyclerView.ViewHolder{

        GirlsListBinding binding;

        public MailTypeViewHolder(GirlsListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
