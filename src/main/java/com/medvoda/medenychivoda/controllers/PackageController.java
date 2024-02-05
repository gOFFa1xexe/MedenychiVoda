package com.medvoda.medenychivoda.controllers;


import com.medvoda.medenychivoda.Entity.PackageEntity.CarbonationLevel;
import com.medvoda.medenychivoda.Entity.PackageEntity.PackageCapacity;
import com.medvoda.medenychivoda.services.PackageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addPackage")
public class PackageController {


    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }
    @GetMapping("/{capacity}")
    public String showMainPage(@PathVariable String capacity,Model model){
        int nonCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE,
                PackageCapacity.valueOf(capacity));
        int strongCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG,
                PackageCapacity.valueOf(capacity));
        int lightCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT,
                PackageCapacity.valueOf(capacity));
        int nonCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.NONE,
                PackageCapacity.valueOf(capacity));
        int lightCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.LIGHT,
                PackageCapacity.valueOf(capacity));
        int strongCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.STRONG,
                PackageCapacity.valueOf(capacity));
        model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
        model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
        model.addAttribute("lightCarbonatedCount", lightCarbonatedCount);
        model.addAttribute("nonCarbonatedCountToday",nonCarbonatedCountToday);
        model.addAttribute("lightCarbonatedCountToday",lightCarbonatedCountToday);
        model.addAttribute("strongCarbonatedCountToday",strongCarbonatedCountToday);
        model.addAttribute("selectedCapacity",capacity);
        model.addAttribute("todayCount",
                packageService.getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity.valueOf(capacity)));
        return "addPackage";
    }

    @PostMapping("add-package/{carbonationLevel}")
    public String addPackage(@PathVariable CarbonationLevel carbonationLevel,
                             @RequestParam int quantity,
                             @RequestParam PackageCapacity packageCapacity, HttpServletRequest request){
        packageService.addPackage(carbonationLevel, quantity, packageCapacity);
        String referer = request.getHeader("Referer");

        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        } else {

            return "redirect:/addPackage";
        }
    }
}