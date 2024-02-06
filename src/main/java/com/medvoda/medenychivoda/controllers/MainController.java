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

import static com.medvoda.medenychivoda.BottleEntity.PackageCapacity.*;

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
        for (PackageCapacity packageCapacity : PackageCapacity.values()) {
            int nonCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE, packageCapacity);
            int strongCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG, packageCapacity);
            int lightCarbonatedCount = packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT, packageCapacity);
            int nonCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.NONE, packageCapacity);
            int strongCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.STRONG, packageCapacity);
            int lightCarbonatedCountToday = packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel.LIGHT, packageCapacity);
            int today = packageService.getPackageToday(packageCapacity);
            List<Integer> integerList = Arrays.asList(
                    nonCarbonatedCount,
                    strongCarbonatedCount,
                    lightCarbonatedCount,
                    nonCarbonatedCountToday,
                    strongCarbonatedCountToday,
                    lightCarbonatedCountToday,
                    today
            );
            model.addAttribute("selectedCapacity",packageCapacity);
            model.addAttribute("integerList", integerList);
        }
        return "main";
    }

}

