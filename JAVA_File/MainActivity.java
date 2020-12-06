package com.example.final_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;

    private NoticeListAdapter adapter;

    private List<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("안녕하세요..","김지환","2020/11/26"));
        noticeList.add(new Notice("19학번 김지환입니다.","김지환","2020/11/27"));
        noticeList.add(new Notice("모바일 프로그래밍 수업","김지환","2020/11/28"));
        noticeList.add(new Notice("앱만들기가 괜찮은거 같습니다.","김지환","2020/11/29"));
        noticeList.add(new Notice("뜬금포가 있습니다.","김지환","2020/11/30"));
        noticeList.add(new Notice("저 21년도 휴학합니다.","김지환","2021/06/01"));
        noticeList.add(new Notice("그 이유는....","김지환","2021/06/02"));
        noticeList.add(new Notice("6월에 군입대확정입니다..","김지환","2021/06/03"));

        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);

        noticeListView.setAdapter(adapter);



        final Button courseButton = (Button) findViewById(R.id.courseButton);

        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);

        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);

        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);



        courseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notice.setVisibility(View.GONE);

                courseButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                statisticsButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                scheduleButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment, new CourseFragment());

                fragmentTransaction.commit();
            }
        });



        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notice.setVisibility(View.GONE);

                courseButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                statisticsButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                scheduleButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());

                fragmentTransaction.commit();
            }
        });


        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notice.setVisibility(View.GONE);

                courseButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                statisticsButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                scheduleButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());

                fragmentTransaction.commit();
            }
        });
        /*
        new BackgroundTask().execute();*/
    }
    /*
    //공지사항 서버 구축리

    abstract class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onnPreExecute()
        {
            target ="서버 주소";
        }

        @Override
        protected String doInBackground(Void voids)
        {
            try
            {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

    }

    @Override
    public void onProgressUpdate(Void values)
    {
        super.onProgressUpdate();
    }

    @Override
    public onPostExecute(String result)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String noticeContent, noticeName, noticeDate;
            while (count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                noticeContent = object.getString("noticeContent");
                noticeName = object.getString("noticeName");
                noticeDate = object.getString("noticeDate");
                Notice notice = new Notice(noticeContent, noticeName, noticeDate);
                noticeList.add(notice);
                count++;
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }*/
    //서버 구축 마무리



    private long lastTimeBackPressed;

    @Override
    public void onBackPressed()
    {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return;
        }
        Toast.makeText(this,"뒤로 버튼을 한 번더 누르세요.",Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();
    }
}