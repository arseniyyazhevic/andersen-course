package util;

import entity.Booking;

import java.util.*;

public class SortingUtil {

    public static <V> Map<Integer, V> sortById(HashMap<Integer, V> hashMap) {
        List<Map.Entry<Integer, V>> list = hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList();
        Map<Integer, V> sortedMap = new LinkedHashMap<>();
        list.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }

    public static Map<Integer, Booking> sortBookingsByDate(HashMap<Integer, Booking> hashMap) {
        List<Map.Entry<Integer, Booking>> list = hashMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.comparing(Booking::getDate)))
                .toList();
        Map<Integer, Booking> sortedMap = new LinkedHashMap<>();
        list.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }
}
