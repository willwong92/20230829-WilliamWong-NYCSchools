package com.example.a20230829_williamwong_nycschools.detail

import app.cash.turbine.test
import com.example.a20230829_williamwong_nycschools.MainCoroutineRule
import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.sat.usecase.GetSatResults
import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.presentation.ui.detail.SchoolSatDetailViewModel
import com.example.a20230829_williamwong_nycschools.presentation.ui.detail.state.SchoolSatDetailUiState
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
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
class SchoolSatDetailViewModelTest {

    @MockK
    private val getSatResults: GetSatResults = mockk()

    private lateinit var viewModel: SchoolSatDetailViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val coroutineRule = MainCoroutineRule(testDispatcher)

    @Before
    fun setUp() {
        viewModel = SchoolSatDetailViewModel(getSatResults)
    }

    @Test
    fun test_state_get_schools() = runTest {
        val schoolId = "1"

        val successUiState =
            SatResult(
                id = "1",
                schoolName = "fakeSchool",
                testTakers = "20",
                criticalReadingAvgScore = "20",
                mathAvgScore = "20",
                writingAvgScore = "20"
            )
        coEvery { (getSatResults.invoke(schoolId)) }.returns(Result.Success(successUiState))

        viewModel.getSchoolSatDetail(schoolId)

        viewModel.uiState.test {
            val emission: SchoolSatDetailUiState = awaitItem()
            assertThat(emission.showLoading).isFalse()
            assertThat(emission.errorMessage).isNull()
            assertThat(emission.schoolName).isNotEqualTo("")
            assertThat(emission.testTakers).isNotEqualTo("")
            assertThat(emission.writingAvgScore).isNotEqualTo("")
            assertThat(emission.criticalReadingAvgScore).isNotEqualTo("")
            assertThat(emission.mathAvgScore).isNotEqualTo("")
        }
    }
}