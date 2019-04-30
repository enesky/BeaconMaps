package eky.beaconmaps.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import eky.beaconmaps.BeaconMaps;
import eky.beaconmaps.R;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText entranceTitle;
    EditText entranceDesc;
    EditText exitTitle;
    EditText exitDesc;
    ImageButton helloIcon;
    ImageButton exitIcon;
    Button done;

    //Dialogdan Beacon seçimi ve Functionlardan Notification seçimi yapıldığında burayı aç
    //Beacon ın ID sini bundle ile taşı
    //Functions için TAG belirle ve Beacona tanımla sonrasında form doldurt ve bildirm ekranı oluştur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        entranceTitle = findViewById(R.id.hello_title);
        entranceDesc = findViewById(R.id.hello_desc);
        exitTitle = findViewById(R.id.exit_title);
        exitDesc = findViewById(R.id.exit_desc);
        done = findViewById(R.id.btn_done);
        done.setOnClickListener(this);
    }

    public void setNotifications(final String helloTitle, final String helledesc,
                                 final String byeTitle, final String byeDesc) {
        final BeaconMaps application = (BeaconMaps) getApplication();

        /*
        RequirementsWizardFactory.createEstimoteRequirementsWizard()
                .fulfillRequirements(this,
                        new Function0<Unit>() {
                            @Override
                            public Unit invoke() {
                                Log.d("BeaconMap", "requirements fulfilled");
                                application.enableBeaconNotifications(helloTitle, helledesc, byeTitle, byeDesc);
                                return null;
                            }
                        },
                        new Function1<List<? extends Requirement>, Unit>() {
                            @Override
                            public Unit invoke(List<? extends Requirement> requirements) {
                                Log.e("BeaconMap", "requirements missing: " + requirements);
                                return null;
                            }
                        },
                        new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("BeaconMap", "requirements error: " + throwable);
                                return null;
                            }
                        });
                        */
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btn_done:
                if (!entranceTitle.getText().toString().isEmpty() && !entranceDesc.getText().toString().isEmpty() &&
                        !exitTitle.getText().toString().isEmpty() && !exitDesc.getText().toString().isEmpty()) {
                    setNotifications(entranceTitle.getText().toString(),entranceDesc.getText().toString(),
                            exitTitle.getText().toString(), exitDesc.getText().toString());

                    /*NotificationData notificationData = new NotificationData(ConfigureBeaconActivity.getBeaconId(), entranceTitle.getText().toString(),
                            entranceDesc.getText().toString(), exitTitle.getText().toString(), exitDesc.getText().toString());
                    FirebaseUtil.saveNotificationData(notificationData);*/

                    Intent i = new Intent(NotificationActivity.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Fill the blanks", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.hello_icon:
                Toast.makeText(this, "Hello Icon clicked", Toast.LENGTH_SHORT).show();
            case R.id.exit_icon:
                Toast.makeText(this, "Exit Icon clicked", Toast.LENGTH_SHORT).show();

        }
    }

}
