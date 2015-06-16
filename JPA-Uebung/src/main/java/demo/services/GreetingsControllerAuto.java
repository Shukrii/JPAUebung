package demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import demo.model.AAuto;


@Controller
public class GreetingsControllerAuto
{
 
 @Autowired
 private AutoService auto;
 
 public GreetingsControllerAuto()
 {
	
 }


    @RequestMapping(value = "/greeting2", method = RequestMethod.GET)
    @ResponseBody
    public String greeting(@RequestParam(value="grus", required=false, defaultValue="Hallo") String grus, @RequestParam(value="name", required=false, defaultValue="John") String name, Model model)
    {
        //model.addAttribute("name", name);
        return grus+" " + name;
    }
    
    @RequestMapping(value ="/autos", method = RequestMethod.GET)
    @ResponseBody
    public String getAutos()
    {
    	
    	List<AAuto> autoL = auto.findAll();
    	return autoL.toString();
    	
    }
    
    @RequestMapping(value ="/auto/{id1}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable int id1)
    {
    	return auto.findOne(id1).toString();
    }
    
    @RequestMapping(value ="/auto", method = RequestMethod.POST)
    @ResponseBody
    public String postAuto(@RequestParam(value="id", required=true) Integer aid,
    		    @RequestParam(value="marke", required=true, defaultValue="Audi") String amarke)
    {
    	AAuto k = new AAuto();
    	k.setAId(aid);
    	k.setAMarke(amarke);
    	
    	auto.save(k);
    	return k.toString();
    	
    	
     
    }
    
    @RequestMapping(value ="/auto/{id1}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deltAuto(@PathVariable int id1)
    {
     
    	auto.delete(id1);
    	return "deleted";
     
    }
}