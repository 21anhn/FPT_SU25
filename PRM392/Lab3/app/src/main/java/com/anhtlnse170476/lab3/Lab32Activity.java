package com.anhtlnse170476.lab3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;

public class Lab32Activity extends BaseActivity {
    private ListView lvFruits;
    private FruitAdapter adapter;
    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab32);
        setHeaderTitle("Lab 3.2 - Custom List View");
        setupNavigation(Lab31Activity.class, null);

        initViews();
        initData();

        adapter = new FruitAdapter(this, R.layout.item_fruit, fruits);
        lvFruits.setAdapter(adapter);

        lvFruits.setOnItemLongClickListener((parent, view, position, id) -> {
            showEditDeleteDialog(position);
            return true;
        });

        lvFruits.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            showAddOrEditDialog(fruits.get((selectedIndex)), selectedIndex);
        });
    }


    private AppCompatButton btnAdd, btnEdit, btnDelete;
    private int selectedIndex = -1;

    private void initViews() {
        lvFruits = findViewById(R.id.lvFruits);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        lvFruits.setOnItemClickListener((parent, view, position, id) -> selectedIndex = position);

        btnAdd.setOnClickListener(v -> showAddOrEditDialog(null, -1));
        btnEdit.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                showAddOrEditDialog(fruits.get(selectedIndex), selectedIndex);
            } else {
                Toast.makeText(this, "Vui lòng chọn mục để sửa", Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                confirmDelete(selectedIndex);
                selectedIndex = -1;
            } else {
                Toast.makeText(this, "Vui lòng chọn mục để xoá", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initData() {
        fruits = new ArrayList<>();
        fruits.add(new Fruit("Chuối tiêu", "Chuối tiêu Long An", "https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg"));
        fruits.add(new Fruit("Thanh Long", "Thanh long ruột đỏ", "https://upload.wikimedia.org/wikipedia/commons/e/e3/Pitaya_cross_section_ed2.jpg"));
        fruits.add(new Fruit("Dâu tây", "Dâu tây Đà Lạt", "https://upload.wikimedia.org/wikipedia/commons/2/29/PerfectStrawberry.jpg"));
        fruits.add(new Fruit("Dưa hấu", "Dưa hấu Tiền Giang", "https://upload.wikimedia.org/wikipedia/commons/f/f2/Watermelon.jpg"));
        fruits.add(new Fruit("Cam vàng", "Cam vàng nhập khẩu", "https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg"));
    }

    private void showAddOrEditDialog(Fruit fruit, int index) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_fruit_input, null);
        EditText edtTitle = dialogView.findViewById(R.id.edtTitle);
        EditText edtDesc = dialogView.findViewById(R.id.edtDescription);
        EditText edtImageUrl = dialogView.findViewById(R.id.edtImageUrl);

        if (fruit != null) {
            edtTitle.setText(fruit.getTitle());
            edtDesc.setText(fruit.getDescription());
            edtImageUrl.setText(fruit.getImageUrl());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(fruit == null ? "Thêm mới" : "Chỉnh sửa");
        builder.setView(dialogView);
        builder.setPositiveButton("Lưu", (dialog, which) -> {
            String title = edtTitle.getText().toString();
            String desc = edtDesc.getText().toString();
            String imageUrl = edtImageUrl.getText().toString();

            if (fruit == null) {
                fruits.add(new Fruit(title, desc, imageUrl));
            } else {
                fruit.setTitle(title);
                fruit.setDescription(desc);
                fruit.setImageUrl(imageUrl);
                fruits.set(index, fruit);
            }
            adapter.notifyDataSetChanged();
        });
        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showEditDeleteDialog(int index) {
        String[] options = {"Chỉnh sửa", "Xoá"};
        new AlertDialog.Builder(this)
                .setTitle("Chọn thao tác")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) {
                        showAddOrEditDialog(fruits.get(index), index);
                    } else {
                        confirmDelete(index);
                    }
                })
                .show();
    }

    private void confirmDelete(int index) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xoá")
                .setMessage(String.format("Bạn có chắc chắn muốn xoá sản phẩm %s  không?", fruits.get(index).getTitle()))
                .setPositiveButton("Xoá", (dialog, which) -> {
                    fruits.remove(index);
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Huỷ", null)
                .show();
    }

}
