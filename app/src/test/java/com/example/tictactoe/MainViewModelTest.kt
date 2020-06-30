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



}