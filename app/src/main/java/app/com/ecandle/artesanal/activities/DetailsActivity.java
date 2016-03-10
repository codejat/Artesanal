package app.com.ecandle.artesanal.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import app.com.ecandle.artesanal.R;
import app.com.ecandle.artesanal.models.Contact;
// Taller Artesanal Jtomaylla 2016-03-10
public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";
    private Contact mContact;
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvPhone;
    private View vPalette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle data = getIntent().getExtras();

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        vPalette = findViewById(R.id.vPalette);
//test
        // Extract contact from bundle
        mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);

        // Fill views with data
        if (!data.getString("cName").isEmpty() && !data.getString("cNumber").isEmpty()  ){

            Picasso.with(DetailsActivity.this).load(data.getInt("cImageId")).fit().centerCrop().into(ivProfile);
            tvName.setText(data.getString("cName"));
            tvPhone.setText(data.getString("cNumber"));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
