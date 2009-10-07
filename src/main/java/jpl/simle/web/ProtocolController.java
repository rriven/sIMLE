package jpl.simle.web;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpl.simle.domain.Protocol;
import jpl.simle.service.LabManagerService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProtocolController {

	private LabManagerService labManager_;
	
	@RequestMapping(value="/application/{applicationId}/protocols", method=RequestMethod.GET)
	public ModelAndView list(@PathVariable Long applicationId, 
							 ModelMap modelMap, HttpServletRequest request, HttpServletResponse response)
	{
		List<Protocol> protocols = labManager_.findProtocolsByApplicationId(applicationId);
		
		return new ModelAndView("application/list", "protocols", protocols);
	}
	
    @RequestMapping(value="/application/{applicationId}/protocol/{protocolId}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable Long applicationId, @PathVariable Long protocolId,
    						ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) 
    {
    	Protocol protocol = labManager_.findProtocol(applicationId, protocolId);
    	
    	if ( protocol == null )
    	{
    		return new ModelAndView("redirect:error", "error", "No protocol found with appid " + applicationId + " and id " + protocolId);
    	}
    	
    	return new ModelAndView("/protocol/show", "protocol", protocol);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/application/{applicationId}/protocol", headers={"content-type:application/xml"})
    public String createXML(@PathVariable Long applicationId, @RequestBody Protocol protocol, 
    					 ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) 
    throws IOException
    {
    	labManager_.saveProtocol(applicationId, protocol);
    	
    	if ( protocol.getId() != null )
    	{
    		modelMap.put("protocol", protocol);
    		return "redirect:/application/" + applicationId + "/protocol/" + protocol.getId();
    	}
    	else
    	{
    		response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Could not save protocol");
    		return "error";
    	}
    }

    @RequestMapping(method = RequestMethod.POST, value = "/application/{applicationId}/protocol")
    public ModelAndView create(@PathVariable Long applicationId, Protocol protocol,
    						 ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) 
    {
    	labManager_.saveProtocol(applicationId, protocol);
    	
    	if ( protocol.getId() != null )
    	{
    		modelMap.put("protocol", protocol);
    		return new ModelAndView("redirect:/application/" + applicationId + "/protocol/" + protocol.getId());
    	}
    	else
    	{
    		return new ModelAndView("/protocol/show", "protocol", protocol);
    	}
    }
    
    @Autowired
    public void setLabManagerDAO(LabManagerService labManagerDAO)
    {
    	labManager_ = labManagerDAO;
    }
}
