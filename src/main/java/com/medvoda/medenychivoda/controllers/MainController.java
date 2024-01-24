package com.medvoda.medenychivoda.controllers;


import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
public class MainController {


    private final PackageService packageService;

    @Autowired
    public MainController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public String ShowStat(Model model){
        int nonCarbonatedCount= packageService.getPackageCountByCarbonationLevel(CarbonationLevel.NONE);
        int strongCarbonatedCount= packageService.getPackageCountByCarbonationLevel(CarbonationLevel.STRONG);
        int lightCarbonatedCount= packageService.getPackageCountByCarbonationLevel(CarbonationLevel.LIGHT);
        model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
        model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
        model.addAttribute("weakCarbonatedCount", lightCarbonatedCount);

        return "main";
    }

    @PostMapping("add-package/{carbonationLevel}")
    public String addPackage(@PathVariable CarbonationLevel carbonationLevel, @RequestParam int quantity){
        packageService.addPackage(carbonationLevel, quantity);
        return "redirect:/main";
    }

}
