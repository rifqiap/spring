package com.os.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.os.spring.model.Message;
import com.os.spring.service.MessageService;

@Controller
public class MessageController {
	
	private MessageService messageService;
	
	@Autowired(required=true)
	@Qualifier(value="messageService")
	public void setMessageService(MessageService ps){
		this.messageService = ps;
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String listMessages(Model model) {
		model.addAttribute("message", new Message());
		model.addAttribute("listMessages", this.messageService.listMessages());
		return "message";
	}
	
	//For add and update message both
	@RequestMapping(value= "/message/add", method = RequestMethod.POST)
	public String addMessage(@ModelAttribute("message") Message p){
		
		if(p.getId() == 0){
			//new message, add it
			this.messageService.addMessage(p);
		}else{
			//existing message, call update
			this.messageService.updateMessage(p);
		}
		
		return "redirect:/messages";
		
	}
	
	@RequestMapping("/message/remove/{id}")
    public String removeMessage(@PathVariable("id") int id){
		
        this.messageService.removeMessage(id);
        return "redirect:/messages";
    }
 
    @RequestMapping("/message/edit/{id}")
    public String editMessage(@PathVariable("id") int id, Model model){
        model.addAttribute("message", this.messageService.getMessageById(id));
        model.addAttribute("listMessages", this.messageService.listMessages());
        return "message";
    }
	
}
