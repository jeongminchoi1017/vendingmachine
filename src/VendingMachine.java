import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    Inventory itemInventory = new Inventory();
    Inventory coinInventory = new Inventory();

    Item currentItem;
    int balance;

    public VendingMachine(){
        state = new SoldOut(this);
        initialize();
    }

    public void insert(Coin c) {
        state.insert(c);
    }

    public List refund(){
        return state.refund();
    }
    public int choose(Item i) {
        return state.choose(i);
    }

    public Item dispense(){
        return state.dispense();
    }

    public void setState(State newState){
        state = newState;
    }
    public List getChange(){
        return state.getChange();
    }

    private void initialize(){
        loadCoins();
        loadItems();
        this.state = new Idle(this);
    }

    private void loadCoins(){
        for(Coin c: Coin.values()) {
            coinInventory.add(c);
            coinInventory.add(c);
            coinInventory.add(c);
            coinInventory.add(c);
            coinInventory.add(c);
        }
    }
    
    private void loadItems(){
        for(Item i : Item.values()){
            itemInventory.add(i);
            itemInventory.add(i);
            itemInventory.add(i);
            itemInventory.add(i);
            itemInventory.add(i);
        }
    }

    List getChange(int balance){
        List change = new ArrayList();
        while(balance != 0){
            if(balance >= Coin.THOUSAND.value() && coinInventory.has(Coin.THOUSAND)){
                balance -= Coin.THOUSAND.value();
                change.add(Coin.THOUSAND);
                coinInventory.take(Coin.THOUSAND);
            }else if(balance >= Coin.F_HUNDRED.value() && coinInventory.has(Coin.F_HUNDRED)){
                balance -= Coin.F_HUNDRED.value();
                change.add(Coin.F_HUNDRED);
                coinInventory.take(Coin.F_HUNDRED);
            }else if(balance >= Coin.HUNDRED.value() && coinInventory.has(Coin.HUNDRED)){
                balance -= Coin.HUNDRED.value();
                change.add(Coin.HUNDRED);
                coinInventory.take(Coin.HUNDRED);
            }
            if (coinInventory.isEmpty() && balance > 0) {
                throw new NotSufficientChangeException("돈이 부족합니다.");
            }
        }
        return change;

    }

    boolean hasChange(int change) {
        try {
            List<Coin> coins = getChange(change);

            for(Coin c : coins){
                coinInventory.add(c);
            }
        }catch(NotSufficientChangeException ex){
            return false;
        }

        return true;
    }
    
}
