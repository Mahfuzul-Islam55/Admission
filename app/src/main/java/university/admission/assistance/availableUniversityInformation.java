package university.admission.assistance;

import java.util.ArrayList;

public class availableUniversityInformation {
    private String UNIVERSITY_ID;
    private String UNIVERSITY_NAME;
    private ArrayList<String>unitList;

    public String getUNIVERSITY_ID() {
        return UNIVERSITY_ID;
    }

    public void setUNIVERSITY_ID(String UNIVERSITY_ID) {
        this.UNIVERSITY_ID = UNIVERSITY_ID;
    }

    public String getUNIVERSITY_NAME() {
        return UNIVERSITY_NAME;
    }

    public void setUNIVERSITY_NAME(String UNIVERSITY_NAME) {
        this.UNIVERSITY_NAME = UNIVERSITY_NAME;
    }

    public ArrayList<String> getUnitList() {
        return unitList;
    }

    public void setUnitList(ArrayList<String> unitList) {
        this.unitList = unitList;
    }
}
