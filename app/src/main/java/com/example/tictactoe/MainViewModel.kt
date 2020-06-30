package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel() : ViewModel() {
    var activePlayer: Int = 0
    private var checkedPositions: MutableMap<String, Int?> = mutableMapOf()
    private val MAX_SIZE = 9
    private var draws = 0
    private val _viewState = MutableLiveData<ViewState>()
    var player0Wins = 0
    var player1Wins = 0
    val viewState: LiveData<ViewState>
        get() = _viewState


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

    sealed class ViewState {
        data class Draw(val numberOfDraws: Int) : ViewState()
        data class Win(val winner: Int, val player0Wins: Int, val player1Wins: Int) : ViewState()
        data class ChangeText(val viewId: Int, val text: String) : ViewState()
    }
}