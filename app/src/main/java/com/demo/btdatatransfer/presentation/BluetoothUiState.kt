package com.demo.btdatatransfer.presentation

import com.demo.btdatatransfer.domain.chat.BluetoothDeviceDomain
import com.demo.btdatatransfer.domain.chat.BluetoothMessage

data class BluetoothUiState(
    val scannedDevices : List<BluetoothDeviceDomain> = emptyList(),
    val pairedDevices : List<BluetoothDeviceDomain> = emptyList(),
    val isConnected : Boolean = false,
    val isConnecting : Boolean = false,
    val errorMessage : String? = null,
    val messages : List<BluetoothMessage> = emptyList()
)
