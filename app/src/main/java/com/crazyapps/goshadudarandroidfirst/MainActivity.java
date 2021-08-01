package com.crazyapps.goshadudarandroidfirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crazyapps.goshadudarandroidfirst.adapter.CategoryAdapter;
import com.crazyapps.goshadudarandroidfirst.adapter.CourseAdapter;
import com.crazyapps.goshadudarandroidfirst.model.Category;
import com.crazyapps.goshadudarandroidfirst.model.Course;
import com.crazyapps.goshadudarandroidfirst.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(0, "Все"));
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "31 февраля", "начальный", "#424345", "text", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "32 февраля", "начальный", "#9FA52D", "text", 3));
        courseList.add(new Course(3, "unity", "Профессия Unity\nразработчик", "33 февраля", "начальный", "#65173D", "text", 1));
        courseList.add(new Course(4, "front_end", "Профессия Front-end\nразработчик", "34 февраля", "начальный", "#B04935", "text", 2));
        courseList.add(new Course(5, "back_end", "Профессия Back-end\nразработчик", "35 февраля", "начальный", "#2D55A5", "text", 2));
        courseList.add(new Course(6, "full_stack", "Профессия Full Stack\nразработчик", "36 февраля", "усредненный", "#FFC007", "text", 2));
        fullCourseList.addAll(courseList);
        setCourseRecycler(courseList);
    }

    public void openCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
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

    public static void showCoursesByCategory(int category) {
        courseList.clear();
        if (category == 0) {
            courseList.addAll(fullCourseList);
        } else {
            for (Course course : fullCourseList) {
                if (course.getCategory() == category) {
                    courseList.add(course);
                }
            }
        }
        courseAdapter.notifyDataSetChanged();
    }

}