package hr.fer.oop.lab3.implementation;

import hr.fer.oop.lab3.welcomepack.*;

/**
 * Abstract class that simulates a team of any kind,
 * must be inherited.
 * 
 * @author Luka
 *
 */

public abstract class Team implements ManageableTeam {
	private String name;
	private Formation formation;
	private SimpleFootballPlayerCollection startingEleven;
	protected SimpleFootballPlayerCollection registeredPlayers;
	
	/**
	 * Constructor
	 * @param name
	 * @param formation
	 */
	
	public Team(String name, Formation formation) {
		if(name!=null && !name.equals("")) {
			this.name=name;
		} else {
			this.name=Constants.DEFAULT_TEAM_NAME;
			System.err.println("ERROR: invalid team name");
		}
		if(formation!=null) {
			this.formation=formation;
		} else {
			this.formation=Constants.DEFAULT_FORMATION;
			System.err.println("ERROR: invalid formation");
		}
		startingEleven=new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
	}
	
	/**
	 * Getter for name
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public Formation getFormation() {
		return formation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public void setFormation(Formation formation) {
		if(formation!=null) {
			this.formation=formation;
		} else {
			this.formation=Constants.DEFAULT_FORMATION;
			System.err.println("ERROR: invalid formation");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public void clearStartingEleven() {
		startingEleven.clear();
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public SimpleFootballPlayerCollection getStartingEleven() {
		return startingEleven;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public SimpleFootballPlayerCollection getRegisteredPlayers() {
		return registeredPlayers;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public boolean addPlayerToStartingEleven(FootballPlayer player) {
		if(registeredPlayers.contains(player)) {
			return startingEleven.add(player);
		} else {
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public boolean isPlayerRegistered(FootballPlayer player) {
		if(registeredPlayers.contains(player)) {
			return true;
		} else {
			return false;
		}
	}
}
