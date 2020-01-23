package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class student extends AppCompatActivity {
    private String BACKGROUND="";
    private String SCIENCE="science",COMMERCE="commerce",ARTS="arts";
    private String BACKGROUND_KEY="background";

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
    }
}
