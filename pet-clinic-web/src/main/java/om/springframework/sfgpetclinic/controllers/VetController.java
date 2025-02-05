package om.springframework.sfgpetclinic.controllers;

import om.springframework.sfgpetclinic.model.Vet;
import om.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {


    private  final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html","/vets.html"})
    public String ListVets(Model model){

        model.addAttribute("vets", vetService.findAll());
        return "vets/index"; // thymeleaf will look for index file
    }

    @GetMapping("/api/vets")
    public @ResponseBody
    Set<Vet> getVetsJson(){

        return vetService.findAll();
    }
}
