package hr.fer.oop.lab4.prob2;

import hr.fer.oop.lab4.prob1.*;

public class Demonstration {

	public static void main(String[] args) throws NotEligiblePlayerException {
		System.out.println("Stvaranje novog tima...");
		ClubTeam varteks = null;
		try {
			varteks = new ClubTeam("VARTEKS", Formation.F352, 101);
		} catch (IllegalArgumentException e) {
			System.out.println("Greška: " + e.toString() + "\nOporavak od pogreške..");
			varteks = new ClubTeam("VARTEKS", Formation.F352, 75);
			
		}
		FootballPlayer Ivo = new  FootballPlayer("Ivo","CRO",100,100,PlayingPosition.GK);
		varteks.registerPlayer(Ivo);
		varteks.addPlayerToStartingEleven(Ivo);
		varteks.removePlayerFromStartingEleven(Ivo);
		System.out.println("Naziv:" + varteks.getName() + ", reputacija:" + varteks.getReputation() + ", formacija:"
				+ varteks.getFormation());
	}

}