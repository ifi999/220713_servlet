package hello.servlet.basic.request;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Slf4j
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    printStartLIne(request);
    printHeaders(request);
    printHeaderUtils(request);
    printEtc(request);
  }

  private void printStartLIne(HttpServletRequest request) {
    log.info("--- REQUEST-LINE - start ---");
    log.info("request.getMethod() = " + request.getMethod()); //GET
    log.info("request.getProtocol() = " + request.getProtocol()); // HTTP/1.1
    log.info("request.getScheme() = " + request.getScheme()); //http
    // http://localhost:8080/request-header
    log.info("request.getRequestURL() = " + request.getRequestURL());
    // /request-header
    log.info("request.getRequestURI() = " + request.getRequestURI());
    //username=hi
    log.info("request.getQueryString() = " + request.getQueryString());
    log.info("request.isSecure() = " + request.isSecure()); //https 사용 유무
    log.info("--- REQUEST-LINE - end ---");
    log.info("");
  }

  // Header 모든 정보
  private void printHeaders(HttpServletRequest request) {
    log.info("--- REQUEST-LINE - start ---");

    // 옛날 방식
//    Enumeration<String> headerNames = request.getHeaderNames();
//    while( headerNames.hasMoreElements() ) {
//      String headerName = headerNames.nextElement();
//      log.info("####### " + headerName + " : {}", headerName);
//    }

    // 요즘 방식
    request.getHeaderNames().asIterator().forEachRemaining(headerName -> log.info("####### " + headerName + " : {}", headerName));

    // 하나 꺼낼 때
    request.getHeader("host");

    log.info("--- REQUEST-LINE - end ---");
    log.info("");
  }

  // Header 편리한 조회
  private void printHeaderUtils(HttpServletRequest request) {
    System.out.println("--- Header 편의 조회 start ---");
    System.out.println("[Host 편의 조회]");
    System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
    System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
    System.out.println();

    System.out.println("[Accept-Language 편의 조회]");
    request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
    System.out.println("request.getLocale() = " + request.getLocale());
    System.out.println();

    System.out.println("[cookie 편의 조회]");
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        System.out.println(cookie.getName() + ": " + cookie.getValue());
      }
    }
    System.out.println();

    System.out.println("[Content 편의 조회]");
    System.out.println("request.getContentType() = " + request.getContentType());
    System.out.println("request.getContentLength() = " + request.getContentLength());
    System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
    System.out.println("--- Header 편의 조회 end ---");
    System.out.println();
  }

  // 기타 정보
  private void printEtc(HttpServletRequest request) {
    System.out.println("--- 기타 조회 start ---");
    System.out.println("[Remote 정보]");
    System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
    System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
    System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
    System.out.println();

    System.out.println("[Local 정보]");
    System.out.println("request.getLocalName() = " + request.getLocalName()); //
    System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
    System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
    System.out.println("--- 기타 조회 end ---");
    System.out.println();
  }

}
