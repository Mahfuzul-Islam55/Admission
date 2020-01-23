package university.admission.assistance;

public class Dbcontract {

    private static double SSC_PASS_YEAR;
    private static double SSC_MIN_GPA;
    private static double HSC_PASS_YEAR;
    private static double HSC_MIN_GPA;


    //STUDENT information for "SCIENCE" ONLY

    private static double PHYSICS_GPA;
    private static double CHEMISTRY_GPA;
    private static double HIGHER_MATH_GPA;
    private static double BIOLOGY_GPA;
    private static double BANGLA_GPA;
    private static double ENGLISH_GPA;
    private static double ICT_GPA;

    //STUDENT information for "COMMERCE" only


    //STUDENT information for "ARTS" only




    public static double getSscPassYear() {
        return SSC_PASS_YEAR;
    }

    public static void setSscPassYear(double sscPassYear) {
        SSC_PASS_YEAR = sscPassYear;
    }

    public static double getSscMinGpa() {
        return SSC_MIN_GPA;
    }

    public static void setSscMinGpa(double sscMinGpa) {
        SSC_MIN_GPA = sscMinGpa;
    }

    public static double getHscPassYear() {
        return HSC_PASS_YEAR;
    }

    public static void setHscPassYear(double hscPassYear) {
        HSC_PASS_YEAR = hscPassYear;
    }

    public static double getHscMinGpa() {
        return HSC_MIN_GPA;
    }

    public static void setHscMinGpa(double hscMinGpa) {
        HSC_MIN_GPA = hscMinGpa;
    }

    public static double getPhysicsGpa() {
        return PHYSICS_GPA;
    }

    public static void setPhysicsGpa(double physicsGpa) {
        PHYSICS_GPA = physicsGpa;
    }

    public static double getChemistryGpa() {
        return CHEMISTRY_GPA;
    }

    public static void setChemistryGpa(double chemistryGpa) {
        CHEMISTRY_GPA = chemistryGpa;
    }

    public static double getHigherMathGpa() {
        return HIGHER_MATH_GPA;
    }

    public static void setHigherMathGpa(double higherMathGpa) {
        HIGHER_MATH_GPA = higherMathGpa;
    }

    public static double getBiologyGpa() {
        return BIOLOGY_GPA;
    }

    public static void setBiologyGpa(double biologyGpa) {
        BIOLOGY_GPA = biologyGpa;
    }

    public static double getBanglaGpa() {
        return BANGLA_GPA;
    }

    public static void setBanglaGpa(double banglaGpa) {
        BANGLA_GPA = banglaGpa;
    }

    public static double getEnglishGpa() {
        return ENGLISH_GPA;
    }

    public static void setEnglishGpa(double englishGpa) {
        ENGLISH_GPA = englishGpa;
    }

    public static double getIctGpa() {
        return ICT_GPA;
    }

    public static void setIctGpa(double ictGpa) {
        ICT_GPA = ictGpa;
    }



}
