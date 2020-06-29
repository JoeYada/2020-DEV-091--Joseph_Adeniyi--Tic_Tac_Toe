package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var factory: MainViewModelFactory
    private var player : Int = 1
    var p1Wins: Int = 0
    var p2Wins: Int = 0
    var draws: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel().javaClass)
        btn_Start.setOnClickListener(View.OnClickListener {
            btn_Start.text = "Restart"
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
            btn1.setOnClickListener(buttonListener)
            btn2.setOnClickListener(buttonListener)
            btn3.setOnClickListener(buttonListener)
            btn4.setOnClickListener(buttonListener)
            btn5.setOnClickListener(buttonListener)
            btn6.setOnClickListener(buttonListener)
            btn7.setOnClickListener(buttonListener)
            btn8.setOnClickListener(buttonListener)
            btn9.setOnClickListener(buttonListener)
        })

        btn_reset.setOnClickListener( View.OnClickListener {
            tv_x_wins.text = "X Wins: "
            tv_o_wins.text = "O Wins: "
            tv_draws.text = "Draws:"
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
            btn1.setOnClickListener(buttonListener)
            btn2.setOnClickListener(buttonListener)
            btn3.setOnClickListener(buttonListener)
            btn4.setOnClickListener(buttonListener)
            btn5.setOnClickListener(buttonListener)
            btn6.setOnClickListener(buttonListener)
            btn7.setOnClickListener(buttonListener)
            btn8.setOnClickListener(buttonListener)
            btn9.setOnClickListener(buttonListener)
            p1Wins = 0
            p2Wins = 0
            draws = 0
        })
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

    private fun resetTable(){
        player = 1
        btn1.setOnClickListener(null)
        btn2.setOnClickListener(null)
        btn3.setOnClickListener(null)
        btn4.setOnClickListener(null)
        btn5.setOnClickListener(null)
        btn6.setOnClickListener(null)
        btn7.setOnClickListener(null)
        btn8.setOnClickListener(null)
        btn9.setOnClickListener(null)
    }

    private fun checkForWin(): Boolean{
        val sections = List<String>(9){""}.toMutableList()
        sections[0] = btn1.text.toString()
        sections[1] = btn2.text.toString()
        sections[2] = btn3.text.toString()
        sections[3] = btn4.text.toString()
        sections[4] = btn5.text.toString()
        sections[5] = btn6.text.toString()
        sections[6] = btn7.text.toString()
        sections[7] = btn8.text.toString()
        sections[8] = btn9.text.toString()
        return viewModel.checkWin(sections)
    }

}