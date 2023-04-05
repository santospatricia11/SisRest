package com.sisrest.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.sisrest.configuration.batch.SpringBatchExampleJobLauncher;
import com.sisrest.configuration.batch.UploadDeArquivos;

@RestController
@RequestMapping("/api/aluno")
public class AlunoResource {

	private static final String DATA_RECEIVE = "C:/data/receive";
	private String filename;
	
	@Autowired
	private SpringBatchExampleJobLauncher meuJobService;
	
	@Autowired
	private UploadDeArquivos upload;

	@PostMapping(value = "/upload")
	public ResponseEntity<HttpStatus> upload(@RequestParam("arquivo") MultipartFile file)
			throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException {
		boolean resultado = upload.salvarCSV(file);
		if (resultado) {
			meuJobService.execute();
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public Resource getResource() throws IOException {
		ResponseEntity<Resource> resp = new RestTemplate().getForEntity("csv", Resource.class);

		// log.info("File Received : "+resp.getBody().getFilename());

		setFilename(resp.getBody().getFilename());
		java.nio.file.Path path = Paths.get(DATA_RECEIVE);
		if (!Files.exists(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS })) {
			Files.createDirectory(path);
		}
		Files.copy(resp.getBody().getInputStream(), Paths.get(DATA_RECEIVE + "/" + resp.getBody().getFilename()),
				StandardCopyOption.REPLACE_EXISTING);
		return resp.getBody();
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
