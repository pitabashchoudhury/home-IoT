package com.tata.homeiot.ui.home



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.smarthome.domain.repository.SmartHomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    //private val repository: SmartHomeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
//            repository.getHomeData().collect { homeData ->
//                _uiState.update { currentState ->
//                    currentState.copy(
//                        userName = homeData.userName,
//                        location = homeData.location,
//                        temperature = homeData.temperature,
//                        lightsOn = homeData.lightsOn,
//                        fansOn = homeData.fansOn,
//                        cctvActive = homeData.cctvActive,
//                        plugsOff = homeData.plugsOff,
//                        rooms = homeData.rooms,
//                        userLocation = homeData.userLocation,
//                        homeLocation = homeData.homeLocation
//                    )
//                }
//            }

            _uiState.update { currentState ->
                currentState.copy(
                    userName = HomeUiState().userName,
                    location = HomeUiState().location,
                    temperature = HomeUiState().temperature,
                    lightsOn = HomeUiState().lightsOn,
                    fansOn = HomeUiState().fansOn,
                    cctvActive = HomeUiState().cctvActive,
                    plugsOff = HomeUiState().plugsOff,
                    rooms = HomeUiState().rooms,
                    userLocation = HomeUiState().userLocation,
                    homeLocation = HomeUiState().homeLocation
                )
            }
        }
    }

    fun toggleLights() {
        viewModelScope.launch {
           // repository.toggleAllLights()
        }
    }

    fun toggleFans() {
        viewModelScope.launch {
           // repository.toggleAllFans()
        }
    }

    fun togglePlugs() {
        viewModelScope.launch {
           // repository.toggleAllPlugs()
        }
    }

    fun navigateToCCTV() {
        // Handle navigation to CCTV screen
    }

    fun navigateToRoom(room: Room) {
        // Handle navigation to room details
    }

    fun navigateToAllRooms() {
        // Handle navigation to all rooms screen
    }
}

data class HomeUiState(
    val userName: String = "Pritabash",
    val location: String = "Bengaluru",
    val temperature: Int = 26,
    val lightsOn: Int = 5,
    val fansOn: Int = 2,
    val cctvActive: Int = 3,
    val plugsOff: Int = 4,
    val rooms: List<Room> = emptyList(),
    val userLocation: Pair<Double, Double> = Pair(0.0, 0.0),
    val homeLocation: Pair<Double, Double> = Pair(0.0, 0.0),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class Room(
    val id: String,
    val name: String,
    val icon: String,
    val backgroundColor: androidx.compose.ui.graphics.Color,
    val deviceCount: Int,
    val devicesOn: Int
)