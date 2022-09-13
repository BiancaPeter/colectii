package exercitii.gameschoolbag;

public class Main {
    public static void main(String[] args) {

        SchoolBag schoolBag = new SchoolBag();

        try {
            schoolBag.addItem(new Item("creion", 4));
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        try {
            schoolBag.addItem(new Item("hartie", 3));
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());

        }

        try {
            schoolBag.addItem(new Item("pix", 3));
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        try {
            schoolBag.addItem(new Item("guma", 2));
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(schoolBag);

        schoolBag.deleteItem(schoolBag.getItemList().get(1));
        System.out.println(schoolBag);

        System.out.println(schoolBag.getSumOfItemCapacities());

        System.out.println(schoolBag.getRestCapacityOfSchoolBag());

        System.out.println(schoolBag.getItemByName("pix"));

    }
}
