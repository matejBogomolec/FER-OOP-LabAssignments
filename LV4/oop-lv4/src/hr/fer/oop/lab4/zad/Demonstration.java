package hr.fer.oop.lab4.zad;


import java.util.ArrayList;
import java.util.Collection;

import hr.fer.oop.lab4.prob1.Coach;
import hr.fer.oop.lab4.prob1.FootballPlayer;
import hr.fer.oop.lab4.prob1.Formation;
import hr.fer.oop.lab4.prob1.PlayingPosition;
import hr.fer.oop.lab4.prob2.ClubTeam;
import hr.fer.oop.lab4.prob2.Team;
import hr.fer.oop.lab4.prob3.UnemployedCoachException;

public class Demonstration 
{
	public static void printPlayerSkills(Collection<FootballPlayer> players)
	{
		String output = "";
		for (FootballPlayer player : players) {
			output += player.getPlayingSkill() + "\n";
		}
		System.out.println(output);
	}
	public static void main(String[] args) throws UnemployedCoachException
	{
		Coach ivan = new Coach("Ivan","CRO",100,80,Formation.F442);
		ClubTeam zagreb= new ClubTeam("Zagreb",Formation.F442,0);
		ivan.setManagingTeam(zagreb);
		Collection<FootballPlayer> players = new ArrayList<FootballPlayer>();
		FootballPlayer ivica = new FootballPlayer("Ivica","CRO",100,81,PlayingPosition.GK);
		FootballPlayer ante = new FootballPlayer("Ante","CRO",100,79,PlayingPosition.MF);
		players.add(ivica);
		players.add(ante);
		ivan.registerPlayers(players, (FootballPlayer player) -> player.getPlayingSkill() > zagreb.getReputation());
		System.out.println("Vjestine registriranih igraca");
		printPlayerSkills(zagreb.getRegisteredPlayers());
		ivan.pickStartingEleven((FootballPlayer player) -> player.getPlayingSkill() > ivan.getCoachingSkill());
		ivan.performTrainingSession();
		System.out.println("Vjestine registriranih igraca");
		printPlayerSkills(zagreb.getRegisteredPlayers());
		ivan.sortRegisteredPlayers();
		System.out.println("Vjestine registriranih igraca");
		printPlayerSkills(zagreb.getRegisteredPlayers());
		
	}
}
