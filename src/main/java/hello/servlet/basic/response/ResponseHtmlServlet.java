package hello.servlet.basic.response;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html" )
public class ResponseHtmlServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Content-Type: text/html;charset=utf-8
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    writer.println("<body>");
    writer.println("  <div>hi?</div>");
    writer.println("</body>");
    writer.println("</html>");

  }

}
