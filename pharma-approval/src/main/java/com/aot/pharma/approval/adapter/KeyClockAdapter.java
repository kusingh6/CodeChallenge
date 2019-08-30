/**
 * 
 */
package com.aot.pharma.approval.adapter;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aot.pharma.approval.domain.vo.BearerTokenVO;

/**
 * @author Dheepak Ramanathan
 *
 */
public class KeyClockAdapter {
	
	public static BearerTokenVO authenticateToken(String bearerToken, String keyclockURL) {
		RestTemplate restTemplate = new RestTemplate();
	    URI uri;
	    
		try {
			uri = new URI(keyclockURL);
			HttpHeaders headers = new HttpHeaders();
		    headers.set("Authorization", bearerToken);
		    HttpEntity<BearerTokenVO> requestEntity = new HttpEntity<>(null, headers);
		    ResponseEntity<BearerTokenVO> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, BearerTokenVO.class);
		    return result.getBody();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return null;
	    
	}

}
