package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class universityListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private universityListActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_list);

        context=this;
        loadAll();
    }
    private void loadAll(){
        findAll();
        loadCustomListViewAdapter();
    }
    private void findAll(){
        listView= this.<ListView>findViewById(R.id.applicableUniversityListViewId);
        listView.setOnItemClickListener(this);
    }
    private void loadCustomListViewAdapter(){
        customListViewAdapter adapter=new customListViewAdapter(this);
        listView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Object obj=listView.getItemAtPosition(position);

        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

        if(checkNetworkConnection()==false) {
            Dbcontract.Alert(context,"Network Connectivity:","Connect to Internet");
            return;
        }

        //download each university other information
        if(Dbcontract.getAvailableUniversityInformationArrayList().get(position)!=null){

            availableUniversityInformation universityList=Dbcontract.getAvailableUniversityInformationArrayList().get(position);

            String UNIVERSITY_ID=universityList.getUNIVERSITY_ID();

            Dbcontract.getUniversityAdmissionInformation(this,UNIVERSITY_ID);

        }

    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager= (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        return (networkInfo!=null && networkInfo.isConnected());

    }

}
