package rohit.com.datepickernew;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private TextView mDateOfBirth;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateOfBirth = findViewById(R.id.dob_editText);
        mDateOfBirth.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_RIGHT = 2;
        if (event.getAction() == MotionEvent.ACTION_UP){
            if (event.getRawX()>= (mDateOfBirth.getRight()- mDateOfBirth.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                Calendar calendar = Calendar.getInstance();
                final int mYear = calendar.get(Calendar.YEAR);
                final int mMonth = calendar.get(Calendar.MONTH);
                final int mDays = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      mDateOfBirth.setText(mDays + "/" + mMonth + "/" + mYear );
                    }
                },mYear,mMonth,mDays);

datePickerDialog.show();
            }
        }

        return false;
    }
}
