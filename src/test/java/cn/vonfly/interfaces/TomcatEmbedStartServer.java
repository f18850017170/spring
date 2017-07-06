package cn.vonfly.interfaces;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.catalina.webresources.WarResourceSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by Administrator on 2017/7/5.
 */
public class TomcatEmbedStartServer {
    private static final String hostName = "127.0.0.1";
    private static final int port = 8787;
    private static final String contextPath = "";
    private static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {

        String appLocationDir = System.getProperty("user.dir");
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setHostname(hostName);
            tomcat.setPort(port);
            Context context = tomcat.addWebapp(contextPath, new File(appLocationDir).getAbsolutePath());
            WebResourceRoot resourceRoot = new StandardRoot(context);
            resourceRoot.addPreResources(new DirResourceSet(resourceRoot,
                    "/WEB-INF/classes",
                    new File("target/classes").getAbsolutePath(),
                    "/"));
            context.setResources(resourceRoot);
            tomcat.start();
            LOGGER.info("服务已正常启动，host={},port={},contextPath={}",hostName,port,contextPath);
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
