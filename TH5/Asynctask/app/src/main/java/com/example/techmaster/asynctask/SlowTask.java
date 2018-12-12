package com.example.techmaster.asynctask;

import android.app.ProgressDialog;
import android.content.Context;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class SlowTask extends AsyncTask<String, Long, Void> {

    private ProgressDialog pbwaiting;
    private Context context;
    private long startTime;
    private TextView tvStatus;

    public SlowTask(Context context, TextView tvStatus){
        this.context = context;
        this.tvStatus = tvStatus;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try{
            for (Long i = 0L; i < 3L; i++){
                Thread.sleep(2000);
                publishProgress((Long) i);
            }
        }
        catch (Exception e){
            Log.e("SlowJob", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        pbwaiting = new ProgressDialog(context);
        startTime = System.currentTimeMillis();
        tvStatus.setText("Start time: " + startTime);
        pbwaiting.setMessage(context.getString(R.string.please_wait));
        pbwaiting.show();
    }

    @Override
    protected void onProgressUpdate(Long... values){
        super.onProgressUpdate(values);
        tvStatus.append("\nWorking..." + values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);

        if(pbwaiting.isShowing()) pbwaiting.dismiss();

        tvStatus.append("\nEnd Time: " + System.currentTimeMillis());
        tvStatus.append("\nDone");
    }
}
