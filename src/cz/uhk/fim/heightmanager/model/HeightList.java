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

    public void removeItem(int index){
        itemList.remove(index);
    }

    public List<HeightItem> getBigItems(){
        List<HeightItem> tall = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).isDostacuje()){
                tall.add(itemList.get(i));
            }
        }
        return tall;
    }

}
