package hr.fer.oop.lab3.implementation;

import hr.fer.oop.lab3.welcomepack.*;

/**
 * Class that simulates a coach,
 * extends Person, implements Manager
 * 
 * @author Luka
 *
 */

public class Coach extends Person implements Manager {
	private int coachingSkill;
	private Formation favoriteFormation;
	private ManageableTeam managingTeam;
	
	/**
	 * Constructor for default values
	 */
	
	public Coach() {
		super(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY, Constants.DEFAULT_EMOTION);
		this.coachingSkill=Constants.DEFAULT_COACHING_SKILL;
		this.favoriteFormation=Constants.DEFAULT_FORMATION;
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param country
	 * @param emotion
	 * @param coachingSkill
	 * @param favoriteFormation
	 */
	
	public Coach(String name, String country, int emotion, int coachingSkill, Formation favoriteFormation) {
		super(name, country, emotion);
		if(coachingSkill>=0 && coachingSkill<=100) {
			this.coachingSkill=coachingSkill;
		} else {
			this.coachingSkill=Constants.DEFAULT_COACHING_SKILL;
			System.err.println("ERROR: coaching skill out of bounds");
		}
		if(favoriteFormation==Formation.F442 || favoriteFormation==Formation.F352 || favoriteFormation==Formation.F541) {
			this.favoriteFormation=favoriteFormation;
		} else {
			this.favoriteFormation=Constants.DEFAULT_FORMATION;
			System.err.println("ERROR: invalid formation");
		}
	}
	
	/**
	 * Getter for coachingSkill
	 * @return coachingSkill
	 */
	
	public int getCoachingSkill() {
		return coachingSkill;
	}
	
	/**
	 * Setter for coachingSkill
	 * @param coachingSkill
	 */
	
	public void setCoachingSkill(int coachingSkill) {
		if(coachingSkill>=0 && coachingSkill<=100) {
			this.coachingSkill=coachingSkill;
		} else {
			this.coachingSkill=Constants.DEFAULT_COACHING_SKILL;
			System.err.println("ERROR: coaching skill out of bounds");
		}
	}
	
	/**
	 * Getter for favoriteFormation
	 * @return favoriteFormation
	 */
	
	public Formation getFavoriteFormation() {
		return favoriteFormation;
	}
	
	/**
	 * Setter for favoriteFormation
	 * @param favoriteFormation
	 */
	
	public void setFavoriteFormation(Formation favoriteFormation) {
		if(favoriteFormation==Formation.F442 || favoriteFormation==Formation.F352 || favoriteFormation==Formation.F541) {
			this.favoriteFormation=favoriteFormation;
		} else {
			this.favoriteFormation=Constants.DEFAULT_FORMATION;
			System.err.println("ERROR: invalid formation");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public void pickStartingEleven() {
        FootballPlayer[] players = managingTeam.getRegisteredPlayers().getPlayers();
        managingTeam.clearStartingEleven();
       
        int DF = favoriteFormation.getNoDF();
        int MF = favoriteFormation.getNoMF();
        int FW = favoriteFormation.getNoFW();
        int GK = 1;
       
        for (int i = 0; i < players.length && players[i]!=null; i++) {
            if (players[i].getPlayingPosition() == PlayingPosition.FW && FW > 0) {
                FW--;
                managingTeam.addPlayerToStartingEleven(players[i]);
            } else if (players[i].getPlayingPosition() == PlayingPosition.MF && MF > 0) {
                MF--;
                managingTeam.addPlayerToStartingEleven(players[i]);
            } else if (players[i].getPlayingPosition() == PlayingPosition.DF && DF > 0) {
                DF--;
                managingTeam.addPlayerToStartingEleven(players[i]);
            } else if (players[i].getPlayingPosition() == PlayingPosition.GK && GK > 0) {
                GK--;
                managingTeam.addPlayerToStartingEleven(players[i]);
            }
        }
       
        if (managingTeam.getStartingEleven().size() < Constants.STARTING_ELEVEN_SIZE) {
            System.err.println("Not enough players were registered.");
            managingTeam.clearStartingEleven();
        }
    }
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public void forceMyFormation() {
		managingTeam.setFormation(favoriteFormation);
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public void setManagingTeam(ManageableTeam team) {
		if(team!=null) {
			managingTeam=team;
		}
	}
	
}