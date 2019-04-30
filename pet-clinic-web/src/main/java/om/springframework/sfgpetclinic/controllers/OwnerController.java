package om.springframework.sfgpetclinic.controllers;

import om.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index"; // thymeleaf will look for index file
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }


}
