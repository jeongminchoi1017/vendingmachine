public class Idle extends State {
    private VendingMachine machine;

    public Idle(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public int choose(Item i){
        if(machine.itemInventory.getCount(i) >= 1){
            machine.currentItem = i;
            machine.setState(new Processing(machine));
        }else {
            System.out.println(i + "품절되었습니다. 다른 음료를 선택하세요.");
        }
        return i.getPrice();
    }
}
