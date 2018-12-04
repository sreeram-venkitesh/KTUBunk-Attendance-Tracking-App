package s3lbunk.hp.example.com.s3lbunkers;
//,Test Comment Kiran Johns Comment 2;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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

    Button sitButtonSub1,bunkButtonSub1;
    Button sitButtonSub2,bunkButtonSub2;
    Button sitButtonSub3,bunkButtonSub3;
    Button sitButtonSub4,bunkButtonSub4;
    Button sitButtonSub5,bunkButtonSub5;
    Button sitButtonSub6,bunkButtonSub6;
    Button sitButtonSub7,bunkButtonSub7;
    Button sitButtonSub8,bunkButtonSub8;

    SharedPreferences sharedPreferences;

    String currentYear;
    String currentBranch;
    String[] subjects;




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
            case R.id.setup : setBranch();
                              return true;

            default: return false;
        }
    }

    public void setBranch(){


        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.dropdown_menu,null);
        alert.setTitle("Set up");
        alert.setView(view);
        alert.setMessage("Select year and branch");

        final Spinner yearSpinner = (Spinner) view.findViewById(R.id.yearSpinner);
        final Spinner branchSpinner = (Spinner) view.findViewById(R.id.branchSpinner);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.year));

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.branch));


        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(branchAdapter);

        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String yearText = yearSpinner.getSelectedItem().toString();
                String branchText = branchSpinner.getSelectedItem().toString();

                sharedPreferences.edit().putString("year",yearText).apply();
                sharedPreferences.edit().putString("branch",branchText).apply();

                changeSubjects();

            }
        });
        alert.show();


    }

    public void changeSubjects(){
        currentYear = sharedPreferences.getString("year","");
        currentBranch = sharedPreferences.getString("branch","");

        if(currentYear.contentEquals("S1") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s1ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);

        }
        else if(currentYear.contentEquals("S2") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s2ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S3") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s3ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S4") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s4ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S5") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s5ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S6") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s6ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S7") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s7ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }
        else if(currentYear.contentEquals("S8") && currentBranch.contentEquals("Electronics and Communication")){

            subjects = getResources().getStringArray(R.array.s8ece);

            subTextOne.setText(subjects[0]);
            subTextTwo.setText(subjects[1]);
            subTextThree.setText(subjects[2]);
            subTextFour.setText(subjects[3]);
            subTextFive.setText(subjects[4]);
            subTextSix.setText(subjects[5]);
            subTextSeven.setText(subjects[6]);
            subTextEight.setText(subjects[7]);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subTextOne = (TextView) findViewById(R.id.subjectTextOne);
        subTextTwo = (TextView) findViewById(R.id.subjectTextTwo);
        subTextThree = (TextView) findViewById(R.id.subjectTextThree);
        subTextFour = (TextView) findViewById(R.id.subjectTextFour);
        subTextFive = (TextView) findViewById(R.id.subjectTextFive);
        subTextSix = (TextView) findViewById(R.id.subjectTextSix);
        subTextSeven = (TextView) findViewById(R.id.subjectTextSeven);
        subTextEight = (TextView) findViewById(R.id.subjectTextEight);


        //String sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8;

        sharedPreferences = this.getSharedPreferences(getPackageName(),MODE_PRIVATE);

        isFirstRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE)
                .getBoolean("isFirstRun",true);

        currentYear = sharedPreferences.getString("year","");
        currentBranch = sharedPreferences.getString("branch","");





        if(isFirstRun)
        {

            sharedPreferences.edit().putString("year","").apply();
            sharedPreferences.edit().putString("branch","").apply();

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

            setBranch();



        }

        getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit()
                .putBoolean("isFirstRun",false).apply();

        attendTextSub1 = (TextView) findViewById(R.id.attendTextSub1);
        //percentTextNetwork = (TextView) findViewById(R.id.percentTextNetwork);
        sitButtonSub1 = (Button) findViewById(R.id.sitButtonSub1);
        bunkButtonSub1 = (Button) findViewById(R.id.bunkButtonSub1);

        attendTextSub2 = (TextView) findViewById(R.id.attendTextSub2);
        //percentTextSolid = (TextView) findViewById(R.id.percentTextSolid);
        sitButtonSub1 = (Button) findViewById(R.id.sitButtonSub1);
        bunkButtonSub2 = (Button) findViewById(R.id.bunkButtonSub2);

        attendTextSub3 = (TextView) findViewById(R.id.attendTextSub3);
        //percentTextCircuits = (TextView) findViewById(R.id.percentTextCircuits);
        sitButtonSub3 = (Button) findViewById(R.id.sitButtonSub3);
        bunkButtonSub3 = (Button) findViewById(R.id.bunkButtonSub3);

        attendTextSub4 = (TextView) findViewById(R.id.attendTextSub4);
        //percentTextLogic = (TextView) findViewById(R.id.percentTextLogic);
        sitButtonSub4 = (Button) findViewById(R.id.sitButtonSub4);
        bunkButtonSub4 = (Button) findViewById(R.id.bunkButtonSub4);

        attendTextSub5 = (TextView) findViewById(R.id.attendTextSub5);
        //percentTextMath = (TextView) findViewById(R.id.percentTextMath);
        sitButtonSub5 = (Button) findViewById(R.id.sitButtonSub5);
        bunkButtonSub5 = (Button) findViewById(R.id.bunkButtonSub5);

        attendTextSub6 = (TextView) findViewById(R.id.attendTextSub6);
        //percentTextEco = (TextView) findViewById(R.id.percentTextEco);
        sitButtonSub6 = (Button) findViewById(R.id.sitButtonSub6);
        bunkButtonSub6 = (Button) findViewById(R.id.bunkButtonSub6);

        attendTextSub7 = (TextView) findViewById(R.id.attendTextSub7);
        //percentTextCircLab = (TextView) findViewById(R.id.percentTextCircLab);
        sitButtonSub7 = (Button) findViewById(R.id.sitButtonSub7);
        bunkButtonSub7 = (Button) findViewById(R.id.bunkButtonSub7);

        attendTextSub8 = (TextView) findViewById(R.id.attendTextSub8);
        //percentTextDesLab = (TextView) findViewById(R.id.percentTextDesLab);
        sitButtonSub8 = (Button) findViewById(R.id.sitButtonSub8);
        bunkButtonSub8 = (Button) findViewById(R.id.bunkButtonSub8);


       changeSubjects();


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



    @Override
    protected void onResume() {
        super.onResume();
        changeSubjects();
    }

    public void viewSyllabus(View view){

        TextView text = (TextView) view;
        String subj =  text.getText().toString();

        AlertDialog.Builder syllabusAlert = new AlertDialog.Builder(MainActivity.this);
        syllabusAlert.setTitle("Syllabus");
        switch(subj){
            case "   Network Theory   " : syllabusAlert.setMessage("Module 1 : Introduction to circuit variables and circuit elements ,Review of \n" +
                    " Kirchhoff’s Laws, Independent and dependent Sources, Source 15\n" +
                    "transformations\n" +
                    "Network topology, Network graphs, Trees, Incidence matrix, 2\n" +
                    "Tie-set matrix and Cut-set matrix"+"Solution methods applied to dc and phasor circuits: Mesh and node "+
                "analysis of network containing independent and dependent sources");
                                    break;

            default: break;
        }
        syllabusAlert.show();
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
