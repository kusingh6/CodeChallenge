/**
 * 
 */
package com.aot.pharma.approval.transform;

import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.entity.Application;

/**
 * @author dheep
 *
 */
public class DataTransformUtil {
	
	public static Application transformToEntity(ApplicationVO bean) {
		Application applicationEntity = new Application();
		applicationEntity.setApplicantName(bean.getApplicantName());
		applicationEntity.setPharmacistRegNo(bean.getPharmacistRegNo());
		return applicationEntity;
	}
	
	public static ApplicationVO TransformToView(Application application) {
		ApplicationVO applicationVO = new ApplicationVO();
		applicationVO.setApplicantName(application.getApplicantName());
		applicationVO.setApplicationId(application.getApplicationId());
		applicationVO.setApplicationStatus(application.getApplicationStatus());
		applicationVO.setPharmacistRegNo(application.getPharmacistRegNo());
		return applicationVO;
	}

}
