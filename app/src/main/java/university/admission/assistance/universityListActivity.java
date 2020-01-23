package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
            String ELIGBLE_UNIT="";

            ArrayList<String>ALL_UNIT=new ArrayList<>();
            ALL_UNIT=universityList.getUnitList();
            for(int i=0;i<ALL_UNIT.size();i++){
                ELIGBLE_UNIT+=ALL_UNIT.get(i)+" ";
            }

            String UNIT_NAME="";

            StringTokenizer st = new StringTokenizer(ELIGBLE_UNIT," ");
            if (st.hasMoreTokens()) {
                UNIT_NAME =st.nextToken();
            }

            Dbcontract.getUniversityAdmissionInformation(this,UNIVERSITY_ID,UNIT_NAME);

            //NEW ACTIVITY START
            Intent intent=new Intent(this,universityAdmissionInfoActivity.class);
            intent.putExtra(Dbcontract.UNIVERSITY_LIST_INDEX_POSITION_KEY,Integer.toString(position));
            startActivity(intent);

        }

    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager= (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        return (networkInfo!=null && networkInfo.isConnected());

    }

}
