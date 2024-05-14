import java.util.List;

public class State {
    public void insert(Coin c){
        throw new IllegalStateException();
    }

    public List refund(){
        throw new IllegalStateException();
    }

    public int choose(Item i){
        throw new IllegalStateException();
    }

    public Item dispense(){
        throw new IllegalStateException();
    }

    public List getChange(){
        throw new IllegalStateException();
    }
}
