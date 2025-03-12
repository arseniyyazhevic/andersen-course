package util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortingUtil {
    public static <V> Map<Integer, V> sortById(HashMap<Integer, V> map) {
        List<Map.Entry<Integer, V>> list = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList();
        Map<Integer, V> sortedMap = new LinkedHashMap<>();
        list.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }
}
