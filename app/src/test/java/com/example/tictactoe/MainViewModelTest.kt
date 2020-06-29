package com.example.tictactoe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import org.junit.Assert
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

    private lateinit var positions: MutableList<String>
    @MockK
    lateinit var activity: MainActivity
    private lateinit var factory: MainViewModelFactory

    @MockK
    private lateinit var viewModel: MainViewModel

    @MockK
    @Before
    fun setUp(){
        activity = MainActivity()
        factory = MainViewModelFactory()
        viewModel = MainViewModel()
        positions = mutableListOf<String>()


    }

    @Test
    fun checkIfTopRowAreEqual(){
        positions.add("X");        positions.add("X");        positions.add("X")
        positions.add("X");        positions.add("");        positions.add("")
        positions.add("X");        positions.add("");        positions.add("")

        Assert.assertEquals(true, viewModel.checkWin(positions))
    }

    @Test
    fun checkIfTopRowAreUnEqual(){
        positions.add("X");        positions.add("O");        positions.add("X")
        positions.add("O");        positions.add("");        positions.add("")
        positions.add("X");        positions.add("");        positions.add("")

        Assert.assertEquals(false, viewModel.checkWin(positions))
    }

    @Test
    fun checkIfFirstColumnIsUnEqual(){
        positions.add("X");        positions.add("O");        positions.add("X")
        positions.add("O");        positions.add("");        positions.add("")
        positions.add("X");        positions.add("");        positions.add("")

        Assert.assertEquals(false, viewModel.checkWin(positions))
    }

    @Test
    fun checkIfFirstColumnAreEqual(){
        positions.add("X");        positions.add("X");        positions.add("X")
        positions.add("X");        positions.add("");        positions.add("")
        positions.add("X");        positions.add("");        positions.add("")

        Assert.assertEquals(true, viewModel.checkWin(positions))
    }



}