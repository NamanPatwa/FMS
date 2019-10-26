package com.cg.service;

import java.sql.SQLException;
import java.util.List;


import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;

public interface ParticipantService {

	String prs_cmmRule = "[1-5]{1}";
	String clrfy_doubtRule = "[1-5]{1}";
	String tmRule = "[1-5]{1}";
	String hnd_outRule = "[1-5]{1}";
	String hw_sw_ntwrkRule = "[1-5]{1}";
	String commRule="[a-z]{5,200}";
	String suggRule="[a-z]{5,200}";
	String trcodeRule="[0-9]{2,5}";
	default boolean validateprs_cmm(String  prs_cmm) {
		return prs_cmm.matches(prs_cmmRule);
	}
	
	default boolean validateclrfy_doubt(String clrfy_doubt ) {
		return clrfy_doubt.matches(clrfy_doubtRule);
	}
	
	default boolean validatetm(String tm ) {
		return tm.matches(tmRule);
	}
	
	default boolean validatehnd_out(String hnd_out ) {
		return hnd_out.matches(hnd_outRule);
	}
	
	 default boolean validatehw_sw_ntwrk(String hw_sw_ntwrk) {
		return hw_sw_ntwrk.matches(hw_sw_ntwrkRule);
	}
	default boolean validatecomment(String comm) {
		return comm.matches(commRule);	
	}
	default boolean validatesuggestion(String sugg) {
		return sugg.matches(suggRule);
	}
	default boolean validatetrainingcode(String trid) {
		return trid.matches(trcodeRule);
	}
	
	int saveFeedback(Feedback feed,Participant par) throws SQLException;

	List<Participant> getAllTrainingCode(int participantId,int trainingcode) throws TrainingProgramNotFoundException, SQLException;

	

	

	

	
	
}
