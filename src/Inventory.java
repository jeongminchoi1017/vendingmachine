import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map store = new ConcurrentHashMap();

    public int getCount(Item i){
        // Integer 형변환
        Integer count = (Integer) store.get(i);

        return count != null ? count : 0;
    }
    public int getCount(Coin c){
        // Integer 형변환
        Integer count = (Integer) store.get(c);

        return count != null ? count : 0;
    }
    public void add(Item i) {
        int count = getCount(i);
        store.put(i, ++count);
    }
    public void add(Coin c) {
        int count = getCount(c);
        store.put(c, ++count);
    }


    public void take(Item i) {
        int count = getCount(i);
        store.put(i, --count);
    }
    public void take(Coin c) {
        int count = getCount(c);
        store.put(c, --count);
    }


    public boolean isEmpty(){
        return store.isEmpty();
    }
    boolean has(Item i){
        return getCount(i) > 0;
    }
    boolean has(Coin c){
        return getCount(c) > 0;
    }
}
