package eci.arsw.covidanalyzer.service;

import eci.arsw.covidanalyzer.CovidAggregateController;
import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
@Qualifier("covidService")
public class CovidAggregateServiceStub implements ICovidAggregateService{
    ArrayList<Result>listOfResults=new ArrayList<Result>();
    public CovidAggregateServiceStub (){
        Result testResult=new Result(UUID.randomUUID(),"John","Titor","Masculine","john@mail.com","01/01/1894",ResultType.FALSE_POSITIVE,"test",true,01);
        listOfResults.add(testResult);
    }
    @Override
    public boolean aggregateResult(Result result, ResultType type) {
        boolean flagRepeatedEntry=false;
        for (int i = 0; i < listOfResults.size(); i++) {
            if(listOfResults.get(i).getId().equals(result.getId())){
                flagRepeatedEntry=true;
            }
        }
        if (!flagRepeatedEntry){
            result.setType(type);
            listOfResults.add(result);

        }
        if (flagRepeatedEntry){

        }
        return !flagRepeatedEntry;
    }

    @Override
    public ArrayList<Result> getResult(ResultType type) {
        ArrayList<Result>listOfResultsOfSomeType=new ArrayList<Result>();
        for (int i=0;i<listOfResults.size();i++){
            if(listOfResults.get(i).getResultType().equals(type)){
                listOfResultsOfSomeType.add(listOfResults.get(i));
            }
        }
        return listOfResultsOfSomeType;
    }

    @Override
    public void upsertPersonWithMultipleTests(UUID id, ResultType type) {

    }

    public ArrayList<Result> getAllResults(){
        return listOfResults;
    }
}
