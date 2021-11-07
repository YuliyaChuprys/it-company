package com.solvd.itcompany.domain;

public class ArrivalDepartureJournal {

    private static ArrivalDepartureJournal arrivalDepartureJournal;
    private static String logJournal = "This is employee Arrival and Departure Journal\n";

    public static ArrivalDepartureJournal getArrivalDepartureJournal(){
        if(arrivalDepartureJournal == null){
            arrivalDepartureJournal = new ArrivalDepartureJournal();
        }
        return arrivalDepartureJournal;
    }

    private ArrivalDepartureJournal(){

    }

    public void addJournalInfo(String JournalInfo){
        logJournal += JournalInfo + "\n";
    }

    public void showJournalInfo(){
        System.out.println(logJournal);
    }

}
