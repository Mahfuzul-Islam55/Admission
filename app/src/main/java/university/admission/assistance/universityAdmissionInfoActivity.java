package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class universityAdmissionInfoActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView
            ELIGIBLE_UNIVERSITY,
            ELIGIBLE_UNIT,
            APPLICATION_DEADLINE_CURRENT_UNIT,
            APPLICATION_BEGIN,
            APPLICATION_END,
            ADMIT_CURRENT_UNIT,
            ADMIT_BEGIN,
            ADMIT_END,
            EXAM_DEADLINE_CURRENT_UNIT,
            EXAM_DEADLINE,
            FEES_CURRENT_UNIT,
            FEES_TK;

    private Button APPLY_NOW;
    private ArrayList<universityUnitInformation>universityUnitInformations;
    private ArrayList<availableUniversityInformation>availableUniversityInformations;

    private int UNIVERSITY_LIST_INDEX_POSITION=0;
    private String ELIGBLE_UNIVERSITY_NAME;
    private String ELIGIBLE_ALL_UNIT="";
    private String TOTAL_UNIT;
    private String CURRENT_UNIT;
    private String APPLICATIONBEGIN;
    private String APPLICATIONEND;
    private String ADMITCARDBEGIN;
    private String ADMITCARDEND;
    private String EXAMDEADLINE;
    private String FEES;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_admission_info);

        allFunction();
    }
    private void allFunction(){
        university_ClickIndex();
       updateCurrentTimeAndDate();
       findAll();
       loadUnitInformation();
    }
    private void university_ClickIndex(){
        UNIVERSITY_LIST_INDEX_POSITION=Integer.parseInt(getIntent().getExtras().getString(Dbcontract.UNIVERSITY_LIST_INDEX_POSITION_KEY));
    }
    private void findAll(){

        ELIGIBLE_UNIVERSITY= this.<TextView>findViewById(R.id.universityProfileFullNameTextviewId);
        ELIGIBLE_UNIT= this.<TextView>findViewById(R.id.universityProfileEligileUnitTextviewId);
                APPLICATION_DEADLINE_CURRENT_UNIT=this.<TextView>findViewById(R.id.universityProfileAppDeadlineCurrentUnitNameTextviewId);
                APPLICATION_BEGIN=this.<TextView>findViewById(R.id.universityProfileAppBeginTextviewId);
                APPLICATION_END=this.<TextView>findViewById(R.id.universityProfileAppEndTextviewId);
                ADMIT_CURRENT_UNIT=this.<TextView>findViewById(R.id.universityProfileAdmitDeadlineCurrentUnitNameTextviewId);
                ADMIT_BEGIN=this.<TextView>findViewById(R.id.universityProfileAdmitBeginTextviewId);
                ADMIT_END=this.<TextView>findViewById(R.id.universityProfileAdmitEndTextviewId);
                EXAM_DEADLINE_CURRENT_UNIT=this.<TextView>findViewById(R.id.universityProfileExamDeadlineCurrentUnitNameTextviewId);
                EXAM_DEADLINE=this.<TextView>findViewById(R.id.universityProfileExamDealineTextviewId);
                FEES_CURRENT_UNIT=this.<TextView>findViewById(R.id.universityProfileFeesCurrentUnitTextviewId);
                FEES_TK=this.<TextView>findViewById(R.id.universityProfileFeesTkTextviewId);

                APPLY_NOW= this.<Button>findViewById(R.id.universityProfileApplyButtonTextviewId);
                APPLY_NOW.setOnClickListener(this);


    }
    private void loadUnitInformation(){

        availableUniversityInformations=Dbcontract.getAvailableUniversityInformationArrayList();
        availableUniversityInformation universityInformation=availableUniversityInformations.get(UNIVERSITY_LIST_INDEX_POSITION);

        ELIGBLE_UNIVERSITY_NAME=universityInformation.getUNIVERSITY_NAME();

        ArrayList<String>units=universityInformation.getUnitList();
        ELIGIBLE_ALL_UNIT="";
        for (int i=0;i<units.size();i++){
            ELIGIBLE_ALL_UNIT+=units.get(i)+" ";
        }


        universityUnitInformations=Dbcontract.getUniversityUnitInformations();
        if(universityUnitInformations==null){
            Toast.makeText(this,"Not receive unit information",Toast.LENGTH_SHORT).show();
            return;
        }

        if(universityUnitInformations.get(0)==null){
            Toast.makeText(this,"Not receive unit information",Toast.LENGTH_SHORT).show();
            return;
        }
        universityUnitInformation unitInformations=universityUnitInformations.get(0);

         TOTAL_UNIT=unitInformations.getUNIT_NAME();
         APPLICATIONBEGIN=unitInformations.getAPPLICATION_BEGIN();
         APPLICATIONEND=unitInformations.getAPPLICATION_END();
         ADMITCARDBEGIN=unitInformations.getADMIT_CARD_BEGIN();
         ADMITCARDEND=unitInformations.getADMIT_CARD_END();
         EXAMDEADLINE=unitInformations.getEXAM_DEADLINE();
         FEES=unitInformations.getFEES()+ "Tk";




         String temp="Application Begin:\n"+Dbcontract.getDate(APPLICATIONBEGIN)+"\n"+Dbcontract.getTime(APPLICATIONBEGIN);
         APPLICATIONBEGIN=temp;

        temp="Application End:\n"+Dbcontract.getDate(APPLICATIONEND)+"\n"+Dbcontract.getTime(APPLICATIONEND);
        APPLICATIONEND=temp;

        temp="Admit Download Begin:\n"+Dbcontract.getDate(ADMITCARDBEGIN)+"\n"+Dbcontract.getTime(ADMITCARDBEGIN);
        ADMITCARDBEGIN=temp;

        temp="Admit Download End:\n"+Dbcontract.getDate(ADMITCARDEND)+"\n"+Dbcontract.getTime(ADMITCARDEND);
        ADMITCARDEND=temp;

        temp="Exam Date:Time:\n"+Dbcontract.getDate(EXAMDEADLINE)+"\n"+Dbcontract.getTime(EXAMDEADLINE);
        EXAMDEADLINE=temp;




         //TEMPORARY (WE WILL USE LIST VIEW OF ALL UNITS)
        StringTokenizer st = new StringTokenizer(ELIGIBLE_ALL_UNIT," ");
        if (st.hasMoreTokens()) {

            CURRENT_UNIT ="Unit: "+st.nextToken();
        }

                ELIGIBLE_UNIVERSITY.setText(ELIGBLE_UNIVERSITY_NAME);
                ELIGIBLE_UNIT.setText("Eligible units: "+ELIGIBLE_ALL_UNIT);
                APPLICATION_DEADLINE_CURRENT_UNIT.setText(CURRENT_UNIT);
                APPLICATION_BEGIN.setText(APPLICATIONBEGIN);
                APPLICATION_END.setText(APPLICATIONEND);
                ADMIT_CURRENT_UNIT.setText(CURRENT_UNIT);
                ADMIT_BEGIN.setText(ADMITCARDBEGIN);
                ADMIT_END.setText(ADMITCARDEND);
                EXAM_DEADLINE_CURRENT_UNIT.setText(CURRENT_UNIT);
                EXAM_DEADLINE.setText(EXAMDEADLINE);
                FEES_CURRENT_UNIT.setText(CURRENT_UNIT);
                FEES_TK.setText(FEES);


    }
    private void updateCurrentTimeAndDate(){
        Thread timeAndDate=new Thread(){
            @Override
            public void run() {
                try {
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate=(TextView)findViewById(R.id.currentDateAndTimeId);
                                long date=System.currentTimeMillis();
                                SimpleDateFormat sdf=new SimpleDateFormat("dd MMM,yyyy\nhh:mm:ss a");
                                String dateString=sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        timeAndDate.start();
    }

    @Override
    public void onClick(View view) {
        long id=view.getId();
        if(id==R.id.universityProfileApplyButtonTextviewId){
            loadUnitInformation();
        }
    }
}
