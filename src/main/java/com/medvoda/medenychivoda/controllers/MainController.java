package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.Entity.PackageEntity.CarbonationLevel;
import com.medvoda.medenychivoda.Entity.PackageEntity.PackageCapacity;
import com.medvoda.medenychivoda.Entity.PackageEntity.Packages;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private final PackageService packageService;

    @Autowired
    public MainController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public String showMainPage(Model model) {
        List<Packages> packages=packageService.getAllPackagesByCapacity(PackageCapacity.ONE_AND_A_HALF_LITER);


        for (CarbonationLevel carbonationLevel : CarbonationLevel.values()) {
            model.addAttribute(carbonationLevel.toString().toLowerCase() + "Count",
                    packageService.getPackageCount(packages, carbonationLevel));
            model.addAttribute(carbonationLevel.toString().toLowerCase() + "CountToday",
                    packageService.getPackageCountToday(packages, carbonationLevel));
        }
        model.addAttribute("todayCount", packageService.getPackageCountToday(packages));

        return "main";
    }
}