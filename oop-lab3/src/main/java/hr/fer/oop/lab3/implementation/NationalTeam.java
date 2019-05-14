package hr.fer.oop.lab3.implementation;
import hr.fer.oop.lab3.welcomepack.*;

/**
 * Class that simulates a national team,
 * extends Team
 * 
 * @author Luka
 *
 */

public class NationalTeam extends Team {
	String country;
	
	/**
	 * Getter for country
	 * @return country
	 */
	
	public String getCountry() {
		return country;
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param formation
	 * @param country
	 */
	
	public NationalTeam(String name, Formation formation, String country) {
		super(name, formation);
		if(country!=null) {
			this.country=country;
		} else {
			this.country=Constants.DEFAULT_COUNTRY;
			System.err.println("ERROR: invalid country");
		}
		registeredPlayers=new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
	}
	
	/**
	 * Constructor for default values
	 */
	
	public NationalTeam() {
		super(Constants.DEFAULT_TEAM_NAME, Constants.DEFAULT_FORMATION);
		this.country=Constants.DEFAULT_COUNTRY;
		registeredPlayers=new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public boolean registerPlayer(FootballPlayer player) {
		if(player.getCountry().equals(this.country)) {
			return this.getRegisteredPlayers().add(player);
		} else {
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public double calculateRating() {
		return registeredPlayers.calculateSkillSum()*Constants.THIRTY_PERCENT + registeredPlayers.calculateEmotionSum()*Constants.SEVENTY_PERCENT;
	}
}
