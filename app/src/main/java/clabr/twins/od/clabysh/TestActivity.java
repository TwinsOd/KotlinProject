package clabr.twins.od.clabysh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.test_img).setOnClickListener(this);
        findViewById(R.id.layout_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test_img:
                Toast.makeText(this, "test img", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_test:
                Toast.makeText(this, "test layout", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }
    }
}
