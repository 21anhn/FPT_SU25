package com.anhtlnse170476.lab3;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Lab31Activity extends BaseActivity {
    private ListView lvList;
    private List<String> items;
    private ArrayAdapter<String> adapter;
    private EditText etInput;
    private AppCompatButton btnAdd;
    private AppCompatButton btnUpdate;
    private AppCompatButton btnDelete;
    private AtomicLong index = new AtomicLong(-1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31);
        setHeaderTitle("Lab 3.1 - List View");

        setupNavigation(MainActivity.class, Lab32Activity.class);

        init();

        onItemClick();
        onAddItem();
        onUpdateItem();
        onDeleteItem();
    }

    private void init() {
        items = new ArrayList<>();
        items.add("Android");
        items.add("PHP");
        items.add("IOS");
        items.add("Unity");
        items.add("ASP.NET");

        lvList = findViewById(R.id.lvList);
        etInput = findViewById(R.id.etInput);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvList.setAdapter(adapter);
    }

    private void checkInputText(String text, String type) {
        if (text.isEmpty()) {
            if (type.equalsIgnoreCase("Add"))
                Toast.makeText(this, "Hãy nhập tên khóa!", LENGTH_SHORT).show();
            else if (type.equalsIgnoreCase("Update"))
                Toast.makeText(this, "Hãy chọn tên khóa để cập nhật!", LENGTH_SHORT).show();
            else Toast.makeText(this, "Hãy chọn tên khóa để xóa!", LENGTH_SHORT).show();
        }

    }

    private void onAddItem() {
        btnAdd.setOnClickListener((v) -> {
            var text = etInput.getText().toString();

            checkInputText(text, "Add");

            items.add(text);
            adapter.notifyDataSetChanged();
            etInput.setText("");
        });
    }

    private void onUpdateItem() {
        btnUpdate.setOnClickListener(v -> {
            int pos = (int) index.get();

            if (pos == -1) {
                Toast.makeText(this, "Hãy chọn item để cập nhật!", Toast.LENGTH_SHORT).show();
                return;
            }

            String newText = etInput.getText().toString();
            checkInputText(newText, "Update");

            items.set(pos, newText);
            adapter.notifyDataSetChanged();
            etInput.setText("");
            index.set(-1);
        });
    }

    private void onDeleteItem() {
        btnDelete.setOnClickListener((v) -> {
            int pos = (int) index.get();

            if (pos == -1) {
                Toast.makeText(this, "Hãy chọn item để xóa!", Toast.LENGTH_SHORT).show();
                return;
            }

            items.remove(pos);
            adapter.notifyDataSetChanged();
            etInput.setText("");
        });
    }

    private void onItemClick() {
        lvList.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = items.get(position);
            etInput.setText(clickedItem);
            index.set(position);
        });
    }
}
