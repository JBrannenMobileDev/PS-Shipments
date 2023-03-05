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
        val assignments: List<Assignment> = listOf()
    )

    sealed interface Event {
        object NotUsedEvent : Event  //Sample event. If we needed any events they would go here
    }

    init {
        viewModelScope.launch {
            assignmentRepository.getAssignments().collect {
                reduce { state ->
                    state.copy(
                        assignments = it
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