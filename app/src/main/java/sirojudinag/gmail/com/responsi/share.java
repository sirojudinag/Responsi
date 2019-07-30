package sirojudinag.gmail.com.responsi;
//sirojudin abdul ghopur
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class share extends AppCompatActivity {
    private Button btnShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        btnShare = findViewById(R.id.shareapp);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareSubText = "about app";
                String shareBodyText = "Version app 1.0. This app developed by : Sirojudin Abdul Ghopur, Copyright @2019, to download : http://bit.ly/2ZmNE8O";
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSubText);
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });
    }
}
