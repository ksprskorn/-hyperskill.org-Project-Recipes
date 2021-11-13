import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> smallest = new HashMap<>(map1.size() <= map2.size() ? map1 : map2);
        Map<String, String> biggest = new HashMap<>(map1.size() > map2.size() ? map1 : map2);
        int count = 0;
        for (Map.Entry entrySmall : smallest.entrySet()) {
            for (Map.Entry entryBig : biggest.entrySet()) {
                if (entrySmall.getKey().equals(entryBig.getKey())
                        && entrySmall.getValue().equals(entryBig.getValue())) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}