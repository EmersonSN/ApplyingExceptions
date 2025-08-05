package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date(DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date(DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(DD/MM/YYYY): ");
            Date now = new Date();
            checkOut = sdf.parse(sc.next());
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update mus be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }

        sc.close();
    }
}
