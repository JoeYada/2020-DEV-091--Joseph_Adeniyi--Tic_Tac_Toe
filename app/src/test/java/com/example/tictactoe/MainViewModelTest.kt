package com.example.tictactoe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @JvmField
    @Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private val fakeButtonId = 1

    @Before
    fun setUp(){
        viewModel = MainViewModel()
    }

    @Test
    fun checkIfPlayer1WinsWithRow1(){
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithRow2(){
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithRow3(){
        viewModel.userClick(2,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithColumn1(){
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithColumn2(){
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithColumn3(){
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithDiagonal1(){
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer1WinsWithDiagonal2(){
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 0 )

    }

    @Test
    fun checkIfPlayer2WinsWithRow1(){
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithRow2(){
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithRow3(){
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithColumn1(){
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithColumn2(){
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithColumn3(){
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithDiagonal1(){
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfPlayer2WinsWithDiagonal2(){
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Win)
        assert((viewModel.viewState.value as MainViewModel.ViewState.Win).winner == 1 )

    }

    @Test
    fun checkIfDraw(){
        viewModel.userClick(0,2,fakeButtonId)
        viewModel.userClick(1,2,fakeButtonId)
        viewModel.userClick(1,1,fakeButtonId)
        viewModel.userClick(2,0,fakeButtonId)
        viewModel.userClick(1,0,fakeButtonId)
        viewModel.userClick(0,0,fakeButtonId)
        viewModel.userClick(2,1,fakeButtonId)
        viewModel.userClick(0,1,fakeButtonId)
        viewModel.userClick(2,2,fakeButtonId)

        assert(viewModel.viewState.value is MainViewModel.ViewState.Draw)

    }
}