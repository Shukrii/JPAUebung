package demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.KKunde;

@Controller
public class GreetingsController
{
 
 @Autowired
 private KundeService kunde;
 
 public GreetingsController()
 {
	
 }


    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String greeting(@RequestParam(value="grus", required=false, defaultValue="Hallo") String grus, @RequestParam(value="name", required=false, defaultValue="John") String name, Model model)
    {
        //model.addAttribute("name", name);
        return grus+" " + name;
    }
    
    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @ResponseBody
    public String getUsers()
    {
    	
    	List<KKunde> kundeL = kunde.findAll();
    	return kundeL.toString();
    	
    }
    
    @RequestMapping(value ="/user/{id1}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable int id1)
    {
    	return kunde.findOne(id1).toString();
    }
    
    @RequestMapping(value ="/user", method = RequestMethod.POST)
    @ResponseBody
    public String postUser(@RequestParam(value="id", required=true) Integer kId,
    		    @RequestParam(value="name", required=true, defaultValue="John") String kname1, Model model)
    {
    	KKunde k = new KKunde();
    	k.setKId(kId);
    	k.setKName(kname1);
    	
    	kunde.save(k);
    	return k.toString();
    	
    	
     
    }
    
    @RequestMapping(value ="/user/{id1}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deltUser(@PathVariable int id1)
    {
     
    	if(kunde.findOne(id1) != null) 
    	kunde.delete(id1);
    	return "deleted";
    	
    	//HttpHeaders httpHeaders 
    	
    	//return new ResponseEntity<>(null, HttpStatus.CREATED );
     
    }
}