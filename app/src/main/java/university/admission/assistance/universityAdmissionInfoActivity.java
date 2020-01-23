package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class universityAdmissionInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_admission_info);

        allFunction();
    }
    private void allFunction(){
       updateCurrentTimeAndDate();
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
                                SimpleDateFormat sdf=new SimpleDateFormat("MMM dd yyyy\nhh-mm-ss a");
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
}
