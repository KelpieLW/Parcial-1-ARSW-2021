package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class CovidAggregateController {
    @Autowired
    @Qualifier("covidService")
    ICovidAggregateService covidAggregateService;

    //TODO: Implemente todos los metodos POST que hacen falta.

    //Metodos GET

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity getTruePositiveResult(Result result) {
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
    //Metodos POST
    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity<?>addTruePositiveResult(@RequestBody Result resultToAdd) {
        boolean flag;
        flag=covidAggregateService.aggregateResult(resultToAdd,ResultType.TRUE_POSITIVE);
        if(flag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    public ResponseEntity<?>addTrueNegativeResult(@RequestBody Result resultToAdd) {
        boolean flag;
        flag=covidAggregateService.aggregateResult(resultToAdd,ResultType.TRUE_NEGATIVE);
        if(flag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity<?>addFalsePositiveResult(@RequestBody Result resultToAdd) {
        boolean flag;
        flag=covidAggregateService.aggregateResult(resultToAdd,ResultType.FALSE_POSITIVE);
        if(flag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    public ResponseEntity<?>addFalseNegativeResult(@RequestBody Result resultToAdd) {
        boolean flag;
        flag=covidAggregateService.aggregateResult(resultToAdd,ResultType.FALSE_NEGATIVE);
        if(flag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }




///////BONO
    @RequestMapping(value = "/covid/result/{date}", method = RequestMethod.GET)
    public ArrayList<Result> getByDate(@PathVariable String date) {

        return covidAggregateService.getResultByDate(date);


    }



    //TODO: Implemente el método.

    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests(@PathVariable UUID id, @RequestBody ResultType type) {
        //TODO
        boolean flag;
        flag=covidAggregateService.upsertPersonWithMultipleTests(id,type);
        if(flag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping(value="/covid/all")
    public ArrayList<Result> getAllResults(){
        return covidAggregateService.getAllResults();
    }
    
}