package com.cnam.setmo.model;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
	
	private String nom;
	private int cpu;
	private int niveau;
	private List<Noeud> voisins = new ArrayList<>();
	
	public Noeud() {}

	public Noeud(String nom, int cpu, int niveau) {
		this.nom = nom;
		this.cpu = cpu ;
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public List<Noeud> getVoisins() {
		return voisins;
	}

	public void setVoisins(List<Noeud> voisins) {
		this.voisins = voisins;
	}

}
