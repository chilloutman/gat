import java.io.File;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

	public static void main(String[] args) throws ServletException, LifecycleException {
		String webapp = "src/main/webapp";

		Tomcat tomcat = new Tomcat();

		tomcat.setPort(8080);

		Context context = tomcat.addWebapp("", new File(webapp).getAbsolutePath());

		Tomcat.addServlet(context, "hello", new HelloServlet());

		context.addServletMappingDecoded("/hello", "hello");

		tomcat.start();
		tomcat.getServer().await();
	}

}
