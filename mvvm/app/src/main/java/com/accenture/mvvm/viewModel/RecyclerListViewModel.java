package com.accenture.mvvm.viewModel;
import com.accenture.mvvm.R;
import com.accenture.mvvm.model.ItemEntity;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.shuffle;
public class RecyclerListViewModel{
    List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();
    int[] images = {R.drawable.day0301, R.drawable.day0302,R.drawable.day0303,R.drawable.day0304,R.drawable.day0305,R.drawable.day0306,R.drawable.day0307,R.drawable.day0308};
    public void initData(List<ItemEntity> itemEntityList) {
        for (int i = 0; i <images.length; i++) {
            ItemEntity itemEntity = new ItemEntity(images[i],"item:"+i);
            itemEntityList.add(itemEntity);
        }
    }
    public void sort(List<ItemEntity> item) {
        for(int i = 0; i < item.size(); i++) {
            item.get(i).setImageUrl(images[i]);
            item.get(i).setContent("Refresh item,the random num id:" + i);
        }
        shuffle(item);
    }
}
