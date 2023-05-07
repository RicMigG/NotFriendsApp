package com.gitlab.ricardomgago.totallynotmadebyjoeyapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // Declare our references to views before layout inflation
    private lateinit var name: EditText;
    private lateinit var message: TextView;

    // Override lifecycle function onCreate. This should initialize all important items.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        // Inflate layout to turn XML into Kotlin objects.
        setContentView(R.layout.activity_main);

        // Get a reference to the button view from out layout and set a clickListener
        val updateButton: Button = findViewById(R.id.activity_main_btn_update);
        updateButton.setOnClickListener() {
            updateMessage();
        }

        // Set the value to our declared views
        name = findViewById(R.id.activity_main_et_name);
        message = findViewById(R.id.main_activity_tv_message);
    }

    // Get a name from the edit text and display a personalized msg
    private fun updateMessage() {
        // Get the username from the ediText
        val username = name.text;
        val notFriendsPhrases = listOf(
            "Welcome to the real world $username. It sucks! You're gonna love it. - Monica",
            "You're over me $username? When were you under me? - Chandler",
            "I'm not great at advice, can I interest you in a sarcastic comment $username? - Chandler",
            "I'm full, and yet I know if I stop eating this $username, I'll regret it. - Joey",
            "I'm thinking about how cool it would be to have a flying car $username. But then I think, would I really trust people to drive in three dimensions? - Ross",
            "If I were a guy, and...did I just say 'if I were a guy' $username? - Rachel",
            "You're so far past the line $username, you can't even see the line. The line is a dot to you. - Joey",
            "Welcome to the world of crazy $username, where the only thing crazier than you is everyone else. - Phoebe",
            "I'm not great at the advice. Can I interest you in a sarcastic comment $username? - Chandler",
            "I can handle this $username. Handle is my middle name. Actually, handle is the middle of my first name. - Joey",
            "Why don't you come with us $username? It'll be like Thelma and Louise, but without the driving off the cliff. - Rachel",
            "Ah, humor based on my pain $username. - Chandler",
            "If you're afraid of getting hurt $username, then you might as well stop playing altogether. - Monica",
            "I can't believe my Dad saw us having sex $username! He grounded me for a month, which is ridiculous because I'm 32. - Ross",
            "I may play the fool at times $username, but I'm more than just a pretty blonde girl with an ass that won't quit. - Phoebe",
            "I'm not great at the advice. Can I interest you in a sarcastic comment $username? - Chandler",
            "You know $username, you're very attractive in the dark... - Rachel",
            "If you want to receive e-mails about my upcoming shows $username, please give me money so I can buy a computer. - Phoebe",
            "I say more dumb things before 9 a.m. than most people say all day $username. - Chandler",
            "If you want to receive e-mails about my upcoming shows $username, please give me money so I can buy a computer. - Phoebe",
            "Welcome to the real world $username. It sucks! You're gonna love it. - Monica",
            "I'm not great at the advice. Can I interest you in a sarcastic comment $username? - Chandler",
            "I'm not so good with the advice...Can I interest you in a sarcastic comment $username? - Chandler",
            "I'm gonna go see my father $username. He used to put me up on his shoulders, and now I'm gonna do the same with him. - Ross",
            "I'm full, and yet I know if I stop eating this $username, I'll regret it. - Joey",
            "I know what you're thinking $username, she's too good for him. But trust me, he's not. - Rachel",
            "I'm the holiday armadillo! To the rescue with holiday cheer $username. - Ross",
            "You don't own a TV $username? What's all your furniture pointed at? - Joey",
            "I'm not so good with advice. Can I interest you in a sarcastic comment $username? - Chandler",
            "Oh, I'm sorry, did my back hurt your knife $username? - Rachel",
            "I'm not great at the advice. Can I interest you in a sarcastic comment $username? - Chandler"
        );
        val index = (notFriendsPhrases.indices).random();
        val currentMessage = notFriendsPhrases[index];

        if (username.toString() == "") {
            message.text = "Make sure to enter your name!";
        } else {
            // Update the textview to display our message
            message.text = currentMessage;
        }
        name.setText("");
        hideKeyboard();
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        imm.hideSoftInputFromWindow(name.windowToken, 0);
    }
}