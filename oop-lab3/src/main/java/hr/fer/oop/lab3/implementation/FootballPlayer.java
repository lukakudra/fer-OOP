package hr.fer.oop.lab3.implementation;

import hr.fer.oop.lab3.welcomepack.*;

/**
 * Class that simulates a football player, extends Person.
 * 
 * @author Luka
 *
 */

public class FootballPlayer extends Person {
	private int playingSkill;
	private PlayingPosition playingPosition;
	
	/**
	 * Constructor for default values
	 */
	
	public FootballPlayer() {
		this.playingSkill=Constants.DEFAULT_PLAYING_SKILL;
		this.playingPosition=Constants.DEFAULT_PLAYING_POSITION;
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param country
	 * @param emotion
	 * @param playingSkill
	 * @param playingPosition
	 */
	
	public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition) {
		super(name, country, emotion);
		if(playingSkill>=0 && playingSkill<=100) {
			this.playingSkill=playingSkill;
		} else {
			this.playingSkill=Constants.DEFAULT_PLAYING_SKILL;
			System.err.println("ERROR: playing skill out of bounds");
		}
		if(playingPosition!=null) {
			this.playingPosition=playingPosition;
		} else {
			this.playingPosition=Constants.DEFAULT_PLAYING_POSITION;
			System.err.println("ERROR: invalid playing position");
		}
	}
	
	/**
	 * Getter for playingSkill
	 * @return playingSkill
	 */
	
	public int getPlayingSkill() {
		return playingSkill;
	}
	
	/**
	 * Setter for playingSkill
	 * @param playingSkill
	 */
	
	public void setPlayingSkill(int playingSkill) {
		if(playingSkill>=0 && playingSkill<=100) {
			this.playingSkill=playingSkill;
		} else {
			this.playingSkill=Constants.DEFAULT_PLAYING_SKILL;
			System.err.println("ERROR: playing skill out of bounds");
		}
	}
	
	/**
	 * Getter for playingPosition
	 * @return playingPosition
	 */
	
	public PlayingPosition getPlayingPosition() {
		return playingPosition;
	}
	
	/**
	 * Setter for playingPosition
	 * @param playingPosition
	 */
	
	public void setPlayingPosition(PlayingPosition playingPosition) {
		if(playingPosition!=null) {
			this.playingPosition=playingPosition;
		} else {
			this.playingPosition=Constants.DEFAULT_PLAYING_POSITION;
			System.err.println("ERROR: invalid playing positon");
		}
	}
}
