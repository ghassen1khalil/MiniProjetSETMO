package com.cnam.setmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cnam.setmo.model.Noeud;

public class Reseau {

	private static final int MAX_NOEUDS = 5;
	private static final int MAX_RAM = 1024;

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		List<Noeud> noeuds = new ArrayList<>();

		while (noeuds.size() < MAX_NOEUDS) {
			Noeud nouveauNoeud;
			String nom = "N" + randomGenerator.nextInt(MAX_NOEUDS);
			if (!noeuds.stream().anyMatch(noeud -> noeud.getNom().equals(nom))) {
				nouveauNoeud = new Noeud(nom, randomGenerator.nextInt(MAX_RAM), randomGenerator.nextInt(MAX_NOEUDS));
				// ajouter des voisins éligible (meme niveau ou niveau actuel +
				// 1)
				//
				noeuds.add(nouveauNoeud);
			}
		}
		
		if (!noeuds.isEmpty()) {
			// générer un nombre alétaoire de voisin qui est inférieur nb
			// max de noeuds
			int nombreDeVoisins = randomGenerator.nextInt(MAX_NOEUDS - 1) + 1;
			for (Noeud noeudSansVoisin : noeuds) {
				for (Noeud nouedCourant : noeuds) {
					if (!noeudSansVoisin.equals(nouedCourant)) {
						if (noeudSansVoisin.getVoisins().size() == nombreDeVoisins) {
							break;
						} else if (nouedCourant.getNiveau() == noeudSansVoisin.getNiveau()
								|| nouedCourant.getNiveau() == noeudSansVoisin.getNiveau() + 1
								|| nouedCourant.getNiveau() == noeudSansVoisin.getNiveau() - 1) {
							noeudSansVoisin.getVoisins().add(nouedCourant);
						}
					}

				}

			}
		}

		for (Noeud noeud : noeuds) {
			System.out.println(
					"Noeud : " + noeud.getNom() + " CPU = " + noeud.getCpu() + " Niveau : " + noeud.getNiveau());
			System.out.println("Voisins = ");
			noeud.getVoisins().stream().forEach(voisin -> System.out.println(voisin.getNom()));

		}

	}

}
