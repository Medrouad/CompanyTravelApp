package com.service;

import com.enums.Zone;
import com.enums.Station;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PricingService {


    public static Map.Entry<Integer, List<Integer>> getTheLowestPrice(Station from, Station to) {
        TreeMap<Integer, List<Integer>> lowerZoneMap = new TreeMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : zonePriceLinkage().entrySet()) {
            List<Zone> fromZones = from.getZoneOfStation();
            List<Zone> toZones = to.getZoneOfStation();
            fromZones.forEach(e -> {
                toZones.forEach(v -> {
                    if (entry.getValue().containsAll(Arrays.asList(e.getValue(), v.getValue())))
                        lowerZoneMap.put(entry.getKey(), Arrays.asList(e.getValue(), v.getValue()));
                });
            });
        }
        if(lowerZoneMap.firstEntry().getValue().get(0)==3 && lowerZoneMap.firstEntry().getValue().get(1)==4){
            lowerZoneMap.replace(lowerZoneMap.firstKey(),Arrays.asList(3,3));
        }
        return lowerZoneMap.firstEntry();
    }

    public static TreeMap<Integer, List<Integer>> zonePriceLinkage() {
        TreeMap<Integer, List<Integer>> mapPriceToZone = new TreeMap<>();
        mapPriceToZone.put(200, Arrays.asList(Zone.ZONE_TREE.value, Zone.ZONE_FOUR.value));
        mapPriceToZone.put(240, Arrays.asList(Zone.ZONE_ONE.value, Zone.ZONE_TWO.value));
        mapPriceToZone.put(280, Arrays.asList(Zone.ZONE_ONE.value, Zone.ZONE_TWO.value, Zone.ZONE_TREE.value));
        mapPriceToZone.put(300, Arrays.asList(Zone.ZONE_ONE.value, Zone.ZONE_TWO.value, Zone.ZONE_FOUR.value));

        return mapPriceToZone;
    }

}
