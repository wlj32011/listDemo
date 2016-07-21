package cn.boc.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //初始化控件
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        //设置显示方式-线性列表方式展示
        list.setLayoutManager(new LinearLayoutManager(this));

        //初始化适配器
        MyAdapter myAdapter = new MyAdapter(this,initTestData());

        //RecyclerView设置适配器
        list.setAdapter(myAdapter);

    }

    /**
     * 初始化一组测试数据
     *
     * @return 测试数据List
     */
    private List<HashMap<String,String>> initTestData(){

        List<HashMap<String,String>> dataList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            HashMap<String,String> map = new HashMap<>();
            map.put("content","这是一条测试内容"+i);
            dataList.add(map);
        }

        return  dataList;
    }
}
