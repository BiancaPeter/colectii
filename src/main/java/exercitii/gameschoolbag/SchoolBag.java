package exercitii.gameschoolbag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addItem(Item newItem) throws OperationNotSupportedException {
        Integer sum = getSumOfItemCapacities();
        if (sum + newItem.getCapacity() <= maxCapacityOfSchoolBag) {
            itemList.add(newItem);
        } else {
            throw new OperationNotSupportedException("Item exceeds capacity");
        }
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }

    public Integer getSumOfItemCapacities() {
//        Integer sum = 0;
//        for (Item item : itemList) {
//            sum += item.getCapacity();
//        }
//        return sum;
        Optional<Integer> optionalSum = itemList.stream()
                .map(item -> item.getCapacity())
                .reduce((sum, capacity) -> sum + capacity);
        return optionalSum.orElse(0);
    }

    public Integer getRestCapacityOfSchoolBag() {
        return maxCapacityOfSchoolBag - getSumOfItemCapacities();
    }

    public Item getItemByName(String name) {
        Optional<Item> foundItemByName = itemList.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
        return foundItemByName.orElse(null);
    }

    @Override
    public String toString() {
        return "SchoolBag{" +
                "itemList=" + itemList +
                '}';
    }
}
