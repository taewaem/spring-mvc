package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Slf4j
@Controller
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,    //GET, POST 등 HTTP메소드가 다 들어있따.
                          Locale locale,            //언어 정보를 받을 수 있다.
                          @RequestHeader MultiValueMap<String, String> headerMap,   //header정보
                          @RequestHeader("host") String host,       //header를 하나만 받고 싶을 때
                          @CookieValue(value = "myCookie", required = false) String cookie  //myCookie는 이름 false는 없어도 된다는 뜻
    ) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}
