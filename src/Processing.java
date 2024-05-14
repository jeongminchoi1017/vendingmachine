import java.util.List;

public class Processing extends State{
    private VendingMachine machine;

    public Processing(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insert(Coin c){
        machine.coinInventory.add(c);
        machine.balance = machine.balance + c.value();
        if(machine.balance >= machine.currentItem.getPrice()) {
            if(machine.hasChange(machine.balance - machine.currentItem.getPrice())){
                machine.setState(new Sold(machine));
            }else {
                System.out.println("기계 안에 잔액이 없습니다. 환불해주십시오.");
            }
        }
    }

    @Override
    public List refund(){
        machine.currentItem = null;
        machine.setState(new Idle(machine));
        List change = machine.getChange(machine.balance);

        machine.balance = 0;
        return change;
    }
}
