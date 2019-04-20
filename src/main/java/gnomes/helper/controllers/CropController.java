package gnomes.helper.controllers;

import gnomes.helper.repositories.CropRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CropController {

    private CropRepository cropRepository;

    public  CropController(){

    }

    public CropController(CropRepository cropRepository){
        this.cropRepository = cropRepository;
    }


    //maps method to  HTTP request path
    @RequestMapping("/crops")
    public String getCrops(Model model){

        // Spring will get all crops from db
        model.addAttribute("crops", cropRepository.findAll());

        return "crops";
    }

    @RequestMapping("/")
    public String crops(){
        return "crops";
    }




}
