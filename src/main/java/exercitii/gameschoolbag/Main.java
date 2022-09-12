package exercitii.gameschoolbag;

public class Main {
    public static void main(String[] args) {

        SchoolBag schoolBag = new SchoolBag();
        schoolBag.addItem(new Item("creion", 4));
        schoolBag.addItem(new Item("hartie", 3));
        schoolBag.addItem(new Item("pix", 3));
        System.out.println(schoolBag);

        schoolBag.deleteItem(schoolBag.getItemList().get(1));
        System.out.println(schoolBag);

        System.out.println(schoolBag.getSumOfItemCapacities());

        System.out.println(schoolBag.getRestCapacityOfSchoolBag());

    }


}
