package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long duration = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Reservation dates for update must be future dates!";
		}
		if(!checkout.after(checkin)){
			return "Check-out date must be after check-in date!";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservtion: ");
		sb.append("Room " + roomNumber);
		sb.append(", Check-in: " + sdf.format(checkin));
		sb.append(", Check-out: " + sdf.format(checkout));
		sb.append("," + duration() + " nights.");
		
		return sb.toString();
	}
}