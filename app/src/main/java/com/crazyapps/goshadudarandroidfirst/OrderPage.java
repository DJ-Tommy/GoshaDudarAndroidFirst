package com.crazyapps.goshadudarandroidfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.crazyapps.goshadudarandroidfirst.model.Course;
import com.crazyapps.goshadudarandroidfirst.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orderList = findViewById(R.id.orders_list);
        List<String> courseTitles = new ArrayList<>();
        for (Course course : MainActivity.fullCourseList) {
            if (Order.itemIds.contains(course.getId())) {
                courseTitles.add(course.getTitle());
            }
        }

        orderList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseTitles));

    }
}