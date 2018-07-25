package edu.ustb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    /**
     * 在WEB应用程序启动时自动调用的方法。只执行一次。
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//获得WEB应用程序容器对象，也是一个全局容器。
    	ServletContext application = sce.getServletContext();
    	//获取当前站点的根目录名称
    	String rootPath = application.getContextPath();
    	//将当前站点的根目录名称保存到WEB应用程序容器对象
    	application.setAttribute("rootPath", rootPath);
    	System.out.println(rootPath + "::::#$%^%$^*()*^*%$#%");
    }
}
