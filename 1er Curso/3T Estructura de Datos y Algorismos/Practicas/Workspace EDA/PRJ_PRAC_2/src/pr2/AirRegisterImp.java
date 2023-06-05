package pr2;

import java.util.SortedSet;
import java.util.*;

public class AirRegisterImp implements AirRegister {

	private Map<Company, Set<Aircraft>> infrastructure;

	public AirRegisterImp() {
		infrastructure = new HashMap<Company, Set<Aircraft>>();
	}

	@Override
	public boolean addCompany(Company c) {
		/*
		 * Adds the given company to the register. If the company already exists in the
		 * register, this method does nothing and just returns false. If the company
		 * does not exist, it is registered and the method returns true.
		 */

		if (!(infrastructure.containsKey(c))) {
			infrastructure.put(c, new HashSet<Aircraft>());
			return true;
		}
		return false;
	}

	@Override
	public boolean registerAircraft(Company c, Aircraft a) {
		/*
		 * Registers the given aircraft for the given company. Throws
		 * UnknownCompanyException if the company is not already registered. Throws
		 * DifferentComapanyException if the aircraft is already registered to another
		 * company. Returns false if the aircraft is already registered to the given
		 * company and true otherwise
		 */

		if (!(infrastructure.containsKey(c)))
			throw new UnknownCompanyException(c.getName());

		if (infrastructure.get(c).contains(a))
			return false;

		for (Company co : infrastructure.keySet()) {
			Set<Aircraft> avions = infrastructure.get(co);
			if (avions.contains(a))
				throw new DifferentCompanyException("Aeronau ja registrada");
		}

		Set<Aircraft> result = infrastructure.get(c);
		result.add(a);
		return true;
	}

	@Override
	public Company findCompany(AircraftID id) {
		for (Company co : infrastructure.keySet()) {
			Set<Aircraft> avions = infrastructure.get(co);
			for (Aircraft a : avions) {
				if (a.getId().equals(id)) {
					return co;
				}
			}
		}
		return null;
	}

	class AircraftYearComparator implements Comparator<Aircraft> { // comparator
		// ordenar los aircraft a partir de su aÃ±o
		public int compare(Aircraft a1, Aircraft a2) {
			return a1.getYear() - a2.getYear();
		}
	}

	@Override
	public SortedSet<Aircraft> registeredAircrafts(Company c) {
		TreeSet<Aircraft> set = new TreeSet<>(new AircraftYearComparator());

		if (infrastructure.containsKey(c)) {
			// set.addAll(insta.get(c));-->es lo mismo que abajo
			for (Aircraft a : infrastructure.get(c)) {
				set.add(a);
			}
		}
		return set;// aqui esta vacio a menos que pase por el if
	}

	@Override
	public SortedSet<Company> findCompanyByType(AircraftType t) {
		TreeSet<Company> set = new TreeSet<>();
		for (Company co : infrastructure.keySet()) {
			for (Aircraft a : infrastructure.get(co)) {
				if (a.getType().equals(t)) {
					set.add(co);
				}
			}
		}
		return set;
	}

}
