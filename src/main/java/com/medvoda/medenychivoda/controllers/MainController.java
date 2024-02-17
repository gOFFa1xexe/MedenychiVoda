package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.PackageCapacity;
import com.medvoda.medenychivoda.BottleEntity.Packages;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<PackageCapacity> capacities = Arrays.asList(PackageCapacity.values());

        model.addAttribute("capacities", capacities);

        for (PackageCapacity packageCapacity : capacities) {
            List<Packages> packages = packageService.getAllPackagesByCapacity(packageCapacity);
            model.addAttribute("selectedCapacity", packageCapacity);

            for (CarbonationLevel carbonationLevel : CarbonationLevel.values()) {
                model.addAttribute(carbonationLevel.toString().toLowerCase() + "Count",
                        packageService.getPackageCount(packages, carbonationLevel));
                model.addAttribute(carbonationLevel.toString().toLowerCase() + "CountToday",
                        packageService.getPackageCountToday(packages, carbonationLevel));
            }
            model.addAttribute("todayCount", packageService.getPackageCountToday(packages));
        }

        return "main";
    }
}

