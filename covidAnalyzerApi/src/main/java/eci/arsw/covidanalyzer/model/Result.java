package eci.arsw.covidanalyzer.model;

import java.util.UUID;

public class Result {

    //<editor-fold desc="properties">
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String birthString;
    private ResultType type;
    private String testString;
    private boolean result;
    private double testSpecifity;
    private int numberOfTestsMade;
    //</editor-fold>
    public Result(){

    }

    public Result(UUID id, String firstName, String lastName, String gender, String email, String birthString, ResultType type, String testString, boolean result, double testSpecifity){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.email=email;
        this.birthString=birthString;
        this.type=type;
        this.testString=testString;
        this.result=result;
        this.testSpecifity=testSpecifity;
        this.numberOfTestsMade=0;

    }
    //<editor-fold desc="getters">
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthString;
    }

    public String getTestDate() {
        return testString;
    }

    public boolean isResult() {
        return result;
    }

    public double getTestSpecifity() {
        return testSpecifity;
    }

    public ResultType getResultType(){
        return type;
    }
    //</editor-fold>

    //<editor-fold desc="setters">
    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthString) {
        this.birthString = birthString;
    }

    public void setTestDate(String testString) {
        this.testString = testString;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setTestSpecifity(double testSpecifity) {
        this.testSpecifity = testSpecifity;


    }

    public void increment(){
        numberOfTestsMade+=1;
    }
    public int getNumberOfTestsMade(){
        return numberOfTestsMade;
    }
    public void setType(ResultType resultType){
        this.type=resultType;
    }
    //</editor-fold>

    //<editor-fold desc="Equality Methods">
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return ((Result) o).getId().equals(this.id);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return this.id.toString() + " - " + this.firstName + " - " + this.lastName;
    }
}
