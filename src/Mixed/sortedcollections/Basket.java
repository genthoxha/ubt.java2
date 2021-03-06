package Mixed.sortedcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final String name;
    private final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBaskete(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket);
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }
}
