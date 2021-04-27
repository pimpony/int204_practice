package sit.int204.practice.controller;

import org.springframework.web.bind.annotation.*;
import sit.int204.practice.exceptions.ExceptionResponse;
import sit.int204.practice.exceptions.SurveyException;
import sit.int204.practice.models.Survey;

import java.util.*;

@RestController
@RequestMapping("/survey")
public class ServeyRestController {
    private final static Map<Integer, Survey> surveys = new TreeMap<>();

    static {
        surveys.put(1001, new Survey(1001, "Pichet", 1));
        surveys.put(1002, new Survey(1002, "Somchai", 2));
        surveys.put(1003, new Survey(1003, "Somsak", 2));
        surveys.put(1004, new Survey(1004, "Somsri", 3));
        surveys.put(1005, new Survey(1005, "Somkiat", 2));
    }

    @GetMapping("")
    public List<Survey> surveyList(){
        return new ArrayList<>(surveys.values());

    }

    @GetMapping("{id}")
    public Survey survey(@PathVariable int id){
        if(surveys.get(id)==null){
            throw new SurveyException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST,
                    "ID:{ "+id+" } does not exist !!");
        }
        return surveys.get(id);
    }



    @PostMapping("")
    public Survey create(@RequestBody Survey newSurvey){
        if(surveys.get(newSurvey.getId())!=null) {
            throw new SurveyException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST,
                    "ID:{ " + newSurvey.getId() + " } already exist !!");
        };
        surveys.put(newSurvey.getId(),newSurvey);
                return newSurvey;
    }

    @PutMapping("")
    public Survey update(@RequestBody Survey newSurvey){
        surveys.put(newSurvey.getId(), newSurvey);
        return newSurvey;
    }

    @DeleteMapping("{id}")
    public Survey delete(@PathVariable int id){
        return surveys.remove(id);
    }

}
