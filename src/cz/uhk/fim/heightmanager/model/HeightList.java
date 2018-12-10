package cz.uhk.fim.heightmanager.model;

import java.util.ArrayList;
import java.util.List;

public class HeightList {
    private List<HeightItem> itemList = new ArrayList<>();

    public void addItem(HeightItem item) {
        itemList.add(item);
    }

    public HeightItem getItemByIndex(int index){
        return itemList.get(index);
    }

    public int getItemCount(){
        return itemList.size();
    }

}
