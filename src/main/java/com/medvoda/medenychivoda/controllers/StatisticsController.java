package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.PackageCapacity;
import com.medvoda.medenychivoda.BottleEntity.Packages;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticsController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/{capacity}")
    public String showPackageInfo(@PathVariable String capacity, Model model) {
        CarbonationLevel carbonationLevel = CarbonationLevel.NONE; // Змініть згідно вашим потребам
        PackageCapacity packageCapacity = PackageCapacity.valueOf(capacity);
        LocalDateTime today = LocalDateTime.now();

        List<Package> packagesList = packageService.getAllPackagesByCarbonationLevelAndCapacityAndCreatedAtAfter(
                carbonationLevel, packageCapacity, today);

        model.addAttribute("packages", packagesList);
        return "packageStat";
    }
}

