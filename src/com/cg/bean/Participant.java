package com.cg.bean;
/**
 * @version 1
 * Date Sep 26 2019
 * This is a Participant bean class having all elements of Training_Participant_Master
 */
public class Participant {
	private int trainingcode;
	private int participantId;
	/**
	 * Default Constructor
	 */
	public Participant() {
	}
	/**
	 * Non Default Constructor
	 * @param trainingcode  Training code for course
	 * @param participantId Unique ID for Participant Taking part in Training
	 */
	public Participant(int trainingcode, int participantId) {
		this.trainingcode = trainingcode;
		this.participantId = participantId;
	}
	/**
	 * Method to get Training code
	 * @return Trainingcode (Integer)
	 */
	public int getTrainingcode() {
		return trainingcode;
	}
	/**
	 * Set the Training code
	 * @param trainingcode Training Code to set(Integer)
	 */
	public void setTrainingcode(int trainingcode) {
		this.trainingcode = trainingcode;
	}
	/**
	 * Method to get Participant Id
	 * @return participantId (Integer)
	 */
	public int getParticipantId() {
		return participantId;
	}
	/**
	 * Set the Participant Id
	 * @param participantId participant Id to set(Integer)
	 */
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	@Override
	public String toString() {
		return "Participant [trainingcode=" + trainingcode + ", participantId=" + participantId + "]";
	}
	
}
