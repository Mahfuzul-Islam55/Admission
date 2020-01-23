package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class student extends AppCompatActivity implements View.OnClickListener {
    private String BACKGROUND="";
    private String SCIENCE="science",COMMERCE="commerce",ARTS="humanstudies";
    private String BACKGROUND_KEY="background";
    private Button checkUniversities;

    //student information from edit text for ALL
    private EditText SSC_PASS_YEAR;
    private EditText SSC_MIN_GPA;
    private EditText HSC_PASS_YEAR;
    private EditText HSC_MIN_GPA;

    //STUDENT information for "SCIENCE" ONLY

    private EditText PHYSICS_GPA;
    private EditText CHEMISTRY_GPA;
    private EditText HIGHER_MATH_GPA;
    private EditText BIOLOGY_GPA;
    private EditText BANGLA_GPA;
    private EditText ENGLISH_GPA;
    private EditText ICT_GPA;

    //STUDENT information for "COMMERCE" only


    //STUDENT information for "ARTS" only





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BACKGROUND=getIntent().getExtras().getString(BACKGROUND_KEY);
        if(BACKGROUND.equals(SCIENCE)){

            setContentView(R.layout.activity_student_science);
        }
        else if(BACKGROUND.equals(COMMERCE)){
            setContentView(R.layout.activity_student_commerce);
        }
        else if(BACKGROUND.equals(ARTS)){
            setContentView(R.layout.activity_student_arts);
        }

        loadAll();
    }
    private void loadAll(){
        findAllEditText();

    }
    private void findAllEditText(){
        SSC_PASS_YEAR= this.<EditText>findViewById(R.id.sscPassingYearId);
        SSC_MIN_GPA=this.<EditText>findViewById(R.id.sscGpaId);
        HSC_PASS_YEAR=this.<EditText>findViewById(R.id.hscPassingYearId);
        HSC_MIN_GPA=this.<EditText>findViewById(R.id.hscGpaId);

        checkUniversities= this.<Button>findViewById(R.id.checkUniversitiesButtonId);
        checkUniversities.setOnClickListener(this);



    }
    private boolean getStudentAllInformation(){

        try {
            Dbcontract.setSscPassYear(Double.parseDouble(SSC_PASS_YEAR.getText().toString()));
            Dbcontract.setSscMinGpa(Double.parseDouble(SSC_MIN_GPA.getText().toString()));
            Dbcontract.setHscPassYear(Double.parseDouble(HSC_PASS_YEAR.getText().toString()));
            Dbcontract.setHscMinGpa(Double.parseDouble(HSC_MIN_GPA.getText().toString()));

            if(BACKGROUND.equals(SCIENCE)){
                PHYSICS_GPA=this.<EditText>findViewById(R.id.physicsEditTextId);
                CHEMISTRY_GPA=this.<EditText>findViewById(R.id.chemistryEditTextId);
                HIGHER_MATH_GPA=this.<EditText>findViewById(R.id.higherMathEditTextId);
                BIOLOGY_GPA=this.<EditText>findViewById(R.id.biologyEditTextId);
                BANGLA_GPA=this.<EditText>findViewById(R.id.banglaEditTextId);
                ENGLISH_GPA=this.<EditText>findViewById(R.id.englishEditTextId);
                ICT_GPA=this.<EditText>findViewById(R.id.ictEditTextId);


                Dbcontract.setPhysicsGpa(Double.parseDouble(PHYSICS_GPA.getText().toString()));
                Dbcontract.setChemistryGpa(Double.parseDouble(CHEMISTRY_GPA.getText().toString()));
                Dbcontract.setHigherMathGpa(Double.parseDouble(HIGHER_MATH_GPA.getText().toString()));
                Dbcontract.setBiologyGpa(Double.parseDouble(BIOLOGY_GPA.getText().toString()));
                Dbcontract.setBanglaGpa(Double.parseDouble(BANGLA_GPA.getText().toString()));
                Dbcontract.setEnglishGpa(Double.parseDouble(ENGLISH_GPA.getText().toString()));
                Dbcontract.setIctGpa(Double.parseDouble(ICT_GPA.getText().toString()));


                if(Dbcontract.getSscPassYear()!=0.0 &&
                        Dbcontract.getSscMinGpa()!=0.0 &&
                        Dbcontract.getHscPassYear()!=0.0 &&
                        Dbcontract.getHscMinGpa()!=0.0 &&
                        Dbcontract.getPhysicsGpa()!=0.0 &&
                        Dbcontract.getChemistryGpa()!=0.0 &&
                        Dbcontract.getHigherMathGpa()!=0.0 &&
                        Dbcontract.getBiologyGpa()!=0.0 &&
                        Dbcontract.getBanglaGpa()!=0.0 &&
                        Dbcontract.getEnglishGpa()!=0.0 &&
                        Dbcontract.getIctGpa()!=0.0

                ) return true;



            }
            else if(BACKGROUND.equals(COMMERCE)){

            }
            else if(BACKGROUND.equals(ARTS)){

            }

        }catch (Exception e){
            Toast.makeText(this,"Carefully input your Information",Toast.LENGTH_SHORT).show();
        }



        return  false;


    }



    @Override
    public void onClick(View view) {
        long id=view.getId();
        if(id==R.id.checkUniversitiesButtonId){
            if(getStudentAllInformation()){
                Toast.makeText(this,"All Fielded up",Toast.LENGTH_SHORT).show();

                String method=Dbcontract.CHECK_UNIVERSITIES;
                BackgroundTask backgroundTask=new BackgroundTask(this,Dbcontract.SCIENCE);
                backgroundTask.execute(method);

            }
            else  Toast.makeText(this,"All Field Not get information",Toast.LENGTH_SHORT).show();



        }
    }
}
