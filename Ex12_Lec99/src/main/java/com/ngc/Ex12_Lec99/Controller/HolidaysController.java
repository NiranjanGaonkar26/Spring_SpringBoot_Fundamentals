package com.ngc.Ex12_Lec99.Controller;

import com.ngc.Ex12_Lec99.Model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

//    @GetMapping(value = "/holidays")
//    public String displayHolidays(@RequestParam(required = true) boolean festival,@RequestParam(required = false) boolean federal, Model model){
//
//        model.addAttribute("festivalParam", festival);
//        model.addAttribute("federalParam", federal);
//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
//                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
//                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
//                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
//                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
//        );
//
//        Holiday.Type[] types = Holiday.Type.values();
//        for(Holiday.Type type : types){
//            model.addAttribute(type.toString(),  (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
//        }
//        return "holidays";
//    }

    @GetMapping(value = "/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(display != null && display.equals("all")){
            model.addAttribute("festivalParam", true);
            model.addAttribute("federalParam", true);
        } else if (display != null && display.equals("festival")) {
            model.addAttribute("festivalParam", true);
            model.addAttribute("federalParam", false);
        }else {
            model.addAttribute("festivalParam", false);
            model.addAttribute("federalParam", true);
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(),  (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays";
    }
}
