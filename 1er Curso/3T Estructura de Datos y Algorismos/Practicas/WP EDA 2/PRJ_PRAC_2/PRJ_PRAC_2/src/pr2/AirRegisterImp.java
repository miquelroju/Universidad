package pr2;

import java.util.*;

public class AirRegisterImp implements AirRegister {
	private Map<Company, Set<Aircraft>> insta;

	public AirRegisterImp() {
		insta = new HashMap<>();
	}

	@Override

	public boolean addCompany(Company c) {
		if (!(insta.containsKey(c))) {
			insta.put(c, new HashSet<Aircraft>());
			return true;
		}
		return false;
	}

	@Override

	public boolean registerAircraft(Company c, Aircraft a) {
		if (!(insta.containsKey(c)))
			throw new UnknownCompanyException(c.getName());

		if (insta.get(c).contains(a))
			return false;

		for (Company co : insta.keySet()) {
			Set<Aircraft> aviones = insta.get(co);
			if (aviones.contains(a)) {
				throw new DifferentCompanyException(co.getName());
			}
		}
		Set<Aircraft> set = insta.get(c);

		set.add(a);

		return true;
	}

	@Override

	public Company findCompany(AircraftID id) {

		for (Company co : insta.keySet()) {
			Set<Aircraft> aviones = insta.get(co);
			for (Aircraft a : aviones) {
				if (a.getId().equals(id)) {
					return co;
				}
			}
		}
		return null;
	}

	class AircraftYearComparator implements Comparator<Aircraft> { // comparator
		// ordenar los aircraft a partir de su año
		public int compare(Aircraft a1, Aircraft a2) {
			return a1.getYear() - a2.getYear();
		}
	}

	@Override
	
	public SortedSet<Aircraft> registeredAircrafts(Company c) {
		TreeSet<Aircraft> set = new TreeSet<>(new AircraftYearComparator());

		if (insta.containsKey(c)) {
			//set.addAll(insta.get(c));-->es lo mismo que abajo
			for (Aircraft a : insta.get(c)) {
				set.add(a);
			}
		}
		return set;// aqui esta vacio a menos que pase por el if

	}

	@Override
	/* Returns all the companies that own an aircraft (or more)
	 of the given type. The resulting set is sorted by natural
	 ordering */
	public SortedSet<Company> findCompanyByType(AircraftType t) {
		TreeSet<Company> set = new TreeSet<>();
		for(Company co:insta.keySet()) {
			for(Aircraft a:insta.get(co)) {
				if(a.getType().equals(t)) {
					set.add(co);
				}
			}
		}
		
		
		return set;
	}

}
