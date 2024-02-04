package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.PackageCapacity;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        int nonCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int strongCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int lightCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int nonCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.NONE,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int strongCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.STRONG,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int lightCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.LIGHT,
                PackageCapacity.ONE_AND_A_HALF_LITER);

                model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
                model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
                model.addAttribute("lightCarbonatedCount", lightCarbonatedCount);
                model.addAttribute("nonCarbonatedCountToday", nonCarbonatedCountToday);
                model.addAttribute("strongCarbonatedCountToday", strongCarbonatedCountToday);
                model.addAttribute("lightCarbonatedCountToday", lightCarbonatedCountToday);
                model.addAttribute("selectedCapacity", PackageCapacity.ONE_AND_A_HALF_LITER);
                model.addAttribute("todayCount", packageService.getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity.ONE_AND_A_HALF_LITER));

            return "main";
        }
}

