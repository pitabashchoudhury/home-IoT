package com.tata.homeiot.ui.components

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RoomTabs(
    rooms: List<String>,
    selectedRoom: String,
    onRoomSelected: (String) -> Unit
) {
    ScrollableTabRow(selectedTabIndex = rooms.indexOf(selectedRoom)) {
        rooms.forEach { room ->
            Tab(
                selected = room == selectedRoom,
                onClick = { onRoomSelected(room) },
                text = { Text(room) }
            )
        }
    }
}
