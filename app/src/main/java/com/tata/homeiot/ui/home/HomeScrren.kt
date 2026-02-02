package com.tata.homeiot.ui.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(

) {
    val viewModel: HomeViewModel = androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel();
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                HeaderSection(
                    userName = uiState.userName,
                    location = uiState.location,
                    temperature = uiState.temperature
                )
            }

            item {
                QuickControlsSection(
                    lightsOn = uiState.lightsOn,
                    fansOn = uiState.fansOn,
                    cctvActive = uiState.cctvActive,
                    plugsOff = uiState.plugsOff,
                    onLightsClick = { viewModel.toggleLights() },
                    onFansClick = { viewModel.toggleFans() },
                    onCCTVClick = { viewModel.navigateToCCTV() },
                    onPlugsClick = { viewModel.togglePlugs() }
                )
            }

            item {
                RoomsSection(
                    rooms = uiState.rooms,
                    onRoomClick = { room -> viewModel.navigateToRoom(room) },
                    onSeeAllClick = { viewModel.navigateToAllRooms() }
                )
            }

            item {
                MapSection(
                    userLocation = uiState.userLocation,
                    homeLocation = uiState.homeLocation
                )
            }
        }
    }
}

@Composable
fun HeaderSection(
    userName: String,
    location: String,
    temperature: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4A90E2),
                        Color(0xFF5BA3F5)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Good Morning, $userName 👋",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    // Profile image placeholder
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        tint = Color(0xFF4A90E2)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.95f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "09:45 AM | $location",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF2C3E50)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = Color(0xFF4A90E2)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Updated just now",
                                fontSize = 12.sp,
                                color = Color(0xFF4A90E2)
                            )
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(0xFF4A90E2),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$temperature°C",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2C3E50)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "☁️",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuickControlsSection(
    lightsOn: Int,
    fansOn: Int,
    cctvActive: Int,
    plugsOff: Int,
    onLightsClick: () -> Unit,
    onFansClick: () -> Unit,
    onCCTVClick: () -> Unit,
    onPlugsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Quick Controls",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2C3E50)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            QuickControlCard(
                modifier = Modifier.weight(1f),
                icon = "💡",
                title = "Lights",
                status = "$lightsOn ON",
                isActive = true,
                onClick = onLightsClick
            )

            QuickControlCard(
                modifier = Modifier.weight(1f),
                icon = "🌀",
                title = "Fans",
                status = "$fansOn ON",
                isActive = true,
                onClick = onFansClick
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            QuickControlCard(
                modifier = Modifier.weight(1f),
                icon = "📹",
                title = "CCTV",
                status = "$cctvActive Active",
                badge = "LIVE",
                badgeColor = Color(0xFFE74C3C),
                isActive = true,
                onClick = onCCTVClick
            )

            QuickControlCard(
                modifier = Modifier.weight(1f),
                icon = "🔌",
                title = "Plugs",
                status = "${plugsOff} OFF",
                isActive = false,
                onClick = onPlugsClick
            )
        }
    }
}

@Composable
fun QuickControlCard(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    status: String,
    badge: String? = null,
    badgeColor: Color = Color.Red,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = icon,
                    fontSize = 32.sp
                )

                if (badge != null) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = badgeColor
                    ) {
                        Text(
                            text = badge,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                } else {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (isActive) Color(0xFF4A90E2) else Color(0xFFBDC3C7)
                    ) {
                        Text(
                            text = status.split(" ").last(),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2C3E50)
            )

            Text(
                text = status,
                fontSize = 12.sp,
                color = Color(0xFF7F8C8D)
            )
        }
    }
}

@Composable
fun RoomsSection(
    rooms: List<Room>,
    onRoomClick: (Room) -> Unit,
    onSeeAllClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Rooms",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50)
            )

            TextButton(onClick = onSeeAllClick) {
                Text(
                    text = "See All",
                    color = Color(0xFF4A90E2),
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color(0xFF4A90E2)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(360.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            userScrollEnabled = false
        ) {
            items(rooms) { room ->
                RoomCard(
                    room = room,
                    onClick = { onRoomClick(room) }
                )
            }
        }
    }
}

@Composable
fun RoomCard(
    room: Room,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(room.backgroundColor)
            ) {
                Text(
                    text = room.icon,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = room.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2C3E50)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${room.deviceCount} Device${if (room.deviceCount > 1) "s" else ""} • ${room.devicesOn} ON",
                fontSize = 12.sp,
                color = Color(0xFF7F8C8D)
            )
        }
    }
}

@Composable
fun MapSection(
    userLocation: Pair<Double, Double>,
    homeLocation: Pair<Double, Double>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Placeholder for map - in real app, use Google Maps Compose
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE8F4F8))
                ) {
                    Text(
                        text = "🗺️ Map View",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 16.sp,
                        color = Color(0xFF7F8C8D)
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.95f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Living Room",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF2C3E50)
                    )
                    Text(
                        text = "3 Devices • 2 ON",
                        fontSize = 12.sp,
                        color = Color(0xFF7F8C8D)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF4A90E2),
                selectedTextColor = Color(0xFF4A90E2),
                unselectedIconColor = Color(0xFFBDC3C7),
                unselectedTextColor = Color(0xFFBDC3C7),
                indicatorColor = Color(0xFFE3F2FD)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Map"
                )
            },
            label = { Text("Map") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF4A90E2),
                selectedTextColor = Color(0xFF4A90E2),
                unselectedIconColor = Color(0xFFBDC3C7),
                unselectedTextColor = Color(0xFFBDC3C7),
                indicatorColor = Color(0xFFE3F2FD)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "CCTV"
                )
            },
            label = { Text("CCTV") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF4A90E2),
                selectedTextColor = Color(0xFF4A90E2),
                unselectedIconColor = Color(0xFFBDC3C7),
                unselectedTextColor = Color(0xFFBDC3C7),
                indicatorColor = Color(0xFFE3F2FD)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "CCTV"
                )
            },
            label = { Text("CCTV") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF4A90E2),
                selectedTextColor = Color(0xFF4A90E2),
                unselectedIconColor = Color(0xFFBDC3C7),
                unselectedTextColor = Color(0xFFBDC3C7),
                indicatorColor = Color(0xFFE3F2FD)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = { Text("Profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF4A90E2),
                selectedTextColor = Color(0xFF4A90E2),
                unselectedIconColor = Color(0xFFBDC3C7),
                unselectedTextColor = Color(0xFFBDC3C7),
                indicatorColor = Color(0xFFE3F2FD)
            )
        )
    }
}