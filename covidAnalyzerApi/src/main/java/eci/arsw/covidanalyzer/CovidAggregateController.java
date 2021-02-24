package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CovidAggregateController {
    @Autowired
    @Qualifier("covidService")
    ICovidAggregateService covidAggregateService;

    //TODO: Implemente todos los metodos POST que hacen falta.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity addTruePositiveResult(Result result) {
        //TODO
        covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE);
        return null;
    }


    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ArrayList<Result> getFalsePositiveResult() {

        return covidAggregateService.getResult(ResultType.FALSE_POSITIVE);

    }

    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ArrayList<Result> getTrueNegativeResult() {

        return covidAggregateService.getResult(ResultType.TRUE_NEGATIVE);


    }

    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.GET)
    public ArrayList<Result> getFalseNegativeResult() {

        return covidAggregateService.getResult(ResultType.FALSE_NEGATIVE);


    }





    //TODO: Implemente el método.

    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests() {
        //TODO
        covidAggregateService.getResult(ResultType.TRUE_POSITIVE);
        return null;
    }
    @GetMapping(value="/covid/all")
    public ArrayList<Result> getAllResults(){
        return covidAggregateService.getAllResults();
    }
    
}