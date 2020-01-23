package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.StringTokenizer;

public class homeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button scienceButton,commerceButton,artsButton,loginButton,signUpButton,universityProfileButton;
    private String SCIENCE="science",COMMERCE="commerce",ARTS="humanStudies";
    private String BACKGROUND_KEY="background";
    private double n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        allFunction();

    }
    private void allFunction(){
        allFind();
    }
    private void allFind(){
        scienceButton=findViewById(R.id.scienceButtonId);
        commerceButton=findViewById(R.id.commerceButtonId);
        artsButton=findViewById(R.id.artsButtonId);
        universityProfileButton=findViewById(R.id.universityProfileId);

        scienceButton.setOnClickListener(this);
        commerceButton.setOnClickListener(this);
        artsButton.setOnClickListener(this);
        universityProfileButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        long id=view.getId();
        if(id==R.id.scienceButtonId){
            Dbcontract.CURRENT_BACKGROUND=SCIENCE;

            Intent intent= new Intent(homeActivity.this,student.class);
            intent.putExtra(BACKGROUND_KEY,SCIENCE);
            startActivity(intent);

            Toast.makeText(this,"Science Background",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.commerceButtonId){
            Dbcontract.CURRENT_BACKGROUND=COMMERCE;
            Intent intent= new Intent(homeActivity.this,student.class);
            intent.putExtra(BACKGROUND_KEY,COMMERCE);
            startActivity(intent);
            Toast.makeText(this,"Commerce Background",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.artsButtonId){
            Dbcontract.CURRENT_BACKGROUND=ARTS;
            Intent intent= new Intent(homeActivity.this,student.class);
            intent.putExtra(BACKGROUND_KEY,ARTS);
            startActivity(intent);
            Toast.makeText(this,"Arts Background",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.universityProfileId){
            Intent intent= new Intent(homeActivity.this,universityAdmissionInfoActivity.class);
            intent.putExtra(BACKGROUND_KEY,ARTS);
            startActivity(intent);
            Toast.makeText(this,"University profile",Toast.LENGTH_SHORT).show();
        }


    }
}
