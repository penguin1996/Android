package com.accenture.mvvmOnline.view.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.accenture.mvvmOnline.model.ItemEntities;
import com.accenture.myapplication.R;
import com.accenture.myapplication.databinding.GirlsListBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
   private List<ItemEntities.ResultsBean> itemEntity;
   private Context context;
   private List<Uri> uri;

   public ItemAdapter(Context context,List<ItemEntities.ResultsBean> itemEntity,List<Uri> uri){
       this.context = context;
       this.itemEntity = itemEntity;
       this.uri = uri;
   }

   @Override
   public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       GirlsListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.girls_list, parent, false);
       return new ItemViewHolder(binding);
   }

   @Override
   public void onBindViewHolder(ItemAdapter.ItemViewHolder holder, int position) {
       holder.binding.setItem(itemEntity.get(position));
       holder.binding.SimpView.setImageURI(uri.get(position));
       holder.binding.executePendingBindings();
   }

   @Override
   public int getItemCount() {
       return itemEntity.size();
   }

  @BindingAdapter({"android:src"})
    public static void setImageResource(ImageView imageView, int resource ) {
        imageView.setImageResource( resource );
    }

   class ItemViewHolder extends RecyclerView.ViewHolder{

       GirlsListBinding binding;

       public ItemViewHolder(GirlsListBinding binding) {
           super(binding.getRoot());
           this.binding = binding;
       }

   }
}
