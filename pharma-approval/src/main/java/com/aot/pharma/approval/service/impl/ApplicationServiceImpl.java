package com.aot.pharma.approval.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aot.pharma.approval.application.vo.PharmaSuccessVO;
import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.domain.vo.BearerTokenVO;
import com.aot.pharma.approval.entity.Application;
import com.aot.pharma.approval.repository.ApplicationRepository;
import com.aot.pharma.approval.service.ApplicationService;
import com.aot.pharma.approval.transform.DataTransformUtil;
import com.aot.pharma.approval.util.PharmaUtil;

/**
 * @author dheep
 *
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;

	/* (non-Javadoc)
	 * @see com.aot.pharma.approval.service.ApplicationService#getAllApplications()
	 */
	@Override
	public List<ApplicationVO> getAllApplications() {
		List<Application> applications = applicationRepository.findAll();
		List<ApplicationVO> applicationList = new ArrayList<>();
		if(applications != null && applications.size()>0) {
			applications.forEach(application -> {
				applicationList.add(DataTransformUtil.TransformToView(application));
			});
		}
		return applicationList;
	}

	/* (non-Javadoc)
	 * @see com.aot.pharma.approval.service.ApplicationService#getApplicationByStatus(java.lang.String)
	 */
	@Override
	public List<ApplicationVO> getApplicationByStatus(String applicationStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.aot.pharma.approval.service.ApplicationService#getApplicationById(java.lang.String)
	 */
	@Override
	public ApplicationVO getApplicationById(String applicationId) {
		Application applicationEntity = applicationRepository.findByApplicationId(applicationId);
		return DataTransformUtil.TransformToView(applicationEntity);
	}

	/* (non-Javadoc)
	 * @see com.aot.pharma.approval.service.ApplicationService#createApplication(com.aot.pharma.approval.domain.vo.ApplicationVO)
	 */
	@Override
	public PharmaSuccessVO createApplication(ApplicationVO application,BearerTokenVO userToken) {
		Application applicationEntity = DataTransformUtil.transformToEntity(application);
		String externalId = PharmaUtil.generateExternalId();
		applicationEntity.setCreatedOn(new Date());
		applicationEntity.setApplicationId(PharmaUtil.generateExternalId());
		applicationEntity.setUserId(userToken.getEmail());
		applicationRepository.save(applicationEntity);
		return new PharmaSuccessVO(true, "create success", externalId);
	}

	/* (non-Javadoc)
	 * @see com.aot.pharma.approval.service.ApplicationService#updateApplication(com.aot.pharma.approval.domain.vo.ApplicationVO)
	 */
	@Override
	public PharmaSuccessVO updateApplication(String applicationId,String applicationStatus) {
		Application persistedEntity = applicationRepository.findByApplicationId(applicationId);
		if(applicationStatus!=null && applicationId.length()>0) {
			persistedEntity.setApplicationStatus(applicationStatus);
		}
		applicationRepository.save(persistedEntity);
		PharmaSuccessVO response = new PharmaSuccessVO(true,null,"update success");
		return response;
	}

	@Override
	public List<ApplicationVO> getApplicationByUserId(String userId) {
		List<Application> applications = applicationRepository.findByUserId(userId);
		List<ApplicationVO> applicationList = new ArrayList<>();
		if(applications != null && applications.size()>0) {
			applications.forEach(application -> {
				applicationList.add(DataTransformUtil.TransformToView(application));
			});
		}
		return applicationList;
	}

}
