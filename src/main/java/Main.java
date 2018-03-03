import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

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
