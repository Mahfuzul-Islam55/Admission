package university.admission.assistance;

public class universityUnitInformation {

    private String UNIT_NAME;
    private String APPLICATION_BEGIN;
    private String APPLICATION_END;
    private String ADMIT_CARD_BEGIN;
    private String ADMIT_CARD_END;
    private String EXAM_DEADLINE;
    private String APPLY_LINK;

    public String getAPPLY_LINK() {
        return APPLY_LINK;
    }

    public void setAPPLY_LINK(String APPLY_LINK) {
        this.APPLY_LINK = APPLY_LINK;
    }

    public String getEXAM_DEADLINE() {
        return EXAM_DEADLINE;
    }

    public void setEXAM_DEADLINE(String EXAM_DEADLINE) {
        this.EXAM_DEADLINE = EXAM_DEADLINE;
    }

    private String FEES;

    public String getUNIT_NAME() {
        return UNIT_NAME;
    }

    public void setUNIT_NAME(String UNIT_NAME) {
        this.UNIT_NAME = UNIT_NAME;
    }

    public String getAPPLICATION_BEGIN() {
        return APPLICATION_BEGIN;
    }

    public void setAPPLICATION_BEGIN(String APPLICATION_BEGIN) {
        this.APPLICATION_BEGIN = APPLICATION_BEGIN;
    }

    public String getAPPLICATION_END() {
        return APPLICATION_END;
    }

    public void setAPPLICATION_END(String APPLICATION_END) {
        this.APPLICATION_END = APPLICATION_END;
    }

    public String getADMIT_CARD_BEGIN() {
        return ADMIT_CARD_BEGIN;
    }

    public void setADMIT_CARD_BEGIN(String ADMIT_CARD_BEGIN) {
        this.ADMIT_CARD_BEGIN = ADMIT_CARD_BEGIN;
    }

    public String getADMIT_CARD_END() {
        return ADMIT_CARD_END;
    }

    public void setADMIT_CARD_END(String ADMIT_CARD_END) {
        this.ADMIT_CARD_END = ADMIT_CARD_END;
    }

    public String getFEES() {
        return FEES;
    }

    public void setFEES(String FEES) {
        this.FEES = FEES;
    }
}