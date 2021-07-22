package com.crazyapps.goshadudarandroidfirst;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crazyapps.goshadudarandroidfirst.adapter.CategoryAdapter;
import com.crazyapps.goshadudarandroidfirst.adapter.CourseAdapter;
import com.crazyapps.goshadudarandroidfirst.model.Category;
import com.crazyapps.goshadudarandroidfirst.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category (1,"Игры"));
        categoryList.add(new Category (2,"Сайты"));
        categoryList.add(new Category (3,"Языки"));
        categoryList.add(new Category (4,"Прочее"));

        setCategoryRecycler(categoryList);

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "31 февраля", "начальный", "#424345"));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "31 февраля", "начальный", "#9FA52D"));

        setCourseRecycler(courseList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

}