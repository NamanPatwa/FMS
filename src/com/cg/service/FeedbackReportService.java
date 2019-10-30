package com.cg.service;

import java.util.List;

import com.cg.bean.FeedbackParameters;
import com.cg.bean.FeedbackReport;
import com.cg.exception.FeedbackNotFoundException;
/**
 * @version 1
 * Date Oct 12 2019
 * This is a FeedbackReport service interface  CRUD operation
 */
public interface FeedbackReportService {
	/**
	 * List of feedback By month
	 * @param month
	 * @return
	 * @throws FeedbackNotFoundException
	 */
	List<FeedbackReport> getByMonth(int month) throws FeedbackNotFoundException;
	/**
	 * Method To get List of feedback for month
	 * @param facultyCode
	 * @param month
	 * @return
	 * @throws FeedbackNotFoundException
	 */
	List<FeedbackReport> getByFacultyForMonth(int facultyCode, int month) throws FeedbackNotFoundException;
	/**
	 * Method to get List of FeedbackReport for defaulters
	 * @param month
	 * @return
	 * @throws FeedbackNotFoundException
	 */
	List<FeedbackReport> getDefaultersByMonth(int month) throws FeedbackNotFoundException;
	/**
	 * Method to get Average feedback by month
	 * @param month
	 * @return
	 */
	FeedbackParameters getAvgByMonth(int month);
	/**
	 * Method to get average feedback by month for a faculty
	 * @param month
	 * @param faculty
	 * @return
	 */
	FeedbackParameters getAvgByMonthAndFaculty(int month, int faculty);
	
}
