package com.cg.dao;

import java.util.List;

import com.cg.bean.Participant;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;
/**
 * FMS - Participant Dao
 * @version 1.0
 * This is DAO interface for Participant
 */
public interface ParticipantDao {
	String addParticipantQuery = "INSERT INTO TRAINING_PARTICIPANT_MASTER VALUES(?,?)";
	String findParticipantByTrainingCodeQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE TRAINING_CODE=?";
	String findParticipantByParticipantIdQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String CheckParticpantExistQuery = "SELECT * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String deleteParticipantByTrainingCodeQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE TRAINING_CODE=?";
	String deleteParticipantByParticipantIdQuery = "DELETE * FROM TRAINING_PARTICIPANT_MASTER WHERE PARTICIPANT_ID =?";
	String findTrainingByParticipant = "select * from Training_participant_master where Participant_id=?";
	String checkIfEnrolledQuery = "select * from training_participant_master where TRAINING_CODE = ? and participant_id = ?";
	/**
	 * 
	 * @param participant
	 * @return
	 * @throws ParticipantNotFoundException
	 */
	int addParticipant(Participant participant) throws ParticipantNotFoundException;
	/**
	 * 
	 * @param trainingCode
	 * @return
	 * @throws ParticipantNotFoundException
	 */
	Participant findParticipantByTrainingCode(int trainingCode) throws ParticipantNotFoundException;
	/**
	 * 
	 * @param participantCode
	 * @return
	 * @throws ParticipantNotFoundException
	 */
	Participant findParticipantByParticipantCode(int participantCode) throws ParticipantNotFoundException;
	/**
	 * 
	 * @param trainingCode
	 * @return
	 */
	boolean deleteParticipantByTrainingCode(int trainingCode);
	/**
	 * 
	 * @param participantCode
	 * @return
	 */
	boolean deleteParticipantByParticipantId(int participantCode);
	/**
	 * 
	 * @param participantCode
	 * @return
	 * @throws TrainingProgramNotFoundException
	 */
	List<Participant> trainingByParticicpant(int participantCode) throws TrainingProgramNotFoundException;
	/**
	 * 
	 * @param trainingCode
	 * @param participantCode
	 * @return
	 * @throws ParticipantNotFoundException
	 */
	boolean checkIfEnrolled(int trainingCode, int participantCode) throws ParticipantNotFoundException;
}
