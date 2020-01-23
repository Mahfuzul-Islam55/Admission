package university.admission.assistance;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dbcontract {


    public static String CHECK_UNIVERSITIES="checkAvailableUniversities";
    public static String CHECK_UNIVERSITIES_URL="http://10.100.161.240/www/admissionAssistance/CheckAvailableUniversity.php";
    public static String UNIVERSITY_INFORMATION="universityAllInformation";
    public static String UNIVERSITY_INFORMATION_URL="http://10.100.161.240/www/admissionAssistance/getUniversityUnitInformation.php";

    public static String UNIVERSITY_ID="university_id";
    public static String UNIT="unit";
    public static String BACKGROUND="background";
    public static String UNIVERSITY_LIST_INDEX_POSITION_KEY="position";

    public static String
            SCIENCE="science",
            COMMERCE="commerce",
            ARTS="humanStudies";

    public static String CURRENT_BACKGROUND=SCIENCE;

    public String getCURRENT_BACKGROUND() {
        return CURRENT_BACKGROUND;
    }

    public void setCURRENT_BACKGROUND(String CURRENT_BACKGROUND) {
        this.CURRENT_BACKGROUND = CURRENT_BACKGROUND;
    }



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


    private static ArrayList<universityUnitInformation>universityUnitInformations;

    public static ArrayList<universityUnitInformation> getUniversityUnitInformations() {
        return universityUnitInformations;
    }

    public static void setUniversityUnitInformations(ArrayList<universityUnitInformation> universityUnitInformations) {
        Dbcontract.universityUnitInformations = universityUnitInformations;
    }

    private static ArrayList<availableUniversityInformation>availableUniversityInformationArrayList;

    public static ArrayList<availableUniversityInformation> getAvailableUniversityInformationArrayList() {
        return availableUniversityInformationArrayList;
    }

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


    //ALERT SECTION
    public static AlertDialog alertDialog;
    public static void Alert(Context ctx, String title, String text){

        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(text);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.cancel();
            }
        });

        alertDialog.show();

    }
    //EXECUTE SECTION

    public static void getUniversityAdmissionInformation(Context context,String UNIVERSITY_ID,String UNIT_NAME){

        if(checkNetworkConnection(context)){

            String method=UNIVERSITY_INFORMATION;
            BackgroundTask backgroundTask=new BackgroundTask(context,CURRENT_BACKGROUND);
            backgroundTask.execute(method,UNIVERSITY_ID,UNIT_NAME);
        }
        else Dbcontract.Alert(context,"Network Connection","Check Internet Connection");

    }
    public static boolean checkNetworkConnection(Context context){

        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        return (networkInfo!=null && networkInfo.isConnected());

    }
    public static String getDate(String date){
        String YEAR="",
                MONTH="",
                DAY="";
        String FINAL_DATE="";

        StringTokenizer st = new StringTokenizer(date,"- :");
        if(st.hasMoreTokens()) {

            YEAR=st.nextToken();
        }
        if(st.hasMoreTokens()) {

            MONTH=st.nextToken();
        }
        if(st.hasMoreTokens()) {

            DAY=st.nextToken();
        }

        FINAL_DATE=DAY+" "+Dbcontract.MONTHS[Integer.parseInt(MONTH)]+","+YEAR;

        return FINAL_DATE;

    }
    public static String getTime(String time){

        String temp="";

        StringTokenizer st = new StringTokenizer(time,"- :");
        if(st.hasMoreTokens()) {

            temp=st.nextToken();
        }
        if(st.hasMoreTokens()) {

            temp=st.nextToken();
        }
        if(st.hasMoreTokens()) {

            temp=st.nextToken();
        }


        String HOUR="",
                MIN="",
                SECOND="";
        String FINAL_TIME="";
        String NIGHT="AM";
        String DAY="PM";
        String AM_PM=DAY;
//        StringTokenizer st = new StringTokenizer(time,":");
        if(st.hasMoreTokens()) {

            HOUR=st.nextToken();
            int Hour=Integer.parseInt(HOUR);

            if(Hour==0){
                Hour=12;
                AM_PM=NIGHT;
            }
            else if(Hour-12<0){
                Hour=Hour;
                AM_PM=NIGHT;

            }
            else if(Hour-12==0){
                Hour=12;
                AM_PM=DAY;
            }
            else {
                Hour=Hour-12;
                AM_PM=DAY;
            }

            HOUR=Integer.toString(Hour);

        }
        if(st.hasMoreTokens()) {

            MIN=st.nextToken();
        }
        if(st.hasMoreTokens()) {

            SECOND=st.nextToken();
        }



        FINAL_TIME+=HOUR+":"+MIN+":"+SECOND+" "+AM_PM;

        return FINAL_TIME;

    }
    public static String[] MONTHS={"NULL","JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};

    //ERROR SECTION
    public static String URl_ERROR="Not found url";
    public static String Query_ERROR="Unsuccessful Query on Database";
    public static String SERVER_ERROR="Server is not running";


}
