import java.util.List;

public class Sold extends State{
    private VendingMachine machine;

    public Sold(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public Item dispense() {
        if(machine.itemInventory.isEmpty()) {
            machine.setState(new SoldOut(machine));
        }
        machine.balance = machine.balance - machine.currentItem.getPrice();

        machine.itemInventory.take(machine.currentItem);

        Item sold = machine.currentItem;
        machine.currentItem = null;

        return sold;
    }
    @Override
    public List getChange(){
        List change = machine.getChange(machine.balance);
        return change;
    }
}
