package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Room number:");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in (DD/MM/YYYY):");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out (DD/MM/YYYY):");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation.toString());
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in (DD/MM/YYYY):");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY):");
			checkout = sdf.parse(sc.next());

			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println(reservation.toString());
			}
		}
		sc.close();
	}
}