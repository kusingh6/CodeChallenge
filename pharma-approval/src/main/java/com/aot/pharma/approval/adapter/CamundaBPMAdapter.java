/**
 * 
 */
package com.aot.pharma.approval.adapter;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.aot.pharma.approval.domain.vo.ApplicationVO;
import com.aot.pharma.approval.domain.vo.CamundaPropertyVO;
import com.aot.pharma.approval.domain.vo.CamundaResponseVO;
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
			System.out.println("URL" + bpmURL);
			RestTemplate restTemplate = new RestTemplate();
			CamundaVO requestVO = new CamundaVO();
			CamundaVariableVO variable  = new CamundaVariableVO();
			variable.setApplicationId(new CamundaPropertyVO(application.getApplicationId(), "String"));
			if(application.getPharmacistRegNo()!=null) {
				variable.setRegistrationNumber(new CamundaPropertyVO(application.getPharmacistRegNo().toString(), "String"));
			}
			else {
				variable.setRegistrationNumber(new CamundaPropertyVO("null", "String"));
			}
			variable.setApplicantName(new CamundaPropertyVO(application.getApplicantName(), "String"));
			requestVO.setVariables(variable);
			requestVO.setBusinessKey(application.getApplicationId());
			System.out.println(requestVO);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<CamundaVO> request = new HttpEntity<>(requestVO, headers);
			restTemplate.postForObject(uri, request, CamundaResponseVO.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
