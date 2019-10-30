package com.cg.bean;
/**
 * @version 1
 * Date Oct 22 2019
 * This is a Feedback parameters bean class having elements for feedback report
 */
public class FeedbackParameters {
	private double presentationCommunication;
	private double clarifyDoubts;
	private double timeManagement;
	private double handOuts;
	private double hwswNetwork;
	/**
	 * Default Constructor
	 */
	public FeedbackParameters() {
	}
	/**
	 * Non Default Constructor
	 * @param presentationCommunication Feedback for presenrtation and communication
	 * @param clarifyDoubts Feedback for doubt clarification
	 * @param timeManagement Feedback for time management
	 * @param handOuts Feedback for hand outs given by trainer
	 * @param hwswNetwork Feeback for hardware software network provided during training programme
	 */
	public FeedbackParameters(double presentationCommunication, double clarifyDoubts, double timeManagement,
			double handOuts, double hwswNetwork) {
		super();
		this.presentationCommunication = presentationCommunication;
		this.clarifyDoubts = clarifyDoubts;
		this.timeManagement = timeManagement;
		this.handOuts = handOuts;
		this.hwswNetwork = hwswNetwork;
	}
	/**
	 * Method to get feedback for Presentaion and communication skill
	 * @return presentationCommunication(Double)
	 */
	public double getPresentationCommunication() {
		return presentationCommunication;
	}
	/**
	 * set the feedback for Presentaion and communication skill
	 * @param presentationCommunication(Double)
	 */
	public void setPresentationCommunication(double presentationCommunication) {
		this.presentationCommunication = presentationCommunication;
	}
	/**
	 * Method to get the feedback for clarifying doubts
	 * @return clarifyDoubts (Double)
	 */
	public double getClarifyDoubts() {
		return clarifyDoubts;
	}
	/**
	 * Set the feedback for clarifying doubts
	 * @param clarifyDoubts(Double)
	 */
	public void setClarifyDoubts(double clarifyDoubts) {
		this.clarifyDoubts = clarifyDoubts;
	}
	/**
	 * Method to get the feedback for time management 
	 * @return timeManagement(Double)
	 */
	public double getTimeManagement() {
		return timeManagement;
	}
	/**
	 * Set the feedback for time management 
	 * @param timeManagement(Double)
	 */
	public void setTimeManagement(double timeManagement) {
		this.timeManagement = timeManagement;
	}
	/**
	 * Method to get feedback for handouts given by trainer
	 * @return handouts(Double)
	 */
	public double getHandOuts() {
		return handOuts;
	}
	/**
	 * set the feedback for handouts given by trainer
	 * @param handOuts(double)
	 */
	public void setHandOuts(double handOuts) {
		this.handOuts = handOuts;
	}
	/**
	 * Method to get feedback for hardware software network provided during training
	 * @return hwswNetwork(Double)
	 */
	public double getHwswNetwork() {
		return hwswNetwork;
	}
	/**
	 * set the feedback for hardware software network provided during training
	 * @param hwswNetwork(Double)
	 */
	public void setHwswNetwork(double hwswNetwork) {
		this.hwswNetwork = hwswNetwork;
	}

	@Override
	public String toString() {
		return "Average Scores: Presentation & Communication=" + presentationCommunication + ", Clarification of Doubts="
				+ clarifyDoubts + ", Time Management=" + timeManagement + ", Handouts=" + handOuts + ", H/W S/W Network="
				+ hwswNetwork ;
	}
	
	
	
}
