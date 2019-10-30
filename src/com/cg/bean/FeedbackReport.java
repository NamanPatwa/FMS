package com.cg.bean;

import java.sql.Date;
/**
 * @version 1
 * Date Oct 22 2019
 * This is a Feedback Report bean class having all elements of Feedback Report
 */
public class FeedbackReport {
	private Date startDate;
	private Date endDate;
	private int trainingCode;
	private String facultyName;
	private String participantName;
	private int presentationCommunication;
	private int clarifyDoubts;
	private int timeManagement;
	private int handOuts;
	private int hwswNetwork;
	
	/**
	 * Default Constructor
	 */
	public FeedbackReport() {
	}
	/**
	 * Non Default Constructor
	 * @param startDate Start Date of course
	 * @param endDate End date of course
	 * @param trainingCode unique code for training programme
	 * @param facultyName name of the faculty
	 * @param participantName name of the participan who attended the training
	 * @param presentationCommunication Feedback for presenrtation and communication
	 * @param clarifyDoubts Feedback for doubt clarification
	 * @param timeManagement Feedback for time management
	 * @param handOuts Feedback for hand outs given by trainer
	 * @param hwswNetwork Feeback for hardware software network provided during training programme
	 */
	public FeedbackReport(Date startDate, Date endDate, int trainingCode, String facultyName, String participantName,
			int presentationCommunication, int clarifyDoubts, int timeManagement, int handOuts, int hwswNetwork) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingCode = trainingCode;
		this.facultyName = facultyName;
		this.participantName = participantName;
		this.presentationCommunication = presentationCommunication;
		this.clarifyDoubts = clarifyDoubts;
		this.timeManagement = timeManagement;
		this.handOuts = handOuts;
		this.hwswNetwork = hwswNetwork;
	}
	/**
	 * Method to get the participant name
	 * @return participantName(String)
	 */
	public String getParticipantName() {
		return participantName;
	}
	/**
	 * Set the name of Participant
	 * @param participantName(String)
	 */
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	/**
	 * Method to get the start date of trtaining
	 * @return startDate (Date)
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * Set the start Date of training programme
	 * @param startDate(Date)
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**Method to get the end date 
	 * @return endDate(Date)
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * Set the end date of training programme
	 * @param endDate (Date)
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * Method to get the training code 
	 * @return trainingCode (Integer)
	 */
	public int getTrainingCode() {
		return trainingCode;
	}
	/**
	 * Set the training code 
	 * @param trainingCode(integer)
	 */
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	/**
	 * Method to get the faculty name
	 * @return facultyName(String)
	 */
	public String getFacultyName() {
		return facultyName;
	}
	/**
	 * Set the faculty name
	 * @param facultyName(String)
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	/**
	 * Method to get feedback for Presentaion and communication skill
	 * @return presentationCommunication(Integer)
	 */
	public int getPresentationCommunication() {
		return presentationCommunication;
	}
	/**
	 * set the feedback for Presentaion and communication skill
	 * @param presentationCommunication(integer)
	 */
	public void setPresentationCommunication(int presentationCommunication) {
		this.presentationCommunication = presentationCommunication;
	}
	/**
	 * Method to get the feedback for clarifying doubts
	 * @return clarifyDoubts (Integer)
	 */
	public int getClarifyDoubts() {
		return clarifyDoubts;
	}
	/**
	 * Set the feedback for clarifying doubts
	 * @param clarifyDoubts(Integer)
	 */
	public void setClarifyDoubts(int clarifyDoubts) {
		this.clarifyDoubts = clarifyDoubts;
	}
	/**
	 * Method to get the feedback for time management 
	 * @return timeManagement(Integer)
	 */
	public int getTimeManagement() {
		return timeManagement;
	}
	/**
	 * Set the feedback for time management 
	 * @param timeManagement(Integer)
	 */
	public void setTimeManagement(int timeManagement) {
		this.timeManagement = timeManagement;
	}
	/**
	 * Method to get feedback for handouts given by trainer
	 * @return handouts(Integer)
	 */
	public int getHandOuts() {
		return handOuts;
	}
	/**
	 * set the feedback for handouts given by trainer
	 * @param handOuts(integer)
	 */
	public void setHandOuts(int handOuts) {
		this.handOuts = handOuts;
	}
	/**
	 * Method to get feedback for hardware software network provided during training
	 * @return hwswNetwork(integer)
	 */
	public int getHwswNetwork() {
		return hwswNetwork;
	}
	/**
	 * set the feedback for hardware software network provided during training
	 * @param hwswNetwork(Integer)
	 */
	public void setHwswNetwork(int hwswNetwork) {
		this.hwswNetwork = hwswNetwork;
	}
	
	
	@Override
	public String toString() {
		return startDate +"\t"+ endDate +"\t\t"+  trainingCode +"\t\t"+ facultyName +"\t\t"+ participantName
				+"\t\t\t"+ presentationCommunication +"\t\t"+ clarifyDoubts +"\t\t"+ timeManagement +"\t\t"+ handOuts +"\t\t"+ hwswNetwork;
	}
	
}
