/**
 * 
 */
package com.aot.pharma.approval.adapter;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.domain.vo.CamundaPropertyVO;
import com.aot.pharma.approval.domain.vo.CamundaVO;
import com.aot.pharma.approval.domain.vo.CamundaVariableVO;

/**
 * @author dheep
 *
 */
public class CamundaBPMAdapter {
	
	public static void invokeBPM(ApplicationVO application,String bpmURL) {
		
		URI uri;
		try {
			uri = new URI(bpmURL);
			RestTemplate restTemplate = new RestTemplate();
			CamundaVO requestVO = new CamundaVO();
			CamundaVariableVO variable  = new CamundaVariableVO();
			variable.setApplicationId(new CamundaPropertyVO(application.getApplicationId(), "String"));
			if(application.getPharmacistRegNo()!=null) {
				variable.setRegistrationNumber(new CamundaPropertyVO(application.getPharmacistRegNo().toString(), "String"));
			}
			else {
				variable.setRegistrationNumber(new CamundaPropertyVO(null, "String"));
			}
			variable.setApplicantName(new CamundaPropertyVO(application.getApplicantName(), "String"));
			requestVO.setVariables(variable);
			requestVO.setBusinessKey(application.getApplicationId());
			HttpEntity<CamundaVO> request = new HttpEntity<>(requestVO, null);
			restTemplate.postForEntity(uri, request, String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
