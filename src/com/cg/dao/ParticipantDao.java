package com.cg.dao;

import com.cg.bean.Participant;
import com.cg.exception.ParticipantNotFoundException;

public interface ParticipantDao {
	String addParticipantQuery = "INSERT INTO TRAINING_PARTICIPANT_MASTER VALUES(?,?)";
	String findParticipantByTrainingCodeQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE TRANING_CODE=?";
	String findParticipantByParticipantIdQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String CheckParticpantExistQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String deleteParticipantByTrainingCodeQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE TRANING_CODE=?";
	String deleteParticipantByParticipantIdQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";

	int addParticipant(Participant participant) throws ParticipantNotFoundException;
	Participant findParticipantByTrainingCode(int trainingCode);
	Participant findParticipantByParticipantCode(int participantCode);
	boolean deleteParticipantByTrainingCode(int trainingCode);
	boolean deleteParticipantByParticipantId(int participantCode);

}
