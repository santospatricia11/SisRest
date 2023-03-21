package com.sisrest.configuration.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SpringBatchExampleJobLauncher {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBatchExampleJobLauncher.class);

	private final Job job;
	private final JobLauncher jobLauncher;

	@Autowired
	public SpringBatchExampleJobLauncher(Job job, JobLauncher jobLauncher) {
		this.job = job;
		this.jobLauncher = jobLauncher;
	}

	//@Scheduled(cron = "0/10 * * * * *")
	public void execute() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException {
		// LOGGER.info("Spring Batch exemplo job start");

		jobLauncher.run(job, newExecution());

		LOGGER.info("Spring Batch ");
	}

	private JobParameters newExecution() {
		Map<String, JobParameter> parameters = new HashMap<>();

		JobParameter parameter = new JobParameter(new Date());
		parameters.put("currentTime", parameter);

		return new JobParameters(parameters);
	}

}
