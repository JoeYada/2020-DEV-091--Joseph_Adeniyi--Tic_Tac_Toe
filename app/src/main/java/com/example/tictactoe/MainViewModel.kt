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

    fun userClick(rowChecked: Int, columnChecked: Int, viewId: Int) {
        if (!checkedPositions.containsKey("${rowChecked}_${columnChecked}") && isGameActive()) {
            checkedPositions["${rowChecked}_${columnChecked}"] = activePlayer
            _viewState.value = ViewState.ChangeText(viewId, if (activePlayer == 0) "X" else "O")
            activePlayer = (activePlayer + 1) % 2
            checkWin()
        }
    }

    private fun isGameActive() =
        (_viewState.value !is ViewState.Win) && (_viewState.value !is ViewState.Draw)

    fun checkWin() {
        val rowWinner = checkAllRowWin()
        if (rowWinner != null) {
            updatePlayerWinCount(rowWinner)
            _viewState.value = ViewState.Win(rowWinner, player0Wins, player1Wins)
        }else {
            val colWinner = checkAllColumns()
            if (colWinner != null) {
                updatePlayerWinCount(colWinner)
                _viewState.value = ViewState.Win(colWinner, player0Wins, player1Wins)
            } else {
                val diagonalWinner = checkDiagonalWinner()
                if (diagonalWinner != null) {
                    updatePlayerWinCount(diagonalWinner)
                    _viewState.value = ViewState.Win(diagonalWinner, player0Wins, player1Wins)
                } else {
                    val antiDiagonalWinner = checkAntiDiagonalWinner()
                    if (antiDiagonalWinner != null) {
                        updatePlayerWinCount(antiDiagonalWinner)
                        _viewState.value =
                            ViewState.Win(antiDiagonalWinner, player0Wins, player1Wins)
                    } else if (checkedPositions.size == MAX_SIZE) {
                        draws++
                        _viewState.value = ViewState.Draw(draws)
                    }
                }
            }
        }
    }

    private fun checkAllRowWin(): Int? {
        for (i in 0..2) {
            val singlePlayer = checkRow(i)
            if (singlePlayer != null) {
                return singlePlayer
            }
        }
        return null
    }

    private fun checkRow(row: Int): Int? {
        return if (checkedPositions["${row}_0"] == checkedPositions["${row}_1"] && checkedPositions["${row}_1"]
            == checkedPositions["${row}_2"]
        ) {
            checkedPositions["${row}_0"]
        } else {
            null
        }
    }

    private fun checkAllColumns(): Int? {
        for (i in 0..2) {
            val singlePlayer = checkColumn(i)
            if (singlePlayer != null) {
                return singlePlayer
            }
        }
        return null
    }

    private fun checkColumn(column: Int): Int? {
        return if (checkedPositions["0_${column}"] == checkedPositions["1_${column}"] && checkedPositions["1_${column}"]
            == checkedPositions["2_${column}"]
        ) {
            checkedPositions["0_${column}"]
        } else {
            null
        }
    }

    private fun checkDiagonalWinner(): Int? {
        return if (checkedPositions["0_0"] == checkedPositions["1_1"] && checkedPositions["1_1"]
            == checkedPositions["2_2"]
        ) {
            checkedPositions["0_0"]
        } else {
            null
        }
    }

    private fun checkAntiDiagonalWinner(): Int? {
        return if (checkedPositions["0_2"] == checkedPositions["1_1"] && checkedPositions["1_1"]
            == checkedPositions["2_0"]
        ) {
            checkedPositions["0_2"]
        } else {
            null
        }
    }


    private fun updatePlayerWinCount(winner: Int) {
        if (winner == 0) {
            player0Wins++
        } else if (winner == 1) {
            player1Wins++
        }
    }

    fun resetStats() {
        player1Wins = 0
        player0Wins = 0
        draws = 0
    }

    fun startNewGame() {
        checkedPositions = mutableMapOf()
        activePlayer = 0
        _viewState.value = null
    }

    sealed class ViewState {
        data class Draw(val numberOfDraws: Int) : ViewState()
        data class Win(val winner: Int, val player0Wins: Int, val player1Wins: Int) : ViewState()
        data class ChangeText(val viewId: Int, val text: String) : ViewState()
    }
}