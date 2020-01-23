package university.admission.assistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class customListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<availableUniversityInformation>universityList;

    public customListViewAdapter(Context context){
        this.context=context;
        universityList=Dbcontract.getAvailableUniversityInformationArrayList();
    }
    @Override
    public int getCount() {

        return universityList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if(convertview==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflater.inflate(R.layout.university_list_view,parent,false);
        }
        ImageView universityImage=convertview.findViewById(R.id.universityImageViewId);
        TextView RANK_textview=convertview.findViewById(R.id.universityRankId);
        TextView UNIVERSITY_FULL_NAME_textview=convertview.findViewById(R.id.universityFullNameTextviewId);
        TextView UNIT_textview=convertview.findViewById(R.id.applicableUnitId);

        availableUniversityInformation university= universityList.get(position);

        String UNIVERSITY_RANK=university.getUNIVERSITY_ID();
        String FULLNAME=university.getUNIVERSITY_NAME();
        String UNIT="";
        ArrayList units=university.getUnitList();
        for(int i=0;i<units.size();i++){
            UNIT+=units.get(i)+" ";
        }
        RANK_textview.setText(UNIVERSITY_RANK);//university_id

        Integer rank=Integer.parseInt(UNIVERSITY_RANK);
        if(rank<Dbcontract.UNIVERSITY_IMAGE.length)
            universityImage.setImageResource(Dbcontract.UNIVERSITY_IMAGE[rank]);

        UNIVERSITY_FULL_NAME_textview.setText(FULLNAME);
        UNIT_textview.setText(UNIT);



        return convertview;
    }
}