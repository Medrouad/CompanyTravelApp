package com.adlere.service;

import com.adlere.enums.Station;
import com.adlere.enums.Zone;
import com.adlere.service.PricingService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    @Test
    public void test_getTheLowestPrice_from_Station_A_To_D() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.A,Station.D);
        TreeMap<Integer, List<Integer>> expected = new TreeMap<>();
        expected.put(240, Arrays.asList(1,2));
        assertEquals(expected.firstKey(), mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    public void test_getTheLowestPrice_from_Station_A_To_C() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.A,Station.C);
        TreeMap<Integer, List<Integer>> expected = new TreeMap<>();
        expected.put(240, Arrays.asList(1,2));
        assertEquals(expected.firstKey(), mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    public void test_getTheLowestPrice_from_Station_D_To_F() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.D,Station.F);
        TreeMap<Integer, List<Integer>> expected = new TreeMap<>();
        expected.put(280, Arrays.asList(2,3));
        assertEquals(expected.firstKey(), mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    public void test_getTheLowestPrice_from_Station_C_To_F() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.C,Station.F);
        TreeMap<Integer, List<Integer>> expected = new TreeMap<>();
        expected.put(200, Arrays.asList(3,3));
        assertEquals(expected.firstKey(), mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    void test_getTheLowestPrice_from_Station_H_To_G() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.H,Station.G);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(200, Arrays.asList(4,4));
        assertEquals(expected.firstKey(),mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    void test_getTheLowestPrice_from_Station_E_To_A() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.E,Station.A);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(240, Arrays.asList(2,1));
        assertEquals(expected.firstKey(),mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    void test_getTheLowestPrice_from_Station_A_To_H() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.A,Station.H);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(300, Arrays.asList(1,4));
        assertEquals(expected.firstKey(),mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    void test_getTheLowestPrice_from_Station_B_To_F() {
        Map.Entry<Integer, List<Integer>> mapEntry = PricingService.getTheLowestPrice(Station.B,Station.F);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(280, Arrays.asList(1,3));
        assertEquals(expected.firstKey(),mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(), mapEntry.getValue());
    }

    @Test
    public void test_zonePriceLinkage() {
        assertEquals(Arrays.asList(Zone.ZONE_ONE), Station.A.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_ONE), Station.B.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_TWO), Station.D.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_TWO), Station.C.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_TWO), Station.E.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_FOUR), Station.F.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.G.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.H.getZoneOfStation());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.I.getZoneOfStation());
    }



}
