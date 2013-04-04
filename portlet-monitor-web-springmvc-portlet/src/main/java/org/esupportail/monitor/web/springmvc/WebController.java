package org.esupportail.monitor.web.springmvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import org.esupportail.monitor.web.tools.*;

@Controller
public class WebController extends AbstractExceptionController {

	private boolean users = true;
	private List<ServerInfo> servers = null;

    
    @RequestMapping("VIEW")
    protected ModelAndView renderView(RenderRequest request, RenderResponse response) throws Exception {
        
    	ModelMap model = new ModelMap();
    	servers = new ArrayList<ServerInfo>();
    	
        for(Iterator i = Config.getInstance().getServers().iterator();i.hasNext();) {

        	ServerInfo s = (ServerInfo)i.next();
			s.getUsers().clear();
			if(InfosCollector.fetch(s, users)){
				servers.add(s);
			}
        }   
 

        model.put("liste_serveurs", servers);

        return new ModelAndView("view", model);
    }

    @RequestMapping("ABOUT")
	public ModelAndView renderAboutView(RenderRequest request, RenderResponse response) throws Exception {
		ModelMap model = new ModelMap();
		return new ModelAndView("about", model);
	}
    

}
