package com.example.djar.mines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow.LayoutParams lpView = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        lpView.setMargins(3, 3, 3, 3);
        lpView.weight = 1;

        TableLayout mainTable = (TableLayout) findViewById(R.id.mainTable);

        int rows = 8;
        int columns = 8;
        int mines = 10;

        for (int i = 0; i < rows; i++) {
            TableRow tRow = new TableRow(this);
            tRow.setLayoutParams(lpView);
            mainTable.addView(tRow);
            for (int j = 0; j < columns; j++) {
                TextView tview = new TextView(this);
                tview.setText(Integer.toString(i) + Integer.toString(j));
                tview.setPadding(20, 20, 20, 20);
                tview.setWidth(0);
                tview.setOnClickListener(this);
                tview.setOnLongClickListener(this);
                //tview.setHeight(tview.getWidth());
                tview.setBackgroundColor(getColor(R.color.cellUntouched));
                tRow.addView(tview, lpView);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(((TextView) v).getText());
    }

    @Override
    public boolean onLongClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(((TextView) v).getText() + " ☠ ✱ ☀ ☼ ⚑");
        return true;
    }
}

