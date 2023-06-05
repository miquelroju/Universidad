package prac1;

import java.util.*;

public class VehicleParkImplementation implements VehiclePark {

	private Collection<Vehicle> infrastructure;
	// do not add more attributes. This is all you really need

	public VehicleParkImplementation() {
		infrastructure = new ArrayList<Vehicle>();/* COMPLETE */
	}

	@Override
	public int numVehicles() {
		/* Returns the number of vehicles currently in the vehicle park */
		/* COMPLETE */
		int resultat = 0;
		Iterator<Vehicle> it = infrastructure.iterator();
		while (it.hasNext()) {
			resultat++;
		}
		return resultat;
	}

	@Override
	public boolean isEmpty() {
		/* Returns true if the vehicle park is empty, false otherwise */
		/* COMPLETE */
		if (numVehicles() == 0)
			return true;
		return false;
	}

	@Override
	public int numPrivate() {
		/* Returns the number of private vehicles in the Vehicle Park */
		/* COMPLETE */
		int resultat = 0;
		Iterator<Vehicle> it = infrastructure.iterator();
		Vehicle v;
		while (it.hasNext()) {
			v = it.next();
			if (v instanceof PrivateVehicle) {
				resultat++;
			}
		}
		return resultat;
	}

	@Override
	public boolean inPark(Plate p) {
		/* Returns true if the vehicle park contains a vehicle with plate p */
		/* COMPLETE */
		Iterator<Vehicle> it = infrastructure.iterator();
		Vehicle v;
		while (it.hasNext()) {
			v = it.next();
			if (v.getPlate().equals(p))
				return true;
		}
		return false;
	}

	@Override
	public void enter(Vehicle v) {
		/*
		 * Stores c in the VehiclePark, if possible. Throws (and does not store v): - a
		 * NullPointerException if the parameter is null - a AlreadyStoredException if
		 * the VehiclePark already contains a vehicle "like" v
		 */
		/* COMPLETE */

		boolean trobat = false;
		Iterator<Vehicle> it = infrastructure.iterator();
		Vehicle vact;
		while (it.hasNext()) {
			vact = it.next();
			if (vact.equals(v))
				trobat = true;
		}

		if (v.equals(null))
			throw new NullPointerException("Vehicle nul");
		else if (trobat)
			throw new AlreadyStoredException("Vehicle ja guardat");
		else
			infrastructure.add(v);

	}

	@Override
	public int enter(Collection vehicles) {
		/*
		 * Stores in the VehiclePark the vehicles contained in the parameter Beware: the
		 * parameter may contain objects that are not vehicles Beware: the parameter may
		 * contain null objects Beware: the parameter may contain repetition
		 * 
		 * Returns: the number of vehicles effectively stored
		 * 
		 * This method does not throw exceptions
		 */

		/*
		 * base this methods in the previous one (make it call the previous one)
		 */

		/* COMPLETE */

		int resultat = 0;
		if (vehicles instanceof Vehicle) {
			Iterator<Vehicle> it = vehicles.iterator();
			Vehicle v;
			while (it.hasNext()) {
				v = it.next();
				enter(v);

				// NO S� COM SABER SI S'HA AFEGIT EL VEHICLE O NO

				resultat++;

			}
		}
		return resultat;
	}

	@Override
	public boolean leave(Plate p) {
		/*
		 * Removes from VehiclePark all vehicles with Plate p Returns true if a vehicle
		 * has been removed. False otherwise
		 */

		/*
		 * You can take into account that Vehicle equality is based on Plate equality
		 */

		/* COMPLETE */

		Iterator<Vehicle> it = infrastructure.iterator();
		Vehicle v;

		while (it.hasNext()) {
			v = it.next();
			if (v.getPlate().equals(p)) {
				it.remove();
				return true;
			}
		}
		return false;

	}

	@Override
	public Vehicle[] leave(String owner) {
		/*
		 * Removes from VehiclePark all vehicles that "belong" to the given owner
		 * (parameter) Returns an array containing all the removed vehicles. This array:
		 * - has the exact length (no empty -null- positions) - has length 0 if no
		 * vehicles has been removed - is sorted according to the natural ordering of
		 * the vehicles (ascending)
		 */
		/* COMPLETE */

		int quants = 0, i = 0;
		Vehicle[] res;
		Vehicle v;
		Iterator<Vehicle> it = infrastructure.iterator();

		while (it.hasNext()) {
			v = it.next();
			if (v.getOwner().equals(owner)) {
				quants++;
			}
		}

		res = new Vehicle[quants];

		while (it.hasNext()) {
			v = it.next();
			if (v.getOwner().equals(owner)) {
				res[i] = v;
				it.remove();
				i++;
			}
		}

		Arrays.sort(res);
		return res;

	}

	@Override
	public boolean containsDangerousPayload() {
		/*
		 * Returns true if the VehiclePark contains any CommercialVehicle the payload of
		 * which is dangerous. False otherwise;
		 */
		/* COMPLETE */
		
		Iterator<Vehicle> it = infrastructure.iterator();
		Vehicle v;
		
		while (it.hasNext()) {
			v = it.next();
			if (v instanceof CommercialVehicle) {
				if(((CommercialVehicle) v).containsDangerousPayload())
					return true;
			}
		}
		
		return false;

	}

}
