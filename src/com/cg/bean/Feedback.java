package com.cg.bean;
/**
 * @version 1
 * Date Sep 26 2019
 * This is a Feedback bean class having all elements of Feedback_Master
 */
public class Feedback {
	
	private int trainingCode;
	private int participantId;
	private int presentationAndCommunication;
	private int doubtClarification;
	private int timeManagement;
	private int handout;
	private int hwSwNwAvailability;
	private String comments;
	private String suggestion;
	
	/**
	 * Default Constructor
	 */
	public Feedback() {
	}
	/**
	 * Non Default Constructor
	 * @param trainingCode unique code for each training
	 * @param participantId unique id for each participant
	 * @param presentationAndCommunication Feedback for presentaion and communication skill(Integer between 1-5)
	 * @param doubtClarification Feedback for doubt clarification skill(Integer between 1-5)
	 * @param timeManagement Feedback for time management skill(Integer between 1-5)
	 * @param handout Feedback for hand out given by trainer(Integer between 1-5)
	 * @param hwSwNwAvailability Feedback for hardware software and network providedduring Training(Integer between 1-5)
	 * @param comments Comments Regarding TrainingProgramme(String below 200 Character)
	 * @param suggestion Suggetion Regarding TrainingProgramme (String below 200 Character)
	 */
	public Feedback(int trainingCode, int participantId, int presentationAndCommunication, int doubtClarification,
			int timeManagement, int handout, int hwSwNwAvailability, String comments, String suggestion) {
		super();
		this.trainingCode = trainingCode;
		this.participantId = participantId;
		this.presentationAndCommunication = presentationAndCommunication;
		this.doubtClarification = doubtClarification;
		this.timeManagement = timeManagement;
		this.handout = handout;
		this.hwSwNwAvailability = hwSwNwAvailability;
		this.comments = comments;
		this.suggestion = suggestion;
	}
	/**
	 * method to get TrainingCode
	 * @return trainingCode (Integer)
	 */
	public int getTrainingCode() {
		return trainingCode;
	}
	/**
	 * Sets the tarining code of participant
	 * @param trainingCode
	 */
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	/**
	 * Method to get participant Id
	 * @return participantId(Integer)
	 */
	public int getParticipantId() {
		return participantId;
	}
	/**
	 * Sets the Participant Id of Participant
	 * @param participantId
	 */
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	/**
	 * Method to get feedback for Presentation and communication skills
	 * @return presentationAndCommunication (Integer between 1-5)
	 */
	public int getPresentationAndCommunication() {
		return presentationAndCommunication;
	}
	/**
	 * Set the feedback for Presentation and communication skills
	 * @param presentationAndCommunication (Integer between 1-5)
	 */
	public void setPresentationAndCommunication(int presentationAndCommunication) {
		this.presentationAndCommunication = presentationAndCommunication;
	}
	/**
	 * Method to get feedback for doubtClarification
	 * @return doubtClarification(Integer between 1-5)
	 */
	public int getDoubtClarification() {
		return doubtClarification;
	}
	/**
	 * Set the feedback for Doubt clarification
	 * @param doubtClarification (Integer between 1-5)
	 */
	public void setDoubtClarification(int doubtClarification) {
		this.doubtClarification = doubtClarification;
	}
	/**
	 * method to get feedback for time management
	 * @return timeManagement(Integer between 1-5)
	 */
	public int getTimeManagement() {
		return timeManagement;
	}
	/**
	 * set the feedback for Time Management
	 * @param timeManagement(Integer between 1-5)
	 */
	public void setTimeManagement(int timeManagement) {
		this.timeManagement = timeManagement;
	}
	/**
	 * Method to get feedback for hand out given by faculty
	 * @return handout (Integer between 1-5)
	 */
	public int getHandout() {
		return handout;
	}
	/**
	 * set the feedback for handout given by faculty
	 * @param handout (Integer between 1-5)
	 */
	public void setHandout(int handout) {
		this.handout = handout;
	}
	/**
	 * Method to get feedback for hardware software network provided during training programme
	 * @return hwSwNwAvailability (Integer between 1-5)
	 */
	public int getHwSwNwAvailability() {
		return hwSwNwAvailability;
	}
	/**
	 * set the feedback for hardware software network provided during training programme
	 * @param hwSwNwAvailability (Integer between 1-5)
	 */
	public void setHwSwNwAvailability(int hwSwNwAvailability) {
		this.hwSwNwAvailability = hwSwNwAvailability;
	}
	/**
	 * Method to get comments given by participant 
	 * @return (String below 200 characters)
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * set the comments given by prticipant
	 * @param comments (String below 200 characters)
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * Method to get suggestion given by participant
	 * @return suggestion (String below 200 characters)
	 */
	public String getSuggestion() {
		return suggestion;
	}
	/**
	 * Set the uggestion given by participant
	 * @param suggestion (String below 200 characters)
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	@Override
	public String toString() {
		return "Feedback [trainingCode=" + trainingCode + ", participantId=" + participantId
				+ ", presentationAndCommunication=" + presentationAndCommunication + ", doubtClarification="
				+ doubtClarification + ", timeManagement=" + timeManagement + ", handout=" + handout
				+ ", hwSwNwAvailability=" + hwSwNwAvailability + ", comments=" + comments + ", suggestion=" + suggestion
				+ "]";
	}	
}
