/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-12-01 05:41:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.introduction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class direction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../_header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"sub\">\r\n");
      out.write("            <div><img src=\"../img/sub_top_tit1.png\" alt=\"INTRODUCTION\"></div>\r\n");
      out.write("            <section class=\"cate1\">\r\n");
      out.write("                <aside>\r\n");
      out.write("                    <img src=\"../img/sub_aside_cate1_tit.png\" alt=\"팜스토리 소개\"/>\r\n");
      out.write("\r\n");
      out.write("                    <ul class=\"lnb\">\r\n");
      out.write("                        <li><a href=\"./hello.do\">인사말</a></li>\r\n");
      out.write("                        <li class=\"on\"><a href=\"./direction.do\">찾아오시는 길</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </aside>\r\n");
      out.write("                <article>\r\n");
      out.write("                    <nav>\r\n");
      out.write("                        <img src=\"../img/sub_nav_tit_cate1_tit2.png\" alt=\"찾아오시는길\"/>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            HOME > 팜스토리소개 > <em>찾아오시는길</em>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </nav>\r\n");
      out.write("\r\n");
      out.write("                    <!-- 내용 시작 -->\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <strong>팜스토리</strong><br>\r\n");
      out.write("                        주소: 경기도 이천시 잘한다구 신난다동 123<br>\r\n");
      out.write("                        전화: 01-234-5678<br>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <strong>찾아오시는길</strong><br>\r\n");
      out.write("                        <!-- * 카카오맵 - 지도퍼가기 -->\r\n");
      out.write("                        <!-- 1. 지도 노드 -->\r\n");
      out.write("                        <div id=\"daumRoughmapContainer1668214668575\" class=\"root_daum_roughmap root_daum_roughmap_landing\"></div>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <!--\r\n");
      out.write("                        2. 설치 스크립트\r\n");
      out.write("                        * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.\r\n");
      out.write("                    -->\r\n");
      out.write("                    <script charset=\"UTF-8\" class=\"daum_roughmap_loader_script\" src=\"https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js\"></script>\r\n");
      out.write("\r\n");
      out.write("                    <!-- 3. 실행 스크립트 -->\r\n");
      out.write("                    <script charset=\"UTF-8\">\r\n");
      out.write("                        new daum.roughmap.Lander({\r\n");
      out.write("                            \"timestamp\" : \"1668214668575\",\r\n");
      out.write("                            \"key\" : \"2ci7x\",\r\n");
      out.write("                            \"mapWidth\" : \"760\",\r\n");
      out.write("                            \"mapHeight\" : \"400\"\r\n");
      out.write("                        }).render();\r\n");
      out.write("                    </script>\r\n");
      out.write("                    <!-- 내용 끝 -->\r\n");
      out.write("\r\n");
      out.write("                </article>\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../_footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
