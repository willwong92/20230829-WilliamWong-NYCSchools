package com.example.a20230829_williamwong_nycschools.home

import app.cash.turbine.test
import com.example.a20230829_williamwong_nycschools.MainCoroutineRule
import com.example.a20230829_williamwong_nycschools.domain.school.usecase.GetSchools
import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.presentation.ui.home.HomeViewModel
import com.example.a20230829_williamwong_nycschools.presentation.ui.home.state.HomeUiState
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by William Wong on 09/07/23
 **/
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @MockK
    private val getSchools: GetSchools = mockk()

    private lateinit var viewModel: HomeViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val coroutineRule = MainCoroutineRule(testDispatcher)

    @Before
    fun setUp() {
        viewModel = HomeViewModel(getSchools)
    }

    @Test
    fun test_initial_state_get_schools() = runTest {
        coEvery { (getSchools.invoke()) }.returns(Result.Success(listOf()))

        viewModel.uiState.test {
            val emission: HomeUiState = awaitItem()
            assertThat(emission.showLoading).isTrue()
            assertThat(emission.schools).isEmpty()
            assertThat(emission.errorMessage).isNull()
        }
    }
}