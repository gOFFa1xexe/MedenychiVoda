package com.medvoda.medenychivoda.controllers;


import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.PackageCapacity;
import com.medvoda.medenychivoda.services.PackageService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String showMainPage(Model model){
        int nonCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int strongCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int lightCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int nonCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.NONE,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int lightCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.LIGHT,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        int strongCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.STRONG,
                PackageCapacity.ONE_AND_A_HALF_LITER);
        model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
        model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
        model.addAttribute("lightCarbonatedCount", lightCarbonatedCount);
        model.addAttribute("nonCarbonatedCountToday",nonCarbonatedCountToday);
        model.addAttribute("lightCarbonatedCountToday",lightCarbonatedCountToday);
        model.addAttribute("strongCarbonatedCountToday",strongCarbonatedCountToday);
        model.addAttribute("todayCount",
                packageService.getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity.ONE_AND_A_HALF_LITER));


        return "main";
    }

    @PostMapping("add-package/{carbonationLevel}")
    public String addPackage(@PathVariable CarbonationLevel carbonationLevel,
                             @RequestParam int quantity,
                             @RequestParam PackageCapacity packageCapacity, HttpServletRequest request){
        packageService.addPackage(carbonationLevel, quantity, packageCapacity);

        // Отримайте URL сторінки з запиту та використовуйте його для редіректа
        String referer = request.getHeader("Referer");

        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        } else {

            return "redirect:/main";
        }
    }

    @GetMapping("/half-a-liter")
    public String showHalfLiterPage(Model model){
        int nonCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE,
                PackageCapacity.HALF_LITER);
        int strongCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG,
                PackageCapacity.HALF_LITER);
        int lightCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT,
                PackageCapacity.HALF_LITER);
        int nonCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.NONE,
                PackageCapacity.HALF_LITER);
        int lightCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.LIGHT,
                PackageCapacity.HALF_LITER);
        int strongCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.STRONG,
                PackageCapacity.HALF_LITER);

        model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
        model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
        model.addAttribute("lightCarbonatedCount", lightCarbonatedCount);
        model.addAttribute("nonCarbonatedCountToday",nonCarbonatedCountToday);
        model.addAttribute("lightCarbonatedCountToday",lightCarbonatedCountToday);
        model.addAttribute("strongCarbonatedCountToday",strongCarbonatedCountToday);
        model.addAttribute("todayCount",
                packageService.getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity.HALF_LITER));


        return "half-a-liter";
    }

    @GetMapping("/five-liter")
    public String showFileLiterPage(Model model){
        int nonCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.NONE,
                PackageCapacity.FIVE_LITER);
        int strongCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.STRONG,
                PackageCapacity.FIVE_LITER);
        int lightCarbonatedCount= packageService.getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel.LIGHT,
                PackageCapacity.FIVE_LITER);
        int nonCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.NONE,
                PackageCapacity.FIVE_LITER);
        int lightCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.LIGHT,
                PackageCapacity.FIVE_LITER);
        int strongCarbonatedCountToday=packageService.getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                CarbonationLevel.STRONG,
                PackageCapacity.FIVE_LITER);

        model.addAttribute("nonCarbonatedCount", nonCarbonatedCount);
        model.addAttribute("strongCarbonatedCount", strongCarbonatedCount);
        model.addAttribute("lightCarbonatedCount", lightCarbonatedCount);
        model.addAttribute("nonCarbonatedCountToday",nonCarbonatedCountToday);
        model.addAttribute("lightCarbonatedCountToday",lightCarbonatedCountToday);
        model.addAttribute("strongCarbonatedCountToday",strongCarbonatedCountToday);
        model.addAttribute("todayCount",
                packageService.getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity.FIVE_LITER));


        return "five-liter";
    }
}
