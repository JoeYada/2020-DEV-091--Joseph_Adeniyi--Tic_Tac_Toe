package com.example.tictactoe

import androidx.lifecycle.ViewModel


class MainViewModel() : ViewModel() {

    fun checkWin(sections:List<String>):Boolean{
        if (sections[0] == sections[1] && sections[0] == sections[2] && sections[0] != ""){
            return true
        }else if (sections[3] == sections[4] && sections[3] == sections[5] && sections[3] != ""){
            return true
        }else if (sections[6] == sections[7] && sections[6] == sections[8] && sections[6] != ""){
            return true
        }else if (sections[0] == sections[3] && sections[0] == sections[6] && sections[0] != ""){
            return true
        }else if (sections[1] == sections[4] && sections[1] == sections[7] && sections[1] != ""){
            return true
        }else if (sections[2] == sections[5] && sections[2] == sections[8] && sections[2] != ""){
            return true
        }else if (sections[0] == sections[4] && sections[0] == sections[8] && sections[0] != ""){
            return true
        }else if (sections[2] == sections[4] && sections[2] == sections[6] && sections[2] != ""){
            return true
        }
        return false
    }
}