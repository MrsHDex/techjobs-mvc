package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String search(Model model, String searchType, String searchTerm){
        //search parameters listed by corresponding form field
        model.addAttribute("columns", columnChoices);
        if (searchType.equals("all")){ //search all in search section
            ArrayList<HashMap<String, String>> searchResults = JobData.findByValue(searchTerm);
            model.addAttribute("searchResults", searchResults);
            return "search";
        }else { //search by type column and keyword (searchTerm)
            ArrayList<HashMap<String, String>> searchResults = JobData.findByColumnAndValue(searchType, searchTerm);

            model.addAttribute("searchResults", searchResults);

            return "search";
        }
    }
}




