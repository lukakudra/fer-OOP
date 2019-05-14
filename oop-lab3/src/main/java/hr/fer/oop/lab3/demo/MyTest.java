package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.implementation.*;
import hr.fer.oop.lab3.welcomepack.*;

public class MyTest {
	public static void main(String[] args) {
		SimpleFootballPlayerCollectionImpl collection=new SimpleFootballPlayerCollectionImpl(40);
		FootballPlayer player;
		FootballPlayer [] players;
		NationalTeam team=new NationalTeam("MyTeam", Formation.F442, "Croatia");
		
		//1
		player=new FootballPlayer("John", "Croatia", 80, 90, PlayingPosition.GK);
		collection.add(player);
		team.registerPlayer(player);
		
		//2
		player=new FootballPlayer("Chad", "Croatia", 78, 45, PlayingPosition.DF);
		collection.add(player);
		team.registerPlayer(player);
		
		//3
		player=new FootballPlayer("Michael", "Croatia", 51, 87, PlayingPosition.DF);
		collection.add(player);
		team.registerPlayer(player);
		
		//4
		player=new FootballPlayer("Anthony", "Croatia", 77, 35, PlayingPosition.DF);
		collection.add(player);
		team.registerPlayer(player);
		
		//5
		player=new FootballPlayer("Joe", "Croatia", 74, 91, PlayingPosition.DF);
		collection.add(player);
		team.registerPlayer(player);
		
		//6
		player=new FootballPlayer("Mick", "Croatia", 71, 45, PlayingPosition.DF);
		collection.add(player);
		team.registerPlayer(player);
		
		//7
		player=new FootballPlayer("Paul", "Croatia", 54, 60, PlayingPosition.MF);
		collection.add(player);
		team.registerPlayer(player);
		
		//8
		player=new FootballPlayer("Lewis", "Croatia", 32, 84, PlayingPosition.MF);
		collection.add(player);
		team.registerPlayer(player);
		
		//9
		player=new FootballPlayer("Joseph", "Croatia", 42, 65, PlayingPosition.MF);
		collection.add(player);
		team.registerPlayer(player);
		
		//10
		player=new FootballPlayer("Joey", "Croatia", 66, 87, PlayingPosition.MF);
		collection.add(player);
		team.registerPlayer(player);
		
		//11
		player=new FootballPlayer("Ted", "Croatia", 29, 98, PlayingPosition.MF);
		collection.add(player);
		team.registerPlayer(player);
		
		//12
		player=new FootballPlayer("Barney", "Croatia", 68, 21, PlayingPosition.FW);
		collection.add(player);
		team.registerPlayer(player);
		
		//13
		player=new FootballPlayer("Marshall", "Croatia", 14, 69, PlayingPosition.FW);
		collection.add(player);
		team.registerPlayer(player);
		
		//14
		player=new FootballPlayer("Charlie", "Croatia", 58, 26, PlayingPosition.FW);
		collection.add(player);
		team.registerPlayer(player);
		
		//15
		player=new FootballPlayer("Jake", "Croatia", 78, 25, PlayingPosition.FW);
		collection.add(player);
		team.registerPlayer(player);
		
		System.out.printf("Sum of emotions: %d%n", collection.calculateEmotionSum());
		System.out.printf("Sum of skill: %d%n", collection.calculateSkillSum());
		
		Coach myCoach=new Coach("Alex", "Croatia", 75, 88, Formation.F442);
		
		myCoach.setManagingTeam(team);
		myCoach.pickStartingEleven();
		collection=(SimpleFootballPlayerCollectionImpl)team.getStartingEleven();
		players=collection.getPlayers();
		System.out.print("Coach has a formation: ");
		Formation.FormationPrint(myCoach.getFavoriteFormation());
		
		for(int i=0; i<11 && players[i]!=null; i++) {
			System.out.println(1+i + "." + players[i].getName()+" "+players[i].getPlayingPosition().toString());
		}
		
		System.out.printf("%n%n");
		
		Coach coach2=new Coach("Pep", "Spain", 78, 88, Formation.F352);
		Formation teamFormation=team.getFormation();
		Formation coachFormation=coach2.getFavoriteFormation();
		
		System.out.printf("Before forceMyFormation:%n");
		System.out.print("Coach--> ");
		Formation.FormationPrint(coach2.getFavoriteFormation());
		System.out.print("Team--> ");
		Formation.FormationPrint(team.getFormation());
		
		if(!teamFormation.equals(coachFormation)) {
			System.out.println("Formations before forceMyFormation are not equal.");
		}
		
		System.out.println();
		coach2.setManagingTeam(team);
		coach2.forceMyFormation();
		Formation teamFormation2=team.getFormation();
		
		System.out.printf("After forceMyFormation:%n");
		System.out.print("Coach--> ");
		Formation.FormationPrint(coach2.getFavoriteFormation());
		System.out.print("Team--> ");
		Formation.FormationPrint(team.getFormation());
		
		if(teamFormation2.equals(coachFormation)) {
			System.out.println("Force formation works.");
		}
	}	
}
	
	