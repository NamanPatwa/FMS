package com.cg.dao;

import java.util.List;

import com.cg.bean.Participant;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;

public interface ParticipantDao {
	String addParticipantQuery = "INSERT INTO TRAINING_PARTICIPANT_MASTER VALUES(?,?)";
	String findParticipantByTrainingCodeQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE TRANING_CODE=?";
	String findParticipantByParticipantIdQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String CheckParticpantExistQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String deleteParticipantByTrainingCodeQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE TRANING_CODE=?";
	String deleteParticipantByParticipantIdQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String findTrainingByParticipant = "select * from Training_participant_master where Participant_id=?";
	
	int addParticipant(Participant participant) throws ParticipantNotFoundException;
	Participant findParticipantByTrainingCode(int trainingCode);
	Participant findParticipantByParticipantCode(int participantCode);
	boolean deleteParticipantByTrainingCode(int trainingCode);
	boolean deleteParticipantByParticipantId(int participantCode);
	List<Participant> trainingByParticicpant(int participantCode) throws TrainingProgramNotFoundException;
}
