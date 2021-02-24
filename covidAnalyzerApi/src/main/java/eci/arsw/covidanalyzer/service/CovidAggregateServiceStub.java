package eci.arsw.covidanalyzer.service;

import eci.arsw.covidanalyzer.CovidAggregateController;
import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;

import java.util.ArrayList;
import java.util.UUID;

public class CovidAggregateServiceStub implements ICovidAggregateService{
    ArrayList<Result>listOfResults=new ArrayList<Result>();
    public CovidAggregateServiceStub (){
        Result testResult=new Result(UUID.randomUUID(),"John","Titor","Masculine","john@mail.com","01/01/1894",ResultType.FALSE_POSITIVE,"test",true,01);
    }
    @Override
    public boolean aggregateResult(Result result, ResultType type) {

        return false;
    }

    @Override
    public boolean getResult(ResultType type) {
        return false;
    }

    @Override
    public void upsertPersonWithMultipleTests(UUID id, ResultType type) {

    }
}
