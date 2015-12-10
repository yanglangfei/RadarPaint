package com.ylf.jucaipen.radarpaint.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.ylf.jucaipen.radarpaint.R;
import com.ylf.jucaipen.radarpaint.entity.Student;
import net.tsz.afinal.FinalDb;
import java.util.List;
/**
 * Created by Administrator on 2015/12/10.
 *
 *  afinal
 */
public class Test2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        FinalDb db=FinalDb.create(this);
        db.deleteById(Student.class,10);
     //   db.deleteAll(Student.class);
      /*  Student student=new Student();
        for(int i=0;i<100;i++){
            student.setId(i);
            student.setNo(i + 1);
            student.setSex(0);
            student.setName("uName" + i);
            student.setAddress("上海" + i);
            db.save(student);
        }*/
        List<Student> students = db.findAll(Student.class);
        if(students!=null&&students.size()>0){
            for(Student s :students){
                Log.i("111","id:"+s.getId()+" No:"+s.getNo()+" Name:"+s.getName()+" sex:"+s.getSex() +"address:"+s.getAddress()+"\n");
            }

        }
       /* FinalHttp http=new FinalHttp();
        http.get("", new AjaxCallBack<String>() {

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
            }
        });
        AsyncHttpClient client=new AsyncHttpClient();
        client.get("", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });*/

    }
}
