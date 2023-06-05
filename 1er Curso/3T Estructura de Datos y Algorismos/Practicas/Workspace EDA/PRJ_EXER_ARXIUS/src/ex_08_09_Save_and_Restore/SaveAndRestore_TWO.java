package ex_08_09_Save_and_Restore;

import java.util.*;
import java.io.*;

public class SaveAndRestore_TWO {
	
	public static void saveTWO(Collection<Producte> col, File file) throws IOException {
		// desa el contingut de la col·lecció donada en el primer paràmetre
		// a l'arxiu especificat pel segon paràmetre

		DataOutputStream dos = new DataOutputStream(
				  new BufferedOutputStream (new FileOutputStream (file)));

		for (Producte prod : col) {
			dos.writeUTF(prod.getNom());
			dos.writeDouble(prod.getPreu());
			dos.writeInt(prod.getParts().size());
			for (Part pa : prod.getParts()) {
				dos.writeUTF(pa.getId());
				dos.writeUTF(pa.getDesc());
			}
		}
		dos.writeUTF("END OF COLLECTION");
		dos.close();
	}

	public static Collection<Producte> restoreTWO(File file) throws IOException {
		// recupera de l'arxiu especificat el contingut d'una col·lecció que
		// va ser desada amb el mètode save
		Collection<Producte> resultat = new ArrayList();
		Set<Part> parts;

		/* COMPLETAR */

		return resultat;
	}

}
