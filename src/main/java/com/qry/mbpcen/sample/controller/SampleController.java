package com.qry.mbpcen.sample.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



//===================================================================
//@RestController 어노테이션의 역할 (스프링 4부터 추가)
//@ResponseBody 어노테이션과 @Controller 어노테이션을 합쳐서 만든 어노테이션
//  --> @ResponseBody 어노테이션이 있으면 실행결과는 View를 거치지 않고 Http ResponseBody에 직접 입력된다.
//  --> MappingJacksonHttMessageConverter를 통해 Json으로 결과가 표현된다.
//===================================================================
@RestController
@RequestMapping(value = "/sample")
public class SampleController {
    private final Log logger = LogFactory.getLog(getClass());
    




	@RequestMapping(value = "/step1" )
	public String step1() throws NoSuchAlgorithmException, InvalidKeySpecException  {
		ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttr.getRequest();	
		HttpServletResponse response = requestAttr.getResponse();
		HttpSession httpSession = request.getSession();
		String sess_id = httpSession.getId();
		
	

		
		/*[설 명]
		 * 1. json-simple는 google에서 제공해주는 json사용 라이브러리 입니다
		 * 2. jsonObject.put(key, value); 형태로 데이터를 삽입합니다
		 * 3. jsonObjectParse.get(key); 형태로 데이터를 추출합니다
		 * 4. jsonArray.add(value); 형태로 데이터를 삽입합니다
		 * 5. jsonArray.get(배열 번지); 형태로 데이터를 추출합니다
		 * 6. JSONParser 는 json 데이터 파싱을 도와주는 객체입니다
		 * */
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Res1", "Success");
		jsonObject.put("Res2", "HELLO");
		
		
		return jsonObject.toJSONString();
	}
	
	
	
}
