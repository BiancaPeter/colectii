package exercitii.gameschoolbag;

import java.util.ArrayList;
import java.util.List;

public class SchoolBag {
    private List<Item> itemList;
    private static final Integer maxCapacityOfSchoolBag = 10;

    public SchoolBag() {
        this.itemList = new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item newItem) {
        Integer sum = getSumOfItemCapacities();
        if (sum + newItem.getCapacity() <= maxCapacityOfSchoolBag) {
            itemList.add(newItem);
        }
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }

    public Integer getSumOfItemCapacities() {
        Integer sum = 0;
        for (Item item : itemList) {
            sum += item.getCapacity();
        }
        return sum;
    }

    public Integer getRestCapacityOfSchoolBag(){
        return maxCapacityOfSchoolBag-getSumOfItemCapacities();
    }

    @Override
    public String toString() {
        return "SchoolBag{" +
                "itemList=" + itemList +
                '}';
    }
}
