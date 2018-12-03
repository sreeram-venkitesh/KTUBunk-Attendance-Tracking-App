package s3lbunk.hp.example.com.s3lbunkers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView subTextOne,attendTextSub1;//,percentTextNetwork;
    TextView subTextTwo,attendTextSub2;//,percentTextSolid;
    TextView subTextThree,attendTextSub3;//,percentTextCircuits;
    TextView subTextFour,attendTextSub4;//,percentTextLogic;
    TextView subTextFive,attendTextSub5;//,percentTextMath;
    TextView subTextSix,attendTextSub6;//,percentTextEco;
    TextView subTextSeven,attendTextSub7;//,percentTextCircLab;
    TextView subTextEight,attendTextSub8;//,percentTextDesLab;

    Button sitButtonNetwork,bunkButtonNetwork;
    Button sitButtonSolid,bunkButtonSolid;
    Button sitButtonCircuits,bunkButtonCircuits;
    Button sitButtonLogic,bunkButtonLogic;
    Button sitButtonMath,bunkButtonMath;
    Button sitButtonEco,bunkButtonEco;
    Button sitButtonCircLab,bunkButtonCircLab;
    Button sitButtonDesLab,bunkButtonDesLab;

    SharedPreferences sharedPreferences;

    boolean isFirstRun;
    
    boolean state = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){

            case R.id.reset : new AlertDialog.Builder(this)
                                      .setTitle("Are you sure?")
                                      .setMessage("Resetting will erase all saved data! \n I assume you have a preference.")
                                      .setPositiveButton("Kill Away!", new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialog, int which) {
                                              sharedPreferences.edit().putInt("network theory",0).apply();
                                              sharedPreferences.edit().putInt("network theory total",0).apply();
                                              sharedPreferences.edit().putFloat("network theory percent",0).apply();

                                              sharedPreferences.edit().putInt("solid state devices",0).apply();
                                              sharedPreferences.edit().putInt("solid state devices total",0).apply();
                                              sharedPreferences.edit().putFloat("solid state devices percent",0).apply();

                                              sharedPreferences.edit().putInt("electronic circuits",0).apply();
                                              sharedPreferences.edit().putInt("electronic circuits total",0).apply();
                                              sharedPreferences.edit().putFloat("electronic circuits percent",0).apply();

                                              sharedPreferences.edit().putInt("logic circuit design",0).apply();
                                              sharedPreferences.edit().putInt("logic circuit design total",0).apply();
                                              sharedPreferences.edit().putFloat("logic circuit design percent",0).apply();

                                              sharedPreferences.edit().putInt("maths",0).apply();
                                              sharedPreferences.edit().putInt("maths total",0).apply();
                                              sharedPreferences.edit().putFloat("maths percent",0).apply();

                                              sharedPreferences.edit().putInt("economics",0).apply();
                                              sharedPreferences.edit().putInt("economics total",0).apply();
                                              sharedPreferences.edit().putFloat("economics percent",0).apply();

                                              sharedPreferences.edit().putInt("circuits lab",0).apply();
                                              sharedPreferences.edit().putInt("circuits lab total",0).apply();
                                              sharedPreferences.edit().putFloat("circuits lab percent",0).apply();

                                              sharedPreferences.edit().putInt("design lab",0).apply();
                                              sharedPreferences.edit().putInt("design lab total",0).apply();
                                              sharedPreferences.edit().putFloat("design lab percent",0).apply();

                                              attendTextSub1.setText(String.valueOf(sharedPreferences.getInt("network theory",0)) + "/" + sharedPreferences.getInt("network theory total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("network theory percent",0))+"%");
                                              //percentTextNetwork.setText(String.format("%.2f",sharedPreferences.getFloat("network theory percent",0))+"%");

                                              attendTextSub2.setText(String.valueOf(sharedPreferences.getInt("solid state devices",0)) + "/" + sharedPreferences.getInt("solid state devices total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("solid state devices percent",0))+"%");
                                              //percentTextSolid.setText(String.format("%.2f",sharedPreferences.getFloat("solid state devices percent",0))+"%");

                                              attendTextSub3.setText(String.valueOf(sharedPreferences.getInt("electronic circuits ",0)) + "/" + sharedPreferences.getInt("electronic circuits total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("electronic circuits percent",0))+"%");
                                              //percentTextCircuits.setText(String.format("%.2f",sharedPreferences.getFloat("electronic circuits percent",0))+"%");

                                              attendTextSub4.setText(String.valueOf(sharedPreferences.getInt("logic circuit design",0)) + "/" + sharedPreferences.getInt("logic circuit design total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("logic circuit design percent",0))+"%");
                                              //percentTextLogic.setText(String.format("%.2f",sharedPreferences.getFloat("logic circuit design percent",0))+"%");

                                              attendTextSub5.setText(String.valueOf(sharedPreferences.getInt("maths",0)) + "/" + sharedPreferences.getInt("maths total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("maths percent",0))+"%");
                                              //percentTextMath.setText(String.format("%.2f",sharedPreferences.getFloat("maths percent",0))+"%");

                                              attendTextSub6.setText(String.valueOf(sharedPreferences.getInt("economics",0)) + "/" + sharedPreferences.getInt("economics total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("economics percent",0))+"%");
                                              //percentTextEco.setText(String.format("%.2f",sharedPreferences.getFloat("economics percent",0))+"%");

                                              attendTextSub7.setText(String.valueOf(sharedPreferences.getInt("circuits lab",0)) + "/" + sharedPreferences.getInt("circuits lab total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("circuits lab percent",0))+"%");
                                              //percentTextCircLab.setText(String.format("%.2f",sharedPreferences.getFloat("circuits lab percent",0))+"%");

                                              attendTextSub8.setText(String.valueOf(sharedPreferences.getInt("design lab",0)) + "/" + sharedPreferences.getInt("design lab total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("design lab percent",0))+"%");
                                              //percentTextDesLab.setText(String.format("%.2f",sharedPreferences.getFloat("design lab percent",0))+"%");
                                          }
                                      })
                                      .setNegativeButton("Go Back!",null)
                                      .show();
                              return true;


            case R.id.about : new AlertDialog.Builder(this).
                                      setTitle("About").
                                      setMessage("This app was made by \n Sreeram Venkitesh").
                                      setNegativeButton("Aayikotte...",null).
                                      show();
                              return true;

            default: return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subTextOne = (TextView) findViewById(R.id.subjectText);


        sharedPreferences = this.getSharedPreferences(getPackageName(),MODE_PRIVATE);

        isFirstRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE)
                .getBoolean("isFirstRun",true);


        if(isFirstRun)
        {
            sharedPreferences.edit().putInt("network theory",0).apply();
            sharedPreferences.edit().putInt("network theory total",0).apply();
            sharedPreferences.edit().putFloat("network theory percent",0).apply();

            sharedPreferences.edit().putInt("solid state devices",0).apply();
            sharedPreferences.edit().putInt("solid state devices total",0).apply();
            sharedPreferences.edit().putFloat("solid state devices percent",0).apply();

            sharedPreferences.edit().putInt("electronic circuits",0).apply();
            sharedPreferences.edit().putInt("electronic circuits total",0).apply();
            sharedPreferences.edit().putFloat("electronic circuits percent",0).apply();

            sharedPreferences.edit().putInt("logic circuit design",0).apply();
            sharedPreferences.edit().putInt("logic circuit design total",0).apply();
            sharedPreferences.edit().putFloat("logic circuit design percent",0).apply();

            sharedPreferences.edit().putInt("maths",0).apply();
            sharedPreferences.edit().putInt("maths total",0).apply();
            sharedPreferences.edit().putFloat("maths percent",0).apply();

            sharedPreferences.edit().putInt("economics",0).apply();
            sharedPreferences.edit().putInt("economics total",0).apply();
            sharedPreferences.edit().putFloat("economics percent",0).apply();

            sharedPreferences.edit().putInt("circuits lab",0).apply();
            sharedPreferences.edit().putInt("circuits lab total",0).apply();
            sharedPreferences.edit().putFloat("circuits lab percent",0).apply();

            sharedPreferences.edit().putInt("design lab",0).apply();
            sharedPreferences.edit().putInt("design lab total",0).apply();
            sharedPreferences.edit().putFloat("design lab percent",0).apply();

        }

        getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit()
                .putBoolean("isFirstRun",false).apply();

        attendTextSub1 = (TextView) findViewById(R.id.attendTextSub1);
        //percentTextNetwork = (TextView) findViewById(R.id.percentTextNetwork);
        sitButtonNetwork = (Button) findViewById(R.id.sitButtonNetwork);
        bunkButtonNetwork = (Button) findViewById(R.id.bunkButtonNetwork);

        attendTextSub2 = (TextView) findViewById(R.id.attendTextSub2);
        //percentTextSolid = (TextView) findViewById(R.id.percentTextSolid);
        sitButtonSolid = (Button) findViewById(R.id.sitButtonSolid);
        bunkButtonSolid = (Button) findViewById(R.id.bunkButtonSolid);

        attendTextSub3 = (TextView) findViewById(R.id.attendTextSub3);
        //percentTextCircuits = (TextView) findViewById(R.id.percentTextCircuits);
        sitButtonCircuits = (Button) findViewById(R.id.sitButtonCircuits);
        bunkButtonCircuits = (Button) findViewById(R.id.bunkButtonCircuits);

        attendTextSub4 = (TextView) findViewById(R.id.attendTextSub4);
        //percentTextLogic = (TextView) findViewById(R.id.percentTextLogic);
        sitButtonLogic = (Button) findViewById(R.id.sitButtonLogic);
        bunkButtonLogic = (Button) findViewById(R.id.bunkButtonLogic);

        attendTextSub5 = (TextView) findViewById(R.id.attendTextSub5);
        //percentTextMath = (TextView) findViewById(R.id.percentTextMath);
        sitButtonMath = (Button) findViewById(R.id.sitButtonMath);
        bunkButtonMath = (Button) findViewById(R.id.bunkButtonMath);

        attendTextSub6 = (TextView) findViewById(R.id.attendTextSub6);
        //percentTextEco = (TextView) findViewById(R.id.percentTextEco);
        sitButtonEco = (Button) findViewById(R.id.sitButtonEco);
        bunkButtonEco = (Button) findViewById(R.id.bunkButtonEco);

        attendTextSub7 = (TextView) findViewById(R.id.attendTextSub7);
        //percentTextCircLab = (TextView) findViewById(R.id.percentTextCircLab);
        sitButtonCircLab = (Button) findViewById(R.id.sitButtonCircLab);
        bunkButtonCircLab = (Button) findViewById(R.id.bunkButtonCircLab);

        attendTextSub8 = (TextView) findViewById(R.id.attendTextSub8);
        //percentTextDesLab = (TextView) findViewById(R.id.percentTextDesLab);
        sitButtonDesLab = (Button) findViewById(R.id.sitButtonDesLab);
        bunkButtonDesLab = (Button) findViewById(R.id.bunkButtonDesLab);





        attendTextSub1.setText(String.valueOf(sharedPreferences.getInt("network theory",0)) + "/" + sharedPreferences.getInt("network theory total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("network theory percent",0))+"%");
        //percentTextNetwork.setText(String.format("%.2f",sharedPreferences.getFloat("network theory percent",0))+"%");

        attendTextSub2.setText(String.valueOf(sharedPreferences.getInt("solid state devices",0)) + "/" + sharedPreferences.getInt("solid state devices total",0) + " " + String.format("%.2f",sharedPreferences.getFloat("solid state devices percent",0))+"%");
        //percentTextSolid.setText(String.format("%.2f",sharedPreferences.getFloat("solid state devices percent",0))+"%");

        attendTextSub3.setText(String.valueOf(sharedPreferences.getInt("electronic circuits ",0)) + "/" + sharedPreferences.getInt("electronic circuits total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("electronic circuits percent",0))+"%");
        //percentTextCircuits.setText(String.format("%.2f",sharedPreferences.getFloat("electronic circuits percent",0))+"%");

        attendTextSub4.setText(String.valueOf(sharedPreferences.getInt("logic circuit design",0)) + "/" + sharedPreferences.getInt("logic circuit design total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("logic circuit design percent",0))+"%");
        //percentTextLogic.setText(String.format("%.2f",sharedPreferences.getFloat("logic circuit design percent",0))+"%");

        attendTextSub5.setText(String.valueOf(sharedPreferences.getInt("maths",0)) + "/" + sharedPreferences.getInt("maths total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("maths percent",0))+"%");
        //percentTextMath.setText(String.format("%.2f",sharedPreferences.getFloat("maths percent",0))+"%");

        attendTextSub6.setText(String.valueOf(sharedPreferences.getInt("economics",0)) + "/" + sharedPreferences.getInt("economics total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("economics percent",0))+"%");
        //percentTextEco.setText(String.format("%.2f",sharedPreferences.getFloat("economics percent",0))+"%");

        attendTextSub7.setText(String.valueOf(sharedPreferences.getInt("circuits lab",0)) + "/" + sharedPreferences.getInt("circuits lab total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("circuits lab percent",0))+"%");
        //percentTextCircLab.setText(String.format("%.2f",sharedPreferences.getFloat("circuits lab percent",0))+"%");

        attendTextSub8.setText(String.valueOf(sharedPreferences.getInt("design lab",0)) + "/" + sharedPreferences.getInt("design lab total",0)+" "+String.format("%.2f",sharedPreferences.getFloat("design lab percent",0))+"%");
        //percentTextDesLab.setText(String.format("%.2f",sharedPreferences.getFloat("design lab percent",0))+"%");


    }

    public void sitFunctionNetwork(View view){

        int attended = sharedPreferences.getInt("network theory",0);
        int total = sharedPreferences.getInt("network theory total",0);

        attended++;
        total++;

        float percentageNetwork = (float) attended/total *100;

        sharedPreferences.edit().putFloat("network theory percent",percentageNetwork).apply();


        sharedPreferences.edit().putInt("network theory",attended).apply();
        sharedPreferences.edit().putInt("network theory total",total).apply();

        attendTextSub1.setText( String.valueOf(attended) + "/" + String.valueOf(total) + " "+ String.format("%.2f",percentageNetwork)+"%");
        //percentTextNetwork.setText(String.format("%.2f",percentageNetwork)+"%");


    }

    public void sitFunctionSolid(View view){

        int attended = sharedPreferences.getInt("solid state devices",0);
        int total = sharedPreferences.getInt("solid state devices total",0);

        attended++;
        total++;

        float percentageSolid = (float) attended/total *100;

        sharedPreferences.edit().putFloat("solid state devices percent",percentageSolid).apply();


        sharedPreferences.edit().putInt("solid state devices",attended).apply();
        sharedPreferences.edit().putInt("solid state devices total",total).apply();

        attendTextSub2.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageSolid)+"%");
        //percentTextSolid.setText(String.format("%.2f",percentageSolid)+"%");


    }

    public void sitFunctionCircuits(View view){

        int attended = sharedPreferences.getInt("electronic circuits",0);
        int total = sharedPreferences.getInt("electronic circuits total",0);

        attended++;
        total++;

        float percentageCircuits = (float) attended/total *100;

        sharedPreferences.edit().putFloat("electronic circuits percent",percentageCircuits).apply();


        sharedPreferences.edit().putInt("electronic circuits",attended).apply();
        sharedPreferences.edit().putInt("electronic circuits total",total).apply();

        attendTextSub3.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+ String.format("%.2f",percentageCircuits)+"%");
        //percentTextCircuits.setText(String.format("%.2f",percentageCircuits)+"%");


    }

    public void sitFunctionLogic(View view){

        int attended = sharedPreferences.getInt("logic circuit design",0);
        int total = sharedPreferences.getInt("logic circuit design total",0);

        attended++;
        total++;

        float percentageLogic = (float) attended/total *100;

        sharedPreferences.edit().putFloat("logic circuit design percent",percentageLogic).apply();


        sharedPreferences.edit().putInt("logic circuit design",attended).apply();
        sharedPreferences.edit().putInt("logic circuit design total",total).apply();

        attendTextSub4.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageLogic)+"%");
        //percentTextLogic.setText(String.format("%.2f",percentageLogic)+"%");


    }

    public void sitFunctionMath(View view){

        int attended = sharedPreferences.getInt("maths",0);
        int total = sharedPreferences.getInt("maths total",0);

        attended++;
        total++;

        float percentageMath = (float) attended/total *100;

        sharedPreferences.edit().putFloat("maths percent",percentageMath).apply();
        sharedPreferences.edit().putInt("maths",attended).apply();
        sharedPreferences.edit().putInt("maths total",total).apply();

        attendTextSub5.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageMath)+"%");
        //percentTextMath.setText(String.format("%.2f",percentageMath)+"%");


    }

    public void sitFunctionEco(View view){

        int attended = sharedPreferences.getInt("economics",0);
        int total = sharedPreferences.getInt("economics total",0);

        attended++;
        total++;

        float percentageEco = (float) attended/total *100;

        sharedPreferences.edit().putFloat("economics percent",percentageEco).apply();


        sharedPreferences.edit().putInt("economics",attended).apply();
        sharedPreferences.edit().putInt("economics total",total).apply();

        attendTextSub6.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageEco)+"%");
        //percentTextEco.setText(String.format("%.2f",percentageEco)+"%");


    }

    public void sitFunctionCircLab(View view){

        int attended = sharedPreferences.getInt("circuits lab",0);
        int total = sharedPreferences.getInt("circuits lab total",0);

        attended++;
        total++;

        float percentageCircLab = (float) attended/total *100;

        sharedPreferences.edit().putFloat("circuits lab percent",percentageCircLab).apply();


        sharedPreferences.edit().putInt("circuits lab",attended).apply();
        sharedPreferences.edit().putInt("circuits lab total",total).apply();

        attendTextSub7.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageCircLab)+"%");
        //percentTextCircLab.setText(String.format("%.2f",percentageCircLab)+"%");


    }

    public void sitFunctionDesLab(View view){

        int attended = sharedPreferences.getInt("design lab",0);
        int total = sharedPreferences.getInt("design lab total",0);

        attended++;
        total++;

        float percentageDesLab = (float) attended/total *100;

        sharedPreferences.edit().putFloat("design lab percent",percentageDesLab).apply();


        sharedPreferences.edit().putInt("design lab",attended).apply();
        sharedPreferences.edit().putInt("design lab total",total).apply();

        attendTextSub8.setText( String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageDesLab)+"%");
        //percentTextDesLab.setText(String.format("%.2f",percentageDesLab)+"%");


    }

    public void bunkFunctionNetwork(View view){

      int total = sharedPreferences.getInt("network theory total",0);
      int attended = sharedPreferences.getInt("network theory",0);

      total++;

      float percentageNetwork = (float) attended/total *100;

      sharedPreferences.edit().putFloat("network theory percent",percentageNetwork).apply();
      sharedPreferences.edit().putInt("network theory total",total).apply();

      //percentTextNetwork.setText(String.format("%.2f",percentageNetwork)+"%");
      attendTextSub1.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageNetwork)+"%");

    }

    public void bunkFunctionSolid(View view){

        int total = sharedPreferences.getInt("solid state devices total",0);
        int attended = sharedPreferences.getInt("solid state devices",0);

        total++;

        float percentageSolid = (float) attended/total *100;

        sharedPreferences.edit().putFloat("solid state devices percent",percentageSolid).apply();
        //percentTextSolid.setText(String.format("%.2f",percentageSolid)+"%");

        sharedPreferences.edit().putInt("solid state devices total",total).apply();


        attendTextSub2.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageSolid)+"%");

    }

    public void bunkFunctionCircuits(View view){

        int total = sharedPreferences.getInt("electronic circuits total",0);
        int attended = sharedPreferences.getInt("electronic circuits",0);

        total++;

        float percentageCircuits = (float) attended/total *100;

        sharedPreferences.edit().putFloat("electronic circuits percent",percentageCircuits).apply();
        //percentTextCircuits.setText(String.format("%.2f",percentageCircuits)+"%");

        sharedPreferences.edit().putInt("electronic circuits total",total).apply();


        attendTextSub3.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageCircuits)+"%");

    }

    public void bunkFunctionLogic(View view){

        int total = sharedPreferences.getInt("logic circuit design total",0);
        int attended = sharedPreferences.getInt("logic circuit design",0);

        total++;

        float percentageLogic = (float) attended/total *100;

        sharedPreferences.edit().putFloat("logic circuit design percent",percentageLogic).apply();
        //percentTextLogic.setText(String.format("%.2f",percentageLogic)+"%");

        sharedPreferences.edit().putInt("logic circuit design total",total).apply();


        attendTextSub4.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageLogic)+"%");

    }

    public void bunkFunctionMath(View view){

        int total = sharedPreferences.getInt("maths total",0);
        int attended = sharedPreferences.getInt("maths",0);

        total++;

        float percentageMath = (float) attended/total *100;

        sharedPreferences.edit().putFloat("maths percent",percentageMath).apply();
        //percentTextMath.setText(String.format("%.2f",percentageMath)+"%");

        sharedPreferences.edit().putInt("maths total",total).apply();


        attendTextSub5.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageMath)+"%");

    }

    public void bunkFunctionEco(View view){

        int total = sharedPreferences.getInt("economics total",0);
        int attended = sharedPreferences.getInt("economics",0);

        total++;

        float percentageEco = (float) attended/total *100;

        sharedPreferences.edit().putFloat("economics percent",percentageEco).apply();
        //percentTextEco.setText(String.format("%.2f",percentageEco)+"%");

        sharedPreferences.edit().putInt("economics total",total).apply();


        attendTextSub6.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageEco)+"%");

    }

    public void bunkFunctionCircLab(View view){

        int total = sharedPreferences.getInt("circuits lab total",0);
        int attended = sharedPreferences.getInt("circuits lab",0);

        total++;

        float percentageCircLab = (float) attended/total *100;

        sharedPreferences.edit().putFloat("circuits lab percent",percentageCircLab).apply();
        //percentTextCircLab.setText(String.format("%.2f",percentageCircLab)+"%");

        sharedPreferences.edit().putInt("circuits lab total",total).apply();


        attendTextSub7.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageCircLab)+"%");

    }

    public void bunkFunctionDesLab(View view){

        int total = sharedPreferences.getInt("design lab total",0);
        int attended = sharedPreferences.getInt("design lab",0);

        total++;

        float percentageDesLab = (float) attended/total *100;

        sharedPreferences.edit().putFloat("design lab percent",percentageDesLab).apply();
        //percentTextDesLab.setText(String.format("%.2f",percentageDesLab)+"%");

        sharedPreferences.edit().putInt("design lab total",total).apply();


        attendTextSub8.setText(String.valueOf(attended) + "/" + String.valueOf(total)+" "+String.format("%.2f",percentageDesLab)+"%");

    }

}
