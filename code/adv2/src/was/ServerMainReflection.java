package was;

import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.reflection.ReflectionServlet;
import was.servlet.HomeServlet;
import was.httpserver.servlet.reflection.SearchController;
import was.httpserver.servlet.reflection.SiteController;

import java.io.IOException;
import java.util.List;

public class ServerMainReflection {

    private static final int PORT = 12345;

    public static void main(String[] args)  throws IOException {
        List<Object> controllers = List.of(new SiteController(), new SearchController());
        HttpServlet reflectionServlet = new ReflectionServlet(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(reflectionServlet);
        servletManager.add("/", new HomeServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }

}
