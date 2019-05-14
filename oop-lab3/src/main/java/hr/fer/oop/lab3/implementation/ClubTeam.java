package hr.fer.oop.lab3.implementation;
import hr.fer.oop.lab3.welcomepack.*;

/**
 * Class that simulates a club team,
 * extends Team
 * 
 * @author Luka
 *
 */

public class ClubTeam extends Team {
	int reputation;
	
	/**
	 * Constructor
	 * @param name
	 * @param formation
	 * @param reputation
	 */
	
	public ClubTeam(String name, Formation formation, int reputation) {
		super(name, formation);
		if(reputation>=0 && reputation<=100) {
			this.reputation=reputation;
		} else {
			this.reputation=Constants.DEFAULT_REPUTATION;
			System.err.println("ERROR: reputation out of bounds");
		}
		registeredPlayers=new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
	}
	
	/**
	 * Constructor for default values
	 */
	
	public ClubTeam() {
		super(Constants.DEFAULT_TEAM_NAME, Constants.DEFAULT_FORMATION);
		this.reputation=Constants.DEFAULT_REPUTATION;
		registeredPlayers=new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
	}
	
	/**
	 * Getter for reputation
	 * @return reputation
	 */
	
	public int getReputation() {
		return reputation;
	}
	
	/**
	 * Setter for reputation
	 * @param reputation
	 */
	
	public void setReputation(int reputation) {
		if(reputation>=0 && reputation<=100) {
			this.reputation=reputation;
		} else {
			this.reputation=Constants.DEFAULT_REPUTATION;
			System.err.println("ERROR: reputation out of bounds");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public boolean registerPlayer(FootballPlayer player) {
		if(this.reputation<=player.getPlayingSkill()) {
			return this.getRegisteredPlayers().add(player);
		} else {
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public double calculateRating() {
		return registeredPlayers.calculateSkillSum()*Constants.SEVENTY_PERCENT + registeredPlayers.calculateEmotionSum()*Constants.THIRTY_PERCENT;
	}
}
