package com.cg.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.FeedbackMasterNotExist;
import com.cg.exception.TrainingProgramNotFoundException;
/**
 * @version 1
 * Date Oct 12 2019
 * This is a Participant service interface  having regex validation with fetch and add operation
 */
public interface ParticipantService {
	static Logger myLogger =  Logger.getLogger(ParticipantService.class);
	String prs_cmmRule = "[1-5]{0,1}";
	String clrfy_doubtRule = "[1-5]{1}";
	String tmRule = "[1-5]{1}";
	String hnd_outRule = "[1-5]{1}";
	String hw_sw_ntwrkRule = "[1-5]{1}";
	String commRule="[a-z]{5,200}";
	String suggRule="[a-z]{5,200}";
	String trcodeRule="[0-9]{2,5}";
	/**
	 * 
	 * @param prs_cmm
	 * @return
	 */
	default boolean validateprs_cmm(String  prs_cmm) {
		boolean x = prs_cmm.matches(prs_cmmRule);
		myLogger.info("feedback for presentation and communication validated");
		return x;
	}
	/**
	 * 
	 * @param clrfy_doubt
	 * @return
	 */
	default boolean validateclrfy_doubt(String clrfy_doubt ) {
		boolean x =clrfy_doubt.matches(clrfy_doubtRule);
		myLogger.info("feedback for Clarifying doubt validated");
		return x;
	}
	/**
	 * 
	 * @param tm
	 * @return
	 */
	default boolean validatetm(String tm ) {
		boolean x= tm.matches(tmRule);
		myLogger.info("feedback for Time Management validated");
		return x;
	}
	/**
	 * 
	 * @param hnd_out
	 * @return
	 */
	default boolean validatehnd_out(String hnd_out ) {
		boolean x= hnd_out.matches(hnd_outRule);
		myLogger.info("feedback for hand Out validated");
		return x;
	}
	/**
	 * 
	 * @param hw_sw_ntwrk
	 * @return
	 */
	 default boolean validatehw_sw_ntwrk(String hw_sw_ntwrk) {
		 boolean x= hw_sw_ntwrk.matches(hw_sw_ntwrkRule);
		 myLogger.info("feedback for hardware software and networking validated");
		return x;
	}
	 /**
	  * 
	  * @param comm
	  * @return
	  */
	default boolean validatecomment(String comm) {
		boolean x= comm.matches(commRule);
		myLogger.info("Comment validated");
		return x;	
	}
	/**
	 * 
	 * @param sugg
	 * @return
	 */
	default boolean validatesuggestion(String sugg) {
		boolean x= sugg.matches(suggRule);
		myLogger.info("Suggestion validated");
		return x;
	}
	/**
	 * 
	 * @param trid
	 * @return
	 */
	default boolean validatetrainingcode(String trid) {
		boolean x= trid.matches(trcodeRule);
		myLogger.info("Training code validated");
		return x;
	}
	/**
	 * 
	 * @param feed
	 * @param par
	 * @return
	 * @throws FeedbackMasterNotExist
	 */
	
	int saveFeedback(Feedback feed,Participant par) throws FeedbackMasterNotExist;
/**
 * 
 * @param participantId
 * @param trainingcode
 * @return
 * @throws TrainingProgramNotFoundException
 */
	List<Participant> getAllTrainingCode(int participantId,int trainingcode) throws TrainingProgramNotFoundException;

	

	

	

	
	
}
