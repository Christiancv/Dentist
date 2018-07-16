package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dentist.Patient;
import Dentist.Appointment;

public final class Appointments_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/style.css\">\n");
      out.write("        <title>Hello, world!</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

        Patient p1 = (Patient)session.getAttribute("p1");
        p1.Display();
        
        Appointment apt = new Appointment();
        apt.selectDB(p1.getPatID());
        apt.Display();
        
    
    
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("\n");
      out.write("    <body class=\"navbar navbar2 container-fluid aptt\">\n");
      out.write("        <nav class=\" navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Appointments</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav float\">\n");
      out.write("                    <li class=\"\"><a href=\"index.jsp\">Logout</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\" style=\"padding-top:100px;\">\n");
      out.write("      \n");
      out.write("            <div class=\"col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad\" >\n");
      out.write("              <div class=\"panel panel-info\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                  <h3 class=\"panel-title\">");
out.println("Patient ID # " + p1.getPatID());
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    <div class=\" col-md-12 col-lg-12 \"> \n");
      out.write("                      <table class=\"table table-user-information\" >\n");
      out.write("                        <tbody align=\"center\">\n");
      out.write("                          <tr>\n");
      out.write("                            <td>Date:</td>\n");
      out.write("                            <td>");
out.println(apt.getDate());
      out.write("</td>\n");
      out.write("                          </tr>  \n");
      out.write("                          <tr>\n");
      out.write("                            <td>Dentist ID:</td>\n");
      out.write("                            <td>");
out.println(apt.getDentId());
      out.write("</td>\n");
      out.write("                          </tr>\n");
      out.write("                          <tr>\n");
      out.write("                            <td>Procedure Code:</td>\n");
      out.write("                            <td>");
out.println(apt.getProcCode());
      out.write("</td>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                        </tbody>\n");
      out.write("                      </table>\n");
      out.write("                      <div style=\"padding-left:29%;\">\n");
      out.write("                      <a href=\"Appointments.jsp\" class=\"btn btn-primary\">Appointments</a>\n");
      out.write("                      <a href=\"EditProfile.jsp\" class=\"btn btn-primary\">Edit Profile</a>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("    </div>\n");
      out.write("        <h1>Hello</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
