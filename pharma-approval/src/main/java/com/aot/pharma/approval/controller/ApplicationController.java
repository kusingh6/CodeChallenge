/**
 * 
 */
package com.aot.pharma.approval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aot.pharma.approval.adapter.KeyClockAdapter;
import com.aot.pharma.approval.application.vo.PharmaSuccessVO;
import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.domain.vo.BearerTokenVO;
import com.aot.pharma.approval.domain.vo.UserVO;
import com.aot.pharma.approval.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Rest Controller for Application
 * 
 * @author Dheepak Ramaswamy
 *
 */
@RestController
public class ApplicationController {

	@Value("${keycloak.url}")
	private String keyclockURL;

	@Value("${bpm.url}")
	private String bpmURL;

	@Autowired
	private ApplicationService applicationService;

	/**
	 * 
	 * @return ResponseEntity
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "application", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ApplicationVO>> getApplication(
			@RequestHeader(name = "Authorization", required = true) String bearerToken) {
		BearerTokenVO token = KeyClockAdapter.authenticateToken(bearerToken, keyclockURL);
		List<ApplicationVO> applications = applicationService.getAllApplications(token.getEmail());
		ResponseEntity<List<ApplicationVO>> response = new ResponseEntity<>(applications, HttpStatus.OK);
		return response;
	}

	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "application/{applicationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApplicationVO> getApplication(@PathVariable("applicationId") String applicationId,
			@RequestHeader(name = "Authorization", required = true) String bearerToken) {
		KeyClockAdapter.authenticateToken(bearerToken, keyclockURL);
		ApplicationVO application = applicationService.getApplicationById(applicationId);
		return new ResponseEntity<>(application, HttpStatus.OK);
	}

	/**
	 * 
	 * @param application
	 * @return ResponseEntity
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "application", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PharmaSuccessVO> createApplication(@RequestBody ApplicationVO application,
			@RequestHeader(name = "Authorization", required = true) String bearerToken) {
		BearerTokenVO userToken = KeyClockAdapter.authenticateToken(bearerToken, keyclockURL);
		PharmaSuccessVO response = applicationService.createApplication(application, userToken);
		application.setApplicationId(response.getReferenceId());
		applicationService.invokeBPM(application, bpmURL);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 
	 * @param application
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "application/{applicationId}/applicationStatus/{applicationStatus}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PharmaSuccessVO> updateApplication(@PathVariable("applicationId") String applicationId,
			@PathVariable("applicationStatus") String applicationStatus,
			@RequestHeader(name = "Authorization", required = true) String bearerToken) {
		KeyClockAdapter.authenticateToken(bearerToken, keyclockURL);
		PharmaSuccessVO response = applicationService.updateApplication(applicationId, applicationStatus);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> getUser() {
		UserVO user = new UserVO();
		user.setUserName("The Pharmacist");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
