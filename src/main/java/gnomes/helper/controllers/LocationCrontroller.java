package gnomes.helper.controllers;

import gnomes.helper.repositories.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationCrontroller {
    private LocationRepository locationRepository;

    public LocationCrontroller(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }


    @RequestMapping("/locations")
    public String getLocations(Model model){

        model.addAttribute("locations", locationRepository.findAll());
        return "locations";
    }
 
}
