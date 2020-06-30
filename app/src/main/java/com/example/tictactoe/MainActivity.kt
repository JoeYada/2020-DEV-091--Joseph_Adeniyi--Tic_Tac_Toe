package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener(buttonListener)
        btn2.setOnClickListener(buttonListener)
        btn3.setOnClickListener(buttonListener)
        btn4.setOnClickListener(buttonListener)
        btn5.setOnClickListener(buttonListener)
        btn6.setOnClickListener(buttonListener)
        btn7.setOnClickListener(buttonListener)
        btn8.setOnClickListener(buttonListener)
        btn9.setOnClickListener(buttonListener)
        viewModel = ViewModelProvider(this).get(MainViewModel().javaClass)
        btn_start.setOnClickListener {
            btn_start.text = "Restart"
            resetUi()
        }

        btn_reset.setOnClickListener {
            resetBoard()
        }
    }

    private fun resetBoard(){
        tv_x_wins.text = "X Wins: "
        tv_o_wins.text = "O Wins: "
        tv_draws.text = "Draws:"
        resetUi()
    }

    private fun resetUi() {
        tv_win_lose.text = "Who will win?"
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

    }
    private val buttonListener = View.OnClickListener { v ->
        when(v.id){
            R.id.btn1->
                setDrawable(btn1)
            R.id.btn2->
                setDrawable(btn2)
            R.id.btn3->
                setDrawable(btn3)
            R.id.btn4->
                setDrawable(btn4)
            R.id.btn5->
                setDrawable(btn5)
            R.id.btn6->
                setDrawable(btn6)
            R.id.btn7->
                setDrawable(btn7)
            R.id.btn8->
                setDrawable(btn8)
            R.id.btn9->
                setDrawable(btn9)
        }
    }

    private fun setDrawable(view: Button){
        var player1 = false
        var player2 = false
        if (player % 2 == 0){
            player2 = true
            player1 = false
        }else{
            player2 = false
            player1 = true
        }

        if (player % 2 == 0){
            view.setTextColor(getColor(R.color.red))
            view.text = "O"
        }else{
            view.setTextColor(getColor(R.color.blue))
            view.text = "X"
        }
        view.setOnClickListener(null)
        player ++

        if (checkForWin() && player1){
            resetTable()
            tv_win_lose.text = "Player 1 Wins!!"
            p1Wins++
            tv_x_wins.text = "O Wins: $p1Wins"
        }else if (checkForWin() && player2){
            resetTable()
            tv_win_lose.text = "Player 2 Wins!!"
            p2Wins++
            tv_o_wins.text = "O Wins: $p2Wins"

        }else if (player > 9){
            player = 1
            draws++
            tv_win_lose.text = "It's a Draw!"
            tv_draws.text = "Draws: $draws"
        }
    }

}