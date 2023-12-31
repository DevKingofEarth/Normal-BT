package com.demo.btdatatransfer.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.btdatatransfer.domain.chat.BluetoothDevice
import com.demo.btdatatransfer.domain.chat.BluetoothDeviceDomain

@Composable
fun DeviceScreen(
    state: BluetoothUiState,
    onStartScan : () -> Unit,
    onStopScan : () -> Unit,
    onStartServer : () -> Unit,
    onDeviceClick:(BluetoothDeviceDomain)->Unit,
){

    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        BluetoothDeviceList(
            pairedDevices = state.pairedDevices,
            scannedDevices = state.scannedDevices,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            onDeviceClick(it)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = onStartScan
            ){
                Text("Start Scan")
            }
            Button(
                onClick = onStopScan
            ){
                Text("Stop Scan")
            }
            Button(
                onClick = onStartServer
            ){
                Text("Start Server")
            }
        }
    }

}

@Composable
fun BluetoothDeviceList(
    pairedDevices : List<BluetoothDeviceDomain>,
    scannedDevices : List<BluetoothDeviceDomain>,
    modifier: Modifier = Modifier,
    onClick : (BluetoothDeviceDomain) -> Unit
){

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Paired Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        items(pairedDevices){device->
            Text(
                text = device.name.toString() +"  add = "+ device.address,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(device)
                    }
                    .padding(16.dp)
            )
        }

        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        items(scannedDevices){device->
            Text(
                text = device.name.toString() +"  add = "+ device.address,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(device)
                    }
                    .padding(16.dp)
            )
        }
    }

}














