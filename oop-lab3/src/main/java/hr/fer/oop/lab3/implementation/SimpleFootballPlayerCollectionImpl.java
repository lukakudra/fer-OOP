package hr.fer.oop.lab3.implementation;

import hr.fer.oop.lab3.welcomepack.*;

/**
 * Class that simulates a collection of football players,
 * implements SimpleFootballPlayerCollection.
 * 
 * @author Luka
 *
 */

public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {
	private FootballPlayer[] players;
	private final int maxSize;
	private int size;
	
	/**
	 * {@inheritDoc}
	 */
	
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * Constructor
	 * @param maxSize
	 */
	
	public SimpleFootballPlayerCollectionImpl(int maxSize) {
		this.maxSize=maxSize;
		size=0;
		players=new FootballPlayer[maxSize];
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public FootballPlayer[] getPlayers() {
		return players;
	}
	
	/**
	 * {@inheritDoc}
	 */

	public boolean add(FootballPlayer player) {
		if(size<maxSize && !this.contains(player)) {
			players[size]=player;
			size++;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public void clear() {
		for (int i=0; i<size; i++) {
			players[i]=null;
		}
		size=0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public boolean contains(FootballPlayer player) {
		for (int i=0; i<size; i++) {
			if(players[i].equals(player)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * {@inheritDoc}
	 */

	
	public int calculateEmotionSum() {
		int emotionSum=0;
		for(int i=0; i<size; i++) {
			emotionSum+=players[i].getEmotion();
		}
		return emotionSum;
	}
	
	/**
	 * {@inheritDoc}
	 */
	
	public int calculateSkillSum() {
		int skillSum=0;
		for(int i=0; i<size; i++) {
			skillSum+=players[i].getPlayingSkill();
		}
		return skillSum;
	}
}

