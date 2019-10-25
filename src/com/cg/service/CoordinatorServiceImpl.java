package com.cg.service;

import java.util.List;

import com.cg.bean.TrainingProgram;
import com.cg.dao.ParticipantDao;
import com.cg.dao.TrainingProgramDao;
import com.cg.dao.TrainingProgramDaoImpl;
import com.cg.exception.TrainingProgramNotFoundException;

public class CoordinatorServiceImpl implements CoordinatorService {
	
	private TrainingProgramDao trainingProgramDao;
	
	public CoordinatorServiceImpl() {
		trainingProgramDao = new TrainingProgramDaoImpl();
	}
	
	@Override
	public List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException {
		return trainingProgramDao.fetchAllTrainingProgram();
	}

	@Override
	public TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException {
		return trainingProgramDao.fetchTrainingProgramByTrainingCode(code);
	}

	// Galat hai dao
	@Override
	public TrainingProgram updateTrainingProgram(TrainingProgram training) {
		return null;
	}

	@Override
	public boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException {
		return trainingProgramDao.removeTrainingProgram(code);
	}

	@Override
	public ParticipantDao addParticipant(ParticipantDao participant) {
		return null;
	}

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram training) {
		return null;
	}

}
