package com.accenture.mvvmOnline.viewModel;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import com.accenture.mvvmOnline.ItemApi.ItemEntitiesApi;
import com.accenture.mvvmOnline.model.ItemEntities;
import com.accenture.mvvmOnline.view.adapters.ItemAdapter;
import com.accenture.myapplication.R;
import com.accenture.myapplication.databinding.FragmentListBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerListViewModel {
    private List<Uri> uri = new ArrayList<>();
    private Context context;
    private FragmentListBinding fragmentListBinding;
    private List<ItemEntities.ResultsBean> itemEntityList = new ArrayList<ItemEntities.ResultsBean>();

 public RecyclerListViewModel (Context context,FragmentListBinding fragmentListBinding) {
        this.context = context;
        this.fragmentListBinding = fragmentListBinding;
    }
    public void loadData(String kinds,int num,int page) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.getString(R.string.url))
                .build();

        ItemEntitiesApi itemEntitiesApi = retrofit.create(ItemEntitiesApi.class);
        Call<ItemEntities> query = itemEntitiesApi.query(kinds,num,page);
        query.enqueue(new Callback<ItemEntities>() {
            @Override
            public void onResponse(Call<ItemEntities> call, Response<ItemEntities> response) {
                ItemEntities itemEntities = response.body();
                for(ItemEntities.ResultsBean resultsBean : itemEntities.getResults()) {
                    itemEntityList.add(resultsBean);
                if(resultsBean.getImages() != null && resultsBean.getImages().size() > 0) {
                    uri.add(Uri.parse(resultsBean.getImages().get(0)));
                } else {
                    uri.add(null);
                }
            }

                fragmentListBinding.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                fragmentListBinding.recyclerView.setAdapter(new ItemAdapter(context, itemEntityList, uri));
                fragmentListBinding.recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        }
        @Override
        public void onFailure(Call<ItemEntities> call, Throwable t) {
            System.out.println("Fail to get the data!");
        }
    });
 }
}

