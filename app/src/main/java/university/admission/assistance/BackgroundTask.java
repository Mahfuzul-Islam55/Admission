package university.admission.assistance;

import android.content.Context;
import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    BackgroundTask(Context ctx){

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}


