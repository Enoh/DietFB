package ahmet.diet.com.dietfb;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.*;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class MainActivity extends Activity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView user_name;
    private Button share_button;
    private ShareDialog shareDialog;
    private EditText share_txt;

    private  Button btnVKI;


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        shareDialog = new ShareDialog(MainActivity.this);

        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        user_name = (TextView)findViewById(R.id.txt_user_name);

        btnVKI = (Button)findViewById(R.id.btnVKI);

        loginButton = (LoginButton)findViewById(R.id.login_button);

        share_txt = (EditText)findViewById(R.id.edit_share);

        share_button = (Button)findViewById(R.id.share_button);

        loginButton.setReadPermissions(Arrays.asList("public_profile ","user_friends","email"));

        btnVKI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent nextpage = new Intent(MainActivity.this, CalculateVKI.class);
                startActivity(nextpage);

            }
        });

        loginButton.registerCallback(callbackManager,new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {




                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject user,
                                    GraphResponse response) {



                                // user_name.setText(response.toString());

                                try{

                                    String id = user.getString("id");
                                    String name = user.getString("name");
                                    user_name.setText("HoÅŸgeldin " + " " + name);



                                }catch (Exception e)
                                {
                                    e.printStackTrace();
                                }



                            }
                        });

                request.executeAsync();

            }

            @Override
            public void onCancel() {




            }

            @Override
            public void onError(FacebookException e) {

            }
        });


        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                shareToWall();

            }
        });





    }


    private void shareToWall()
    {
        String send = share_txt.getText().toString();


        if(shareDialog.canShow(ShareLinkContent.class))
        {
            ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                    .setContentTitle("mobilhanem")
                    .setContentUrl(Uri.parse("http://www.mobilhanem.com/"))
                    .setContentDescription("Facebook Entegrasyonu TamamlandÄ±"+" "+send)
                    .build();

            shareDialog.show(shareLinkContent);
        }




    }


}
