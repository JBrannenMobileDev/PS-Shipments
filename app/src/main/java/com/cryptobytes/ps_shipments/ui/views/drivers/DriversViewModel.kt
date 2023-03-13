package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.lifecycle.ViewModel
import com.cryptobytes.ps_shipments.data.model.Assignment
import com.cryptobytes.ps_shipments.data.repository.AssignmentRepository
import androidx.lifecycle.viewModelScope
import com.cryptobytes.ps_shipments.ui.uiState.ViewStateDelegate
import com.cryptobytes.ps_shipments.ui.uiState.ViewStateDelegateImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val assignmentRepository: AssignmentRepository,
) : ViewModel(), ViewStateDelegate<DriversViewModel.UiState, DriversViewModel.Event> by ViewStateDelegateImpl(UiState()) {

    data class UiState(
        val selectedAssignment: Assignment? = null,
        val assignments: List<Assignment> = listOf(),
        val totalSS: Double = 0.0
    )

    sealed interface Event {
        object NotUsedEvent : Event  //Sample event. If we needed any events they would go here
    }

    init {
        viewModelScope.launch {
            assignmentRepository.syncRemoteToLocal()
            assignmentRepository.getAllForToday().collect {
                reduce { state ->
                    state.copy(
                        assignments = it,
                        totalSS = it.sumOf { assignment -> assignment.ss }
                    )
                }
            }
        }
    }

    fun itemClicked(item: Assignment){
        viewModelScope.launch {
            reduce { state ->
                state.copy(
                    selectedAssignment = item
                )
            }
        }
    }
}