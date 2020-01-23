package university.admission.assistance;

import java.util.ArrayList;

public class Dbcontract {

    public static String BACKGROUND="background";
    public static String
            SCIENCE="science",
            COMMERCE="commerce",
            ARTS="humanStudies";

    public static String SSC_YEAR="sscYear";
    public static String SSC_GPA="sscGpa";
    public static String HSC_YEAR="hscYear";
    public static String HSC_GPA="hscGpa";


    //STUDENT information for "SCIENCE" ONLY

    public static String PHYSICSGPA="physicsGpa";
    public static String CHEMISTRYGPA="chemistryGpa";
    public static String HIGHER_MATHGPA="higherMathGpa";
    public static String BIOLOGYGPA="biologyGpa";
    public static String BANGLAGPA="banglaGpa";
    public static String ENGLISHGPA="englishGpa";
    public static String ICTGPA="ictGpa";

    //STUDENT information for "COMMERCE" only


    //STUDENT information for "ARTS" only





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


    public static String CHECK_UNIVERSITIES="checkAvailableUniversities";
    public static String UNIVERSITY_INFORMATION="universityAllInformation";
    public static String CHECK_UNIVERSITIES_URL="http://192.168.0.104/www/admissionAssistance/CheckAvailableUniversity.php";
    public static String UNIVERSITY_INFORMATION_URL="";

    private static ArrayList<availableUniversityInformation>availableUniversityInformationArrayList;

    public static void setAvailableUniversityInformationArrayList(ArrayList<availableUniversityInformation> availableUniversityInformationArrayList) {
        Dbcontract.availableUniversityInformationArrayList = availableUniversityInformationArrayList;
    }
    //getter and setter of above

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
