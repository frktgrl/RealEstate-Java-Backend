package com.ftgrl.realestate;

import com.ftgrl.realestate.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateApplication implements CommandLineRunner {

	@Autowired
	private RealEstateService realEstateService;

	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("=== Real Estate Report ===");
		System.out.println("House List: " + realEstateService.getEvList());
		System.out.println("Villa List: " + realEstateService.getVillaList());
		System.out.println("🏖Summer House List: " + realEstateService.getSummerHouseList());

		System.out.println("\n Total Prices:");
		System.out.println("Houses: " + realEstateService.getTotalPriceOfHouses() + " TL");
		System.out.println("Villas: " + realEstateService.getTotalPriceOfVillas() + " TL");
		System.out.println("Summer Houses: " + realEstateService.getTotalPriceOfSummerHouses() + " TL");
		System.out.println("All Properties: " + realEstateService.getTotalPriceOfAllProperties() + " TL");

		System.out.println("\n Average Square Meters:");
		System.out.println("Houses: " + realEstateService.getAverageSquareMetersOfHouses() + " m²");
		System.out.println("Villas: " + realEstateService.getAverageSquareMetersOfVillas() + " m²");
		System.out.println("Summer Houses: " + realEstateService.getAverageSquareMetersOfSummerHouses() + " m²");
		System.out.println("All Properties: " + realEstateService.getAverageSquareMetersOfAllProperties() + " m²");

		int rooms = 3;
		int livingRooms = 1;
		System.out.println("\n Filtering properties with " + rooms + " rooms and " + livingRooms + " living room:");
		System.out.println(realEstateService.filterPropertiesByRoomsAndLivingRoom(rooms, livingRooms));
	}
}
