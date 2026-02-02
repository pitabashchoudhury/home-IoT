//package com.tata.homeiot.ui.components
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Switch
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun DeviceCard(
//    device: Any,
//    onToggle: (Boolean) -> Unit
//) {
//    Card(
//        modifier = Modifier.padding(8.dp),
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(
//                imageVector = ,
//                contentDescription = device.name
//            )
//            Text(device.name)
//            Switch(
//                checked = device.isOn,
//                onCheckedChange = onToggle
//            )
//        }
//    }
//}
