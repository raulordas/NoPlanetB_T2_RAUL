package com.example.a21724343.noplanetb_t2_raul;

import android.support.design.widget.TextInputEditText;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import static android.view.KeyEvent.KEYCODE_BACK;

public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<BLogin> {
    public ExampleInstrumentedTest() {
        super(BLogin.class);
    }

    private Button btnLogin;
    private TextInputEditText etxMail;
    private TextInputEditText etxPassword;

    private static final String USERNAME = "ordasraul@gmail.com";
    private static final String PASSWORD = "1234";

    protected void setUp() throws Exception {
        super.setUp();
        BLogin actividad = getActivity();
        btnLogin = actividad.findViewById(R.id.btnSignIn);
        etxMail = actividad.findViewById(R.id.etxName);
        etxPassword = actividad.findViewById(R.id.etxPassword);
    }

    public void testLogin() {

        //Le solicitamos a android que introduzca el usuario
        TouchUtils.tapView(this, etxMail);
        getInstrumentation().sendStringSync(USERNAME);

        //Le solicitamos a android que introduzca el password
        TouchUtils.tapView(this, etxPassword);
        getInstrumentation().sendStringSync(PASSWORD);

        sendKeys(KEYCODE_BACK);

        //Le solicitamos a android que pulse en el boton login
        TouchUtils.tapView(this, btnLogin);

        //Comprobamos si se cumple la condicion de que el usuario sea el introducido
        assertTrue(etxMail.getText().toString().equals(USERNAME) && etxPassword.getText().toString().equals(PASSWORD));
    }
}
