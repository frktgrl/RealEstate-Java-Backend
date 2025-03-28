package com.ftgrl.realestate.service;

import com.ftgrl.realestate.model.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealEstateService {
    private final List<House> houseList = List.of(
            new House(100000, 120, 3, 1),
            new House(120000, 140, 4, 1),
            new House(90000, 100, 2, 1)
    );

    private final List<Villa> villaList = List.of(
            new Villa(250000, 200, 5, 2),
            new Villa(300000, 220, 6, 3),
            new Villa(280000, 210, 5, 2)
    );

    private final List<SummerHouse> summerHouseList = List.of(
            new SummerHouse(150000, 130, 3, 1),
            new SummerHouse(160000, 135, 3, 1),
            new SummerHouse(170000, 140, 4, 1)
    );

    // **Ev Listelerini Dönen Metotlar**
    public List<House> getEvList() {
        return houseList;
    }

    public List<Villa> getVillaList() {
        return villaList;
    }

    public List<SummerHouse> getSummerHouseList() {
        return summerHouseList;
    }

    // **Fiyat Toplamı Hesaplayan Metotlar**
    public double getTotalPriceOfHouses() {
        return houseList.stream().mapToDouble(Property::getPrice).sum();
    }

    public double getTotalPriceOfVillas() {
        return villaList.stream().mapToDouble(Property::getPrice).sum();
    }

    public double getTotalPriceOfSummerHouses() {
        return summerHouseList.stream().mapToDouble(Property::getPrice).sum();
    }

    public double getTotalPriceOfAllProperties() {
        return getTotalPriceOfHouses() + getTotalPriceOfVillas() + getTotalPriceOfSummerHouses();
    }

    // **Metrekare Ortalama Hesaplayan Metotlar**
    public double getAverageSquareMetersOfHouses() {
        return houseList.stream().mapToDouble(Property::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMetersOfVillas() {
        return villaList.stream().mapToDouble(Property::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMetersOfSummerHouses() {
        return summerHouseList.stream().mapToDouble(Property::getSquareMeters).average().orElse(0);
    }

    public double getAverageSquareMetersOfAllProperties() {
        double totalSquareMeters = houseList.stream().mapToDouble(Property::getSquareMeters).sum()
                + villaList.stream().mapToDouble(Property::getSquareMeters).sum()
                + summerHouseList.stream().mapToDouble(Property::getSquareMeters).sum();
        int totalProperties = houseList.size() + villaList.size() + summerHouseList.size();
        return totalProperties > 0 ? totalSquareMeters / totalProperties : 0;
    }

    // **Oda ve Salon Sayısına Göre Evleri Filtreleyen Metot**
    public List<Property> filterPropertiesByRoomsAndLivingRoom(int rooms, int livingRooms) {
        return List.of(houseList, villaList, summerHouseList).stream()
                .flatMap(List::stream)
                .filter(p -> p.getRooms() == rooms && p.getLivingRooms() == livingRooms)
                .collect(Collectors.toList());
    }
}
