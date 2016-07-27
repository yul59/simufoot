/**
 * 
 */
package com.uma.project.services.calendrier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author HP
 *
 */
@Component
public class CalendrierService {

	public Map<Integer, List<String>> mapCalend = new HashMap<Integer, List<String>>();

	public String getCalendrier() {

		final String[] tabEq = { "OM", "PSG", "OL", "LOSC", "ASSE", "ASM",
				"BOR", "CAEN", "SCO", "OGCN", "FCNA", "EAG", "TFC", "MONTP",
				"BASTIA", "GAZ", "LOR", "REN", "TR3", "REIM" };

		ArrayList<String> listEq = new ArrayList<String>(Arrays.asList(tabEq));

		// nb de journee aller
		final int nbRound = listEq.size() - 1;
		// nb de journee total
		final int nbJourn = nbRound * 2;

		// init du calendrier
		for (int j = 0; j < nbJourn; j++) {
			mapCalend.put(j + 1, new ArrayList<String>());
		}

		// generer une journee (aller + retour)
		for (int i = 0; i < nbRound; i++) {
			genererRound(i + 1, listEq);
			listEq = nextRound(listEq);
		}

		// afficher le calendrier final
		// for (final Map.Entry<Integer, List<String>> entry :
		// mapCalend.entrySet()) {
		// System.out.println("J " + entry.getKey() + " : " +
		// entry.getValue().toString());
		// }
		StringBuffer calendrier = new StringBuffer();
		for (int k = 0; k < nbJourn; k++) {
			calendrier.append("J " + ((k < 9) ? "0" : "") + (k + 1) + " : "
					+ mapCalend.get(k + 1).toString() + "<br/>");
			// System.out.println("J " + ((k < 9) ? "0" : "") + (k + 1) + " : "
			// + mapCalend.get(k + 1).toString());
		}

		return calendrier.toString();
	}

	private void genererRound(int round, List<String> listEq) {

		// liste des match de la journee aller
		final List<String> opposAller = mapCalend.get(round);
		// liste des match de la journee retour
		List<String> opposRetour;

		// cas de la derniere journee retour qui correspond a la premeire
		// journee aller
		if (round == 1) {
			opposRetour = mapCalend.get((listEq.size() - 1) * 2);
		} else {
			opposRetour = mapCalend.get((listEq.size() - 2) + round);
		}

		// nb de match dans la journee
		final int nbOppos = listEq.size() / 2;

		// gestion domicile / exterieur
		boolean inverse;

		for (int i = 0; i < nbOppos; i++) {

			inverse = false;
			if (i == 0) {
				if (round % 2 == 0) {
					inverse = true;
				}
			} else {
				if (i % 2 > 0) {
					inverse = true;
				}
			}

			// match obtenu
			String tmpAller = listEq.get(i) + "-" + listEq.get(i + nbOppos);
			String tmpRetour = listEq.get(i + nbOppos) + "-" + listEq.get(i);
			if (inverse) {
				tmpAller = listEq.get(i + nbOppos) + "-" + listEq.get(i);
				tmpRetour = listEq.get(i) + "-" + listEq.get(i + nbOppos);
			}

			// ajouter le match a la journee
			opposAller.add(tmpAller);
			opposRetour.add(tmpRetour);
		}

	}

	private ArrayList<String> nextRound(ArrayList<String> listEq) {

		// permuter les equipe dans la liste pour generer la journee suivante
		final ArrayList<String> retour = listEq;

		final int indiceSup = (retour.size() / 2);

		String eqSup = retour.remove(indiceSup);
		retour.add(1, eqSup);

		eqSup = retour.remove(indiceSup);
		retour.add(eqSup);

		return retour;
	}

}
