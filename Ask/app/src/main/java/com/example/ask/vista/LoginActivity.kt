package com.example.ask.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ask.R
import com.example.ask.controlador.Controller
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GetTokenResult
import com.google.firebase.messaging.FirebaseMessaging

class LoginActivity : AppCompatActivity() {

    lateinit var  btn: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var mbutton: Button
    private lateinit var registerButton: TextView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialise()
        btn = findViewById(R.id.btn_sign_in)
        registerButton = findViewById(R.id.btn_sign_up)
        //btn.setOnClickListener(irRegistro())
        mbutton = findViewById(R.id.btn_sign_in)
        Controller.getSubjects()
        mbutton.setOnClickListener {
            loginUser()
        }

        registerButton.setOnClickListener {
            irRegistro()
        }

    }

    private fun initialise() {
        etEmail = findViewById(R.id.editTextTextPersonName)
        etPassword = findViewById(R.id.editTextTextPassword)

        mAuth = FirebaseAuth.getInstance()
    }

    private fun irRegistro() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun loginUser() {
        val email = etEmail.text.toString()
        val pass = etPassword.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() ) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                //System.out.println(mAuth.currentUser?.displayName ?: "paila")
                mAuth.currentUser?.getIdToken(true)
                    ?.addOnSuccessListener(OnSuccessListener<GetTokenResult> { result ->
                        val idToken = result.token
                        //Do whatever
                        System.out.println(idToken)
                        if (idToken != null) {
                            Controller.token = idToken
                        }
                    })

                FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        return@OnCompleteListener
                    }

                    // Get new FCM registration token
                    val token = task.result

                   // System.out.println(token)
                })
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}