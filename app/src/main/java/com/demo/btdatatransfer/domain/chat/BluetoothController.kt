package com.demo.btdatatransfer.domain.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val isConnected : StateFlow<Boolean>
    val scannedDevices : StateFlow<List<BluetoothDeviceDomain>>
    val pairedDevices : StateFlow<List<BluetoothDeviceDomain>>
    val error : SharedFlow<String>

    fun startDiscovery()
    fun stopDiscovery()

    // launch the server "Device A"
    fun startBluetoothServer() : Flow<ConnectionResult>

    // connect to the server "Device B"
    fun connectToDevice(device : BluetoothDeviceDomain) : Flow<ConnectionResult>

    suspend fun trySendMessage(message : String):BluetoothMessage?

    fun closeConnection()

    fun release()
}