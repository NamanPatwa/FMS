package com.cg.service;

import java.util.List;

import com.cg.bean.TrainingProgram;
import com.cg.dao.ParticipantDao;
import com.cg.exception.TrainingProgramNotFoundException;

public interface CoordinatorService {
	
	List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException;
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException;
	
	TrainingProgram updateTrainingProgram(TrainingProgram training);
	
	boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	ParticipantDao addParticipant(ParticipantDao participant);
	// check whether available & check role in employee master
	// query : select * from employee_master where employee_id = ? and role = ?
	// for given training code not already enrolled
	// query: select * from training_participant_master where training_code = ? and participant_id = ?
	// for given training check whether available and upcoming date mai hai
	// query : select start_date from training_master where training_code = ?
	// Then, add...
	// query: insert into training_participant_master values (?, ?)
	
	TrainingProgram addTrainingProgram(TrainingProgram training);
	// first getcourse_code match course table if exist
	// get course: select * from course_master where course_id = ?;
	// check for faculty code exist and role is faculty
	// query : select * from faculty_master where faculty_id = ? and role = ?
	// then add : insert into 	training_master values(?, ?, ?, ? ,?)
	// for service ONLY -->> 
	// date validation : date should be valid, end date should be greater than start date
	// current date se jyada dono

}
