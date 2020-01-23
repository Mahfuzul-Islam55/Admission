package university.admission.assistance;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    private Context ctx;
    private String BACKGROUND="";


    BackgroundTask(Context ctx,String BACKGROUND){
        this.ctx=ctx;
        this.BACKGROUND=BACKGROUND;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method=params[0];


        if(method.equals(Dbcontract.CHECK_UNIVERSITIES)){

            ArrayList<availableUniversityInformation>universityList=new ArrayList<>();

            if(BACKGROUND.equals(Dbcontract.SCIENCE)){
                try {
                    URL url=new URL(Dbcontract.CHECK_UNIVERSITIES_URL);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data=
                            URLEncoder.encode(Dbcontract.BACKGROUND,"UTF-8")+"="+URLEncoder.encode(Dbcontract.SCIENCE,"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.SSC_YEAR,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getSscPassYear()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.SSC_GPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getSscMinGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.HSC_YEAR,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getHscPassYear()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.HSC_GPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getHscMinGpa()),"UTF-8")+"&"+

                                    URLEncoder.encode(Dbcontract.PHYSICSGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getPhysicsGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.CHEMISTRYGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getChemistryGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.HIGHER_MATHGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getHigherMathGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.BIOLOGYGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getBiologyGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.BANGLAGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getBanglaGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.ENGLISHGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getEnglishGpa()),"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.ICTGPA,"UTF-8")+"="+URLEncoder.encode(Double.toString(Dbcontract.getIctGpa()),"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream is=httpURLConnection.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    StringBuilder sb=new StringBuilder();
                    String line=null;
                    while ((line=br.readLine())!=null){
                        sb.append(line+"\n");
                    }
                    is.close();
                    String result=sb.toString();

                    JSONArray ja=new JSONArray(result);
                    JSONObject jo=null;

                    for(int i=0;i<ja.length();i++){

                        availableUniversityInformation university=new availableUniversityInformation();

                        jo=ja.getJSONObject(i);
                        final String UNIVERSITY_ID=jo.getString("university_id");
                        final String UNIVERSITY_NAME=jo.getString("fullName");
                        final String UNIT=jo.getString("unit");
                       // System.out.println(UNIT+"\n");

                        boolean university_exist=false;
                        for (int j=0;j<universityList.size();j++){

                            availableUniversityInformation temp_university=universityList.get(j);
                            if(temp_university.getUNIVERSITY_ID().equals(UNIVERSITY_ID)){
                                universityList.get(j).getUnitList().add(UNIT);
                                university_exist=true;
                                break;
                            }

                        }

                        if(university_exist==false){
                            university.setUNIVERSITY_ID(UNIVERSITY_ID);
                            university.setUNIVERSITY_NAME(UNIVERSITY_NAME);

                            ArrayList<String> unit=new ArrayList<>();
                            unit.add(UNIT);
                            university.setUnitList(unit);

                            universityList.add(university);

                        }

                    }

               Dbcontract.setAvailableUniversityInformationArrayList(universityList);

                   /* for (int j=0;j<universityList.size();j++){
                        availableUniversityInformation temp_university=universityList.get(j);
                        System.out.println(temp_university.getUNIVERSITY_NAME());
                        System.out.println(temp_university.getUNIVERSITY_ID());
                        ArrayList<String>unit=new ArrayList<>();
                        unit=temp_university.getUnitList();

                        for(int k=0;k<unit.size();k++)
                        System.out.println(unit.get(k));

                    }*/

                    //Applicable university information is collected successfully

                    //showing on list view
                    Intent intent=new Intent(ctx,universityListActivity.class);
                    ctx.startActivity(intent);






                } catch (MalformedURLException e) {

                    e.printStackTrace();
                    return Dbcontract.URl_ERROR;

                }catch (JSONException e){
                    e.printStackTrace();
                    return Dbcontract.Query_ERROR;

                } catch (Exception e) {
                    e.printStackTrace();
                    return Dbcontract.SERVER_ERROR;
                }
            }
            else if(BACKGROUND.equals(Dbcontract.COMMERCE)){

            }
            else if(BACKGROUND.equals(Dbcontract.ARTS)){

            }


        }
        else if(method.equals(Dbcontract.UNIVERSITY_INFORMATION)){

            String UNIVERSITYID=params[1];
            String UNIT_NAME=params[2];

            if(BACKGROUND.equals(Dbcontract.SCIENCE)){
                try {
                    URL url=new URL(Dbcontract.UNIVERSITY_INFORMATION_URL);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data=
                            URLEncoder.encode(Dbcontract.UNIVERSITY_ID,"UTF-8")+"="+URLEncoder.encode(UNIVERSITYID,"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.BACKGROUND,"UTF-8")+"="+URLEncoder.encode(Dbcontract.CURRENT_BACKGROUND,"UTF-8")+"&"+
                                    URLEncoder.encode(Dbcontract.UNIT,"UTF-8")+"="+URLEncoder.encode(UNIT_NAME,"UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.close();
                    bufferedWriter.flush();
                    outputStream.close();

                    InputStream is=httpURLConnection.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    StringBuilder sb=new StringBuilder();
                    String line=null;
                    while ((line=br.readLine())!=null){
                        sb.append(line+"\n");
                    }
                    is.close();
                    String result=sb.toString();

                    JSONArray ja=new JSONArray(result);
                    JSONObject jo=null;

                    for(int i=0;i<ja.length();i++){


                        jo=ja.getJSONObject(i);
                        final String UNIVERSITY_ID=jo.getString("university_id");
                        final String UNIVERSITY_NAME=jo.getString("fullName");
                        final String UNIT=jo.getString("unit");
                        // System.out.println(UNIT+"\n");



                    }








                } catch (MalformedURLException e) {

                    e.printStackTrace();
                    return Dbcontract.URl_ERROR;

                }catch (JSONException e){
                    e.printStackTrace();
                    return Dbcontract.Query_ERROR;

                } catch (Exception e) {
                    e.printStackTrace();
                    return Dbcontract.SERVER_ERROR;
                }
            }
            else if(BACKGROUND.equals(Dbcontract.COMMERCE)){

            }
            else if(BACKGROUND.equals(Dbcontract.ARTS)){

            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String message) {

        Toast.makeText(ctx,message,Toast.LENGTH_SHORT).show();

    }
}


